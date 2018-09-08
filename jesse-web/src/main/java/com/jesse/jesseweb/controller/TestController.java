package com.jesse.jesseweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        for (int i = 0; i < 1; i++) {

        }
        return "login";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit() {
        for (int i = 0; i < 1; i++) {

        }
        return "articleEdit";
    }
}
