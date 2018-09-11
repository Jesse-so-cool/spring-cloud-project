package com.jesse.jesseweb.service;

import com.jesse.jesseweb.enume.Role;
import com.jesse.jesseweb.entity.CurrentUser;
import com.jesse.jesseweb.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        CurrentUser user = new CurrentUser(new User(username, "2", Role.USER));
        return user;
    }
}
