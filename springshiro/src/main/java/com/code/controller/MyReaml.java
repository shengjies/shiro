package com.code.controller;

import com.code.entity.UserEntity;
import com.code.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyReaml extends AuthorizingRealm {

    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public String getName() {
        return "MyReaml";
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
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

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        if(username ==null || "".equals(username)) return null;
        UserEntity entity = userService.findByUserName(username);
        if(entity ==null) return null;
        return new SimpleAuthenticationInfo(entity.getUsername(),entity.getPassword(),getName());
    }
}
