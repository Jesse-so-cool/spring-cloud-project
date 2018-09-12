package com.jesse.jesseweb.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;

@Data
public class UserRole {
    @Id
    private Integer id;

    @Transient
    private User user;
    @Transient
    private Role role;


    public UserRole(Integer id, User user, Role role) {
        this.id = id;
        this.user = user;
        this.role = role;
    }
}
