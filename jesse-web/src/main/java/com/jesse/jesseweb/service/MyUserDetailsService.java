package com.jesse.jesseweb.service;

import com.jesse.jesseweb.entity.Role;
import com.jesse.jesseweb.enume.RoleEnum;
import com.jesse.jesseweb.entity.CurrentUser;
import com.jesse.jesseweb.entity.User;
import com.jesse.jesseweb.integration.IntegrationAuthentication;
import com.jesse.jesseweb.integration.IntegrationAuthenticationContext;
import com.jesse.jesseweb.integration.IntegrationAuthenticator;
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

    private List<IntegrationAuthenticator> authenticators;

    @Autowired(required = false)
    public void setIntegrationAuthenticators(List<IntegrationAuthenticator> authenticators) {
        this.authenticators = authenticators;
    }

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限

        /**
         * 集成登录操作
         *//*
        IntegrationAuthentication integrationAuthentication = IntegrationAuthenticationContext.get();
        //判断是否是集成登录
        if (integrationAuthentication == null) {
            integrationAuthentication = new IntegrationAuthentication();
        }
        integrationAuthentication.setUsername(username);

        User authenticate = this.authenticate(integrationAuthentication);*/


        User u = userMapper.selectByUsername(username);

        List<GrantedAuthority> authorities = new ArrayList(u.getRoleList().size());

        u.getRoleList().forEach((role -> authorities.add(new SimpleGrantedAuthority(role.getRole()))));

        return new CurrentUser(u, authorities);
    }

    private User authenticate(IntegrationAuthentication integrationAuthentication) {
        if (this.authenticators != null) {
            for (IntegrationAuthenticator authenticator : authenticators) {
                if (authenticator.support(integrationAuthentication)) {
                    return authenticator.authenticate(integrationAuthentication);
                }
            }
        }
        return null;
    }
}
