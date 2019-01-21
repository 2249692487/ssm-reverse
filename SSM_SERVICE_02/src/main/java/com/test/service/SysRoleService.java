package com.test.service;

import com.test.pojo.SysRole;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/14
 */
public interface SysRoleService {
    List<SysRole> findAllSysRoleList();

    void addSysRole(SysRole sysRole);

    List<Long> queryRoleIdList(Long id);

    void updateUserRole(Long user_id, List<Long> roleIdList);
}
