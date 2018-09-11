package com.jesse.jesseweb.entity;

import com.jesse.jesseweb.enume.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * @author Jesse
 */
@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private Role role;

    //Collection<? extends GrantedAuthority> authorities;

    public User(String username, String password, Role role) {
        this.password = password;
        this.username = username;
        //this.authorities = authorities;
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
