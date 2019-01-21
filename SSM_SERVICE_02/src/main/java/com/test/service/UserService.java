package com.test.service;

import com.test.pojo.SysRole;
import com.test.pojo.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/10
 */
public interface UserService extends UserDetailsService {

    List<SysUser> queryAllSysUserList();

    void addUser(SysUser sysUser);

    SysUser findUserById(Long id);


}
