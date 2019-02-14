package com.code.shirospringboot.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {

    @RequiresRoles(value = {"admin"})
    @RequestMapping("/page")
    public String page(){
        return "role";
    }
}
