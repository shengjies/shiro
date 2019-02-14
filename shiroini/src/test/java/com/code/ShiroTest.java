package com.code;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class ShiroTest {

    @Test
    public void test(){

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        SecurityManager manager = factory.getInstance();

        SecurityUtils.setSecurityManager(manager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","666");

        try {

            subject.login(token);

        }catch (Exception e){

        }

        System.out.println(subject.isAuthenticated());

        subject.logout();

        System.out.println(subject.isAuthenticated());

    }
}
