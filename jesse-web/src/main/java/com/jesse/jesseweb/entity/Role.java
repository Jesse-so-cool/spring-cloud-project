package com.jesse.jesseweb.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Role {

    @Id
    private Integer id;


    private String role;

    public Role(String role) {
        this.role = role;
    }

    public Role(Integer id, String role) {
        this.role = role;
    }
}
