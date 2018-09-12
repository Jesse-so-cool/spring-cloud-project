package com.jesse.jesseweb.controller;

import com.jesse.jesseweb.entity.Role;
import com.jesse.jesseweb.entity.User;
import com.jesse.jesseweb.enume.RoleEnum;
import com.jesse.jesseweb.mapper.RoleMapper;
import com.jesse.jesseweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    /*@ResponseBody
    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String createUser(String username) {
        User user = userMapper.insert(new User(username, "password", RoleEnum.USER));
        return user.toString();
    }*/

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(String username) {
        User user = userMapper.selectByUsername(username);
        return user.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/createRole", method = RequestMethod.GET)
    public String createRole(String role) {
        int i = roleMapper.insert(new Role(role));
        return roleMapper.selectByPrimaryKey(i).getRole();
    }

    @RequestMapping(value = "/header", method = RequestMethod.GET)
    public String header() {
        for (int i = 0; i < 1; i++) {

        }
        return "header";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        for (int i = 0; i < 1; i++) {

        }
        return "index";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public ModelAndView login(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
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
}
