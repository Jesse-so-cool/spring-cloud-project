package com.jesse.jesseweb.mapper;

import com.jesse.jesseweb.entity.Role;
import com.jesse.jesseweb.entity.UserRole;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface UserRoleMapper extends Mapper<UserRole> {
    /*@Select("select * from user_role where user_id=#{userId}")
    @Results({
            @Result(property="user.id",column="user_id"),
            @Result(id=true,property="id" ,column="id"),
            @Result(property = "role",column = "user_id",javaType = Role.class,
                    one = @One(select = "com.jesse.jesseweb.mapper.RoleMapper.selectByPrimaryKey"))

    })
    List<UserRole> selectByUserId(String userId);*/
}
