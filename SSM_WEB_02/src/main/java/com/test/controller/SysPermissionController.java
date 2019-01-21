package com.test.controller;

import com.test.pojo.SysPermission;
import com.test.pojo.SysUser;
import com.test.service.SysPermissionService;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/14
 */
@Controller
@RequestMapping("sysPermission")
public class SysPermissionController {
    @Autowired
    private SysPermissionService sysPermissionService;

    @RequestMapping("findAllPermissionList")
    public String findAllPermissionList(Model model) {
        List<SysPermission> sysPermissionList = sysPermissionService.findAllPermissionList();
        model.addAttribute("sysPermissionList", sysPermissionList);
        return "permission-list";
    }

    // 跳转
    @RequestMapping("toAddPermissionPage")
    public String toAddPermissionPage() {
        return "permission-add";
    }
    // 添加
    @RequestMapping("addPermission")
    public String addPermission(SysPermission sysPermission){
        sysPermissionService.addPermission(sysPermission);
        return "redirect:/sysPermission/findAllPermissionList";
    }
    //
}
