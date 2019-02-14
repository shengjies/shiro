package com.code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 用户界面
     * @return
     */
    @RequestMapping("/page")
    public String user(){
        return "user";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String userHello(){
        return "User Hello";
    }
}
