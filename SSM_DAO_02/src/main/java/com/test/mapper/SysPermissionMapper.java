package com.test.mapper;

import com.test.pojo.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/14
 */
public interface SysPermissionMapper {
    List<SysPermission> findAllPermissionList();

    void addPermission(SysPermission sysPermission);

    // 查询角色携带的权限id集合
    List<Long> findPermissionIdList(@Param("role_id") Long role_id);

    void deleteRoleWithPerimssion(@Param("role_id") Long role_id);

    void addRoleWithPermission(@Param("role_id") Long role_id, @Param("permission_id") Long permission_id);
}
