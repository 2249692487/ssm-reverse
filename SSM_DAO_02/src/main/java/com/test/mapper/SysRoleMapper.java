package com.test.mapper;

import com.test.pojo.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/14
 */
public interface SysRoleMapper {
    List<SysRole> findAllSysRoleList();

    void addSysRole(SysRole sysRole);

    // 根据用户编号 查询 选择的角色编号集合
    List<Long> queryRoleIdList(@Param("user_id") Long id);

    void addUserRole(@Param("user_id") Long user_id, @Param("role_id") Long role_id);

    void deleteRoleByUser(@Param("user_id") Long user_id);
}
