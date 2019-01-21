package com.test.controller;

import com.test.pojo.SysRole;
import com.test.pojo.SysUser;
import com.test.service.SysRoleService;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("sysUser")
@Secured({"ROLE_ADMIN"})
public class SysUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SysRoleService sysRoleService;

    // 获取用户名
    @RequestMapping("getUsername")
    // 将字符串直接返回给浏览器
    @ResponseBody
    public String getUsername(HttpSession session) {
        // 1.获取SecurityContext对象
        // 方式一
        SecurityContext securityContext = SecurityContextHolder.getContext();
        // 方式二
        SecurityContext securityContext1 = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
        System.out.println("判断两者是否相等：" + (securityContext == securityContext1));
        // 2.获取认证对象
        Authentication authentication = securityContext.getAuthentication();
        // 3.获取当前依据的用户对象(主角)
        User user = (User) authentication.getPrincipal();
        // 4.返回用户名
        return user.getUsername();
    }

    // 查询所有用户
    @RequestMapping("queryAllSysUserList")
    public String queryAllSysUserList(Model model) {
        List<SysUser> userlist = userService.queryAllSysUserList();
        model.addAttribute("userlist", userlist);
        return "user-list";
    }


    // 跳转到用户添加页面
    @RequestMapping("toAddUserPage")
    public String toAddOrdersPage() {
        return "user-add";
    }

    // 重新查询所有用户且显示
    @RequestMapping("addUser")
    public String addUser(SysUser sysUser) {
        userService.addUser(sysUser);
        return "redirect:/sysUser/queryAllSysUserList";
    }

    // 角色详情
    @RequestMapping("findUserById")
    public String findUserById(@RequestParam("id") Long id, Model model) {
        SysUser sysUser = userService.findUserById(id);
        model.addAttribute("sysUser", sysUser);
        System.out.println("sysUser==" + sysUser);
        return "user-show";
    }


    // 跳转到添加角色
    @RequestMapping("toUpdateUserRolePage")
    public String toUpdateUserRolePage(@RequestParam("id") Long id, Model model) {
        List<SysRole> sysRoleList = sysRoleService.findAllSysRoleList();
        // 2.调用业务层 根据用户编号 查询 选择的角色编号集合
        List<Long> roleIdList = sysRoleService.queryRoleIdList(id);
        model.addAttribute("sysRoleList", sysRoleList);
        model.addAttribute("roleIdList", roleIdList);
        model.addAttribute("id", id);
        return "user-role-add";
    }

    // 添加角色
    @RequestMapping("updateUserRole")
    public String updateUserRole(@RequestParam("id") Long user_id,
                                 @RequestParam(name = "ids", required = false) List<Long> roleIdList) {
        sysRoleService.updateUserRole(user_id, roleIdList);
        return "redirect:/sysUser/queryAllSysUserList";
    }
}
