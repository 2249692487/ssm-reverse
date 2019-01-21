package com.test.service.impl;

import com.test.mapper.SysRoleMapper;
import com.test.pojo.SysRole;
import com.test.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/14
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> findAllSysRoleList() {
        return sysRoleMapper.findAllSysRoleList();
    }

    @Override
    public void addSysRole(SysRole sysRole) {
        sysRoleMapper.addSysRole(sysRole);
    }

    @Override
    public List<Long> queryRoleIdList(Long id) {
        return sysRoleMapper.queryRoleIdList(id);
    }

    @Transactional
    public void updateUserRole(Long user_id, List<Long> roleIdList) {
        sysRoleMapper.deleteRoleByUser(user_id);
        if (roleIdList != null && roleIdList.size() > 0) {
            for (Long role_id : roleIdList) {
                sysRoleMapper.addUserRole(user_id, role_id);
            }
        }
    }
}
