package com.jesse.jesseweb.mapper;

import com.jesse.jesseweb.entity.User;
import com.jesse.jesseweb.enume.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getOne(Long id);

    @Insert("INSERT INTO user(id,username,password,role) VALUES(#{id},#{username}, #{password}, #{role})")
    @Results({
            @Result(property = "role", column = "role", javaType = Role.class),
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
    })
    User insert(User user);

    @Update("UPDATE user SET userName=#{username},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

}
