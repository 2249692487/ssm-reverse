package com.test.mapper;

import com.test.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/10
 */
public interface SysUserMapper {
    // 根据用户名 查询用户信息
    SysUser findSysUserByUsername(@Param("username") String username);

    List<SysUser> queryAllSysUserList();

    void addUser(SysUser sysUser);

    SysUser findUserById(@Param("user_id") Long id);


}
