package com.test.aspect;

import com.test.pojo.SysLog;
import com.test.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/16
 */
// @Aspect 表示当前类是一个切面类, 增强类
@Component
@Aspect

public class LogAspect {
    @Autowired
    private SysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;

    // 需求: 增加日志
    // 建立关系
    @Before("execution(* com.test.controller.*.*(..))")

    public void before(JoinPoint joinPoint) {
        // 2.组装数据
        SysLog sysLog = new SysLog();
        // 2.1 设置当前时间
        sysLog.setVisitTime(new Date());
        // 2.2 设置用户名
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        sysLog.setUsername(user.getUsername());
        // 2.3 获取用户的ip地址 request.getRemoteAddr();
        String ip = request.getRemoteAddr();
        sysLog.setIp(ip);
        // 2.4 获取访问的url
        String uri = request.getRequestURI();
        sysLog.setMethod(uri);

        // 1.调用业务层 记录日志
        sysLogService.addSysLog(sysLog);
    }
}
