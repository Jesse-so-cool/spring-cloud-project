package com.jesse.jesseweb.service;

import com.jesse.jesseweb.entity.Role;
import com.jesse.jesseweb.enume.RoleEnum;
import com.jesse.jesseweb.entity.CurrentUser;
import com.jesse.jesseweb.entity.User;
import com.jesse.jesseweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限


        User u = userMapper.selectByUsername(username);

        List<GrantedAuthority> authorities = new ArrayList(u.getRoleList().size());

        u.getRoleList().forEach((role -> authorities.add(new SimpleGrantedAuthority(role.getRole()))));

        return new CurrentUser(u, authorities);
    }
}
