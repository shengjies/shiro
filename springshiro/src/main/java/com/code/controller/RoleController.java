package com.code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {

    @RequestMapping("/page")
    public String page(){
        return "role";
    }
}
