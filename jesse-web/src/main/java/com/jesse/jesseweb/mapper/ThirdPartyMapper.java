package com.jesse.jesseweb.mapper;

import com.jesse.jesseweb.entity.Article;
import com.jesse.jesseweb.entity.ThirdParty;
import com.jesse.jesseweb.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ThirdPartyMapper extends Mapper<ThirdParty> {
    @Select("select * from thirdparty where tag=#{tag}")
    ThirdParty selectByTag(String tag);
}
