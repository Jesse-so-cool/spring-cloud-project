package com.jesse.jesseweb.mapper;

import com.jesse.jesseweb.entity.Article;
import com.jesse.jesseweb.entity.UserRole;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ArticleMapper extends Mapper<Article> {
    @Select("select *,deploy_date deployDate,update_date updateDate,view_count viewCount from article where is_deleted='0' and status='published'")
    List<Article> getAllArticle();
}
