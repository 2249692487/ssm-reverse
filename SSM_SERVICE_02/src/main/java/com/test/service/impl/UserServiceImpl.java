package com.test.service.impl;

import com.test.mapper.SysUserMapper;
import com.test.pojo.SysRole;
import com.test.pojo.SysUser;
import com.test.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/1/13
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 第一种
//        SysUser sysUser = sysUserMapper.findSysUserByUsername(username);
//        ArrayList<GrantedAuthority> grantedAuthoritieList = new ArrayList<>();
//        grantedAuthoritieList.add(new SimpleGrantedAuthority("ROLE_USER"));
//        User user = new User(username, sysUser.getPassword(), grantedAuthoritieList);
//        return user;
        // 第二种
        SysUser sysUser = sysUserMapper.findSysUserByUsername(username);
        List<SysRole> sysRoleList = sysUser.getSysRoleList();
        System.out.println("sysUser=============================="+sysUser);
        // 返回userDetails接口实现类
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        if (sysRoleList != null && sysRoleList.size() > 0) {
            for (SysRole sysRole : sysRoleList) {
                // 授权
                grantedAuthorityList.add(new SimpleGrantedAuthority(sysRole.getRoleName()));
                System.out.println("RoleName===============" + sysRole.getRoleName());
            }
        }
        User user = new User(username, sysUser.getPassword(), grantedAuthorityList);
        return user;

    }

    @Override
    public List<SysUser> queryAllSysUserList() {
        return sysUserMapper.queryAllSysUserList();
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void addUser(SysUser sysUser) {
        String oldPws = sysUser.getPassword();
        String newPWD = passwordEncoder.encode(oldPws);
        System.out.println("newPWD========================" + newPWD);
        // 3.使用新密码 替换 旧密码
        sysUser.setPassword(newPWD);
        sysUserMapper.addUser(sysUser);
    }

    @Override
    public SysUser findUserById(Long id) {
        return sysUserMapper.findUserById(id);
    }
}


















