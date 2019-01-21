package com.test.service;

import com.test.pojo.SysLog;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/16
 */
public interface SysLogService {
    void addSysLog(SysLog sysLog);

    List<SysLog> findAllSysLogList(SysLog sysLog);
}
