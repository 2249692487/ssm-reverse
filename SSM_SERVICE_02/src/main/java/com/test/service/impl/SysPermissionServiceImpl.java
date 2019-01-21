package com.test.service.impl;

import com.test.mapper.SysPermissionMapper;
import com.test.pojo.SysPermission;
import com.test.service.SysPermissionService;
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
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<SysPermission> findAllPermissionList() {
        return sysPermissionMapper.findAllPermissionList();
    }

    @Override
    public void addPermission(SysPermission sysPermission) {
        sysPermissionMapper.addPermission(sysPermission);
    }

    @Override
    public List<Long> findPermissionIdList(Long role_id) {
        return sysPermissionMapper.findPermissionIdList(role_id);
    }

    @Transactional
    public void updateRoleWithPermission(Long role_id, List<Long> permissionIdList) {
        // 1.解除当前角色和权限的关系 delete
        sysPermissionMapper.deleteRoleWithPerimssion(role_id);
        // 2.新增 当前角色和权限的关系 insert
        if (permissionIdList != null && permissionIdList.size() > 0) {
            for (Long permission_id : permissionIdList) {
                sysPermissionMapper.addRoleWithPermission(role_id, permission_id);
            }
        }
    }
}
