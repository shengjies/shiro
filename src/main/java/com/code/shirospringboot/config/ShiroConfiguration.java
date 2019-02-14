package com.code.shirospringboot.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Configuration
public class ShiroConfiguration {
    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm());
        return securityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new HashMap<>();
        //对所有用户认证
        map.put("/toLogin","anon");
        map.put("/code","anon");
        map.put("/**","authc");
        filterFactoryBean.setLoginUrl("/login");
        filterFactoryBean.setSuccessUrl("/main");
        filterFactoryBean.setUnauthorizedUrl("/unauthorized");
        filterFactoryBean.setFilterChainDefinitionMap(map);
        return filterFactoryBean;
    }


    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


//    @Bean
//    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
//        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
//        Properties properties = new Properties();
//        properties.setProperty("org.apache.shiro.authz.UnauthorizedException","/unauthorized");
//        simpleMappingExceptionResolver.setExceptionMappings(properties);
//        return  simpleMappingExceptionResolver;
//    }
}
