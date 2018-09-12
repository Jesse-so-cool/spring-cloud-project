package com.jesse.jesseweb.mapper;

import com.jesse.jesseweb.entity.User;
import com.jesse.jesseweb.enume.RoleEnum;
import com.jesse.jesseweb.vo.UserVo;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {


    @Select("select * from user where username=#{username}")
    @Results(id = "BaseResultMap", value = {
            @Result(property = "roleList", column = "id", javaType = List.class,
                    many = @Many(select = "com.jesse.jesseweb.mapper.RoleMapper.selectByUserId"))
    })
    User selectByUsername(String username);


}
