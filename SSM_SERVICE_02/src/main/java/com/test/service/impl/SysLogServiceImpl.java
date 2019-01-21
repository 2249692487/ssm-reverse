package com.test.service.impl;

import com.test.mapper.SysLogMapper;
import com.test.pojo.SysLog;
import com.test.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/16
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void addSysLog(SysLog sysLog) {
        sysLogMapper.addSysLog(sysLog);
    }

    @Override
    public List<SysLog> findAllSysLogList(SysLog sysLog) {
        return sysLogMapper.findAllSysLogList(sysLog);

    }
}
