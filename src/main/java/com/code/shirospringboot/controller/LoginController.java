package com.code.shirospringboot.controller;

import com.code.shirospringboot.entity.UserEntity;
import com.code.shirospringboot.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private IUserService userService;
    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 主页面 登录方法
     *
     * @return 登录结果
     */
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @ResponseBody
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(HttpServletRequest request, String username, String password) {
        UserEntity entity =  userService.findByUserName(username);
        if (entity != null && entity.getPassword().equals(password)) {
            try {
                UsernamePasswordToken token = new UsernamePasswordToken(entity.getUsername(),entity.getPassword());
                SecurityUtils.getSubject().login(token);
            }catch (Exception e){
                e.printStackTrace();
            }
            request.getSession().setAttribute("username", username);
            return new ModelAndView(new RedirectView("/main"));
        } else {
            if (username != null) request.getSession().setAttribute("errorMsg", "用户名或密码错误");
            return new ModelAndView(new RedirectView("/login"));
        }
    }

    /**
     * 注销登录
     * @param request
     * @return
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        SecurityUtils.getSubject().logout();
        request.getSession().invalidate();
        return "login";
    }

    /**
     * 欢迎登录
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    /**
     * 没有权限
     * @return
     */
    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }



    @ResponseBody
    @RequestMapping("/code")
    public Map<String,String> code(){
        Map<String,String> map = new HashMap<>();
        map.put("code","403");
        return map;
    }

}
