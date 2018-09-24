package com.jesse.jesseweb.controller;

import com.jesse.jesseweb.entity.Message;
import com.jesse.jesseweb.entity.Role;
import com.jesse.jesseweb.entity.User;
import com.jesse.jesseweb.entity.UserRole;
import com.jesse.jesseweb.mapper.ArticleMapper;
import com.jesse.jesseweb.mapper.MessageMapper;
import com.jesse.jesseweb.mapper.UserMapper;
import com.jesse.jesseweb.mapper.UserRoleMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/register")
@Controller
public class RegisterController {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    /*@Autowired
    private UserRoleMapper userRoleMapper;*/

    @RequestMapping(value = "/submitRegister", method = RequestMethod.POST)
    public ModelAndView submitRegister(String phone, String verificationCode, String password, @RequestParam Optional<String> error) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(verificationCode) || StringUtils.isBlank(password)) {
            return new ModelAndView("redirect:/register?error=" + "!!!please check your parameter...");
        }
        if (userMapper.selectByUsername(phone) != null) {
            return new ModelAndView("redirect:/register?error=" + "!!!phone already exited...");
        }
        Example example = new Example(Message.class);
        example.createCriteria().andEqualTo("phone", phone);
        example.setOrderByClause("create_date desc");
        List<Message> messages = messageMapper.selectByExample(example);
        if (messages.size() != 0 && verificationCode.equals(messages.get(0).getValidationCode())) {
            //TODO 写进一个事务  role要处理好点 有空的话
            List<Role> lr = new ArrayList<>();
            lr.add(new Role(2, "ROLE_user"));
            User user = new User(phone, password);
            userMapper.insert(user);
            User idUser = userMapper.selectByUsername(phone);
            for (Role role : lr) {
                userRoleMapper.insert(new UserRole(idUser, role));
            }
        } else {
            return new ModelAndView("redirect:/register?error=" + "!!!verificationCode wrong...");
        }
        return new ModelAndView("login", "error", error);
    }
}
