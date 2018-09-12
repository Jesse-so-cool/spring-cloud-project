package com.jesse.jesseweb.mapper;

import com.jesse.jesseweb.entity.Role;
import com.jesse.jesseweb.entity.UserRole;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface RoleMapper extends Mapper<Role> {
    @Select("select r.id id,r.role role from user_role ur left join role r on ur.role_id = r.id where ur.user_id=#{userId}")
    @Results(id = "BaseResultMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "role", column = "role")
    })
    List<Role> selectByUserId(String userId);
}
