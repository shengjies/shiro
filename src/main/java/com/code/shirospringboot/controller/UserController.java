package com.code.shirospringboot.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequiresRoles(value = {"user"})
    @RequestMapping("/page")
    public String user(){
        return "user";
    }
}
