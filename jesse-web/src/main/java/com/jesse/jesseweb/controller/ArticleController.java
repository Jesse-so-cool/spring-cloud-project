package com.jesse.jesseweb.controller;

import com.jesse.jesseweb.entity.Article;
import com.jesse.jesseweb.entity.CurrentUser;
import com.jesse.jesseweb.enume.ArticleStatusEnum;
import com.jesse.jesseweb.mapper.ArticleMapper;
import com.jesse.jesseweb.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/article")
@Controller
public class ArticleController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private ArticleMapper articleMapper;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView articleInfoView(@PathVariable("id") Integer id) {
        Article article = articleMapper.selectOne(new Article(id));
        return new ModelAndView("articleInfo", "article", article);
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ModelAndView submitArticle(String title, String content, String status) {
        CurrentUser userDetails = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        Article article = new Article();
        article.setUsername(userDetails.getUsername());
        article.setUserId(userDetails.getUser().getId());
        article.setContent(content);
        article.setStatus(status);
        article.setViewCount(0);
        article.setTitle("".equals(title) ? "Title" : title);
        if (ArticleStatusEnum.PUBLISHED.getCode().equals(status)) {
            article.setDeployDate(new Date(System.currentTimeMillis()));
        }
        article.setUpdateDate(new Date(System.currentTimeMillis()));
        articleMapper.insert(article);
        return new ModelAndView("redirect:/index");
    }
}
