package com.jesse.jesseweb.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author Jesse
 */
@Data
@ToString
public class User {

    @Id
    private Integer id;

    private String username;

    private String password;

    @Transient
    private List<Role> roleList;


    private User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String username, String password, List<Role> roleList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleList = roleList;
    }


}
