package com.test.controller;

import com.test.pojo.SysPermission;
import com.test.pojo.SysRole;
import com.test.service.SysPermissionService;
import com.test.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/14
 */
@Controller
@RequestMapping("sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("findAllSysRoleList")
    public String findAllSysRoleList(Model model) {
        List<SysRole> sysRoleList = sysRoleService.findAllSysRoleList();
        model.addAttribute("sysRoleList", sysRoleList);
        return "role-list";
    }

    // 跳转到添加
    @RequestMapping("toAddSysRolePage")
    public String toAddSysRolePage() {
        return "role-add";
    }

    // 添加
    @RequestMapping("addSysRole")
    public String addSysRole(SysRole sysRole) {
        sysRoleService.addSysRole(sysRole);
        return "redirect:/sysRole/findAllSysRoleList";
    }

    @Autowired
    private SysPermissionService sysPermissionService;

    // 跳转
    @RequestMapping("toUpdateRolePermissionPage")
    public String toUpdateRolePermissionPage(@RequestParam("role_id") Long role_id, Model model) {
        List<SysPermission> allPermissionList = sysPermissionService.findAllPermissionList();
        model.addAttribute("allPermissionList", allPermissionList);
        // 查询当前角色所属权限的编号集合
        List<Long> permissionIdList = sysPermissionService.findPermissionIdList(role_id);
        model.addAttribute("permissionIdList", permissionIdList);
        model.addAttribute("role_id", role_id);
        return "role-permission-add";
    }


    // 需求: 修改角色携带的权限
    @RequestMapping("addPermissionToRole")
    public String addPermissionToRole(@RequestParam("roleId") Long role_id,
                                      @RequestParam("ids") List<Long> permissionIdList) {
        System.out.println("permissionIdList==================="+permissionIdList);
        // 1.修改角色携带的权限
        sysPermissionService.updateRoleWithPermission(role_id, permissionIdList);
        return "redirect:/sysRole/findAllSysRoleList";
    }
}
