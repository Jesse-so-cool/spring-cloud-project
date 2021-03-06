package com.jesse.jesseweb.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jesse.jesseweb.entity.Article;
import com.jesse.jesseweb.entity.Role;
import com.jesse.jesseweb.entity.User;
import com.jesse.jesseweb.entity.UserRole;
import com.jesse.jesseweb.enume.RoleEnum;
import com.jesse.jesseweb.mapper.ArticleMapper;
import com.jesse.jesseweb.mapper.RoleMapper;
import com.jesse.jesseweb.mapper.UserMapper;
import com.jesse.jesseweb.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @ResponseBody
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2(String username) {
        return "asdasdad";
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(String username) {
        Role role = new Role(2, "ROLE_user");
        User user = new User("15648424415", "15648424415");
        userRoleMapper.insert(new UserRole(user, role));
        //User user = userMapper.selectByUsername(username);
        return user.toString();
    }

    /*@ResponseBody
    @RequestMapping(value = "/createRole", method = RequestMethod.GET)
    public String createRole(String role) {
        int i = roleMapper.insert(new Role(role));
        return roleMapper.selectByPrimaryKey(i).getRole();
    }*/

    @RequestMapping(value = "/header", method = RequestMethod.GET)
    public String header() {
        for (int i = 0; i < 1; i++) {

        }
        return "header";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(Integer pageNo, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        Integer no = pageNo == null ? 1 : pageNo;
        Integer size = pageSize == null ? 10 : pageSize;
        map = getArticle(map, no, size);
        return new ModelAndView("index", "map", map);
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public ModelAndView login(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }

    @RequestMapping(value = "/githubLogin", method = {RequestMethod.GET})
    public ModelAndView githubLogin() {
        return new ModelAndView("redirect:https://github.com/login/oauth/authorize?client_id=51e1a48f18d8d9bda59c&state=xxx&redirect_uri=http://localhost:8088/oauth/github");
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET})
    public ModelAndView register(String error) {
        return new ModelAndView("register", "error", error == null ? "" : error);
    }

    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(Model model, User user) {
        if (user != null) {
            model.addAttribute("isSuccess", "true");
        }
        return "login";
    }*/

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit() {
        for (int i = 0; i < 1; i++) {

        }

        return "articleEdit";
    }

    public Map<String, Object> getArticle(Map<String, Object> map, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Article> allArticle = articleMapper.getAllArticle();
        map.put("articleList", new PageInfo(allArticle));
        return map;
    }
}
