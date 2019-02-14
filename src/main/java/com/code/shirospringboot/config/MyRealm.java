package com.code.shirospringboot.config;

import com.code.shirospringboot.entity.UserEntity;
import com.code.shirospringboot.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;
    @Override
    public String getName() {
        return "MyRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = principals.getPrimaryPrincipal().toString();
        if(username ==null || "".equals(username)) return null;
        UserEntity entity = userService.findByUserName(username);
        if(entity ==null) return null;
        Set<String> roles = new HashSet<>();
        for (String role : Arrays.asList(entity.getRole_code().split(","))) {
            roles.add(role);
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        if(username == null || "".equals(username))return null;
        UserEntity entity =  userService.findByUserName(username);
        if(entity == null) return  null;
        return new SimpleAuthenticationInfo(entity.getUsername(),entity.getPassword(),getName());
    }
}
