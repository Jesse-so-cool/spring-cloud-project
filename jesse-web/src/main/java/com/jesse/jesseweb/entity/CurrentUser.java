package com.jesse.jesseweb.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CurrentUser extends org.springframework.security.core.userdetails.User {
    private User user;

    private List<GrantedAuthority> authorities;

    public CurrentUser(User user, List<GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);

        this.authorities = authorities;
        this.user = user;
    }


}
