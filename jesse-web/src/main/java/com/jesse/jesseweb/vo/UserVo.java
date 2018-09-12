package com.jesse.jesseweb.vo;

import com.jesse.jesseweb.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserVo {
    private Integer id;

    private String username;

    private String password;

    private List<Role> roleList;


    public UserVo(Integer id, String username, String password, List<Role> roleList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleList = roleList;
    }
}
