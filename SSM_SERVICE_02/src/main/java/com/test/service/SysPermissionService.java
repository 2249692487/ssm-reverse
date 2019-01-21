package com.test.service;

import com.test.pojo.SysPermission;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/14
 */
public interface SysPermissionService {
    List<SysPermission> findAllPermissionList();

    void addPermission(SysPermission sysPermission);

    List<Long> findPermissionIdList(Long role_id);

    void updateRoleWithPermission(Long role_id, List<Long> permissionIdList);
}
