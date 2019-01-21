package com.test.controller;

import com.test.pojo.SysLog;
import com.test.pojo.SysPermission;
import com.test.pojo.SysRole;
import com.test.service.SysLogService;
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
@RequestMapping("sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("findAll")
    public String findAllSysLogList(Model model, SysLog sysLog) {
        List<SysLog> sysLogList = sysLogService.findAllSysLogList(sysLog);
        model.addAttribute("sysLogList", sysLogList);
        return "syslog-list";
    }
}
