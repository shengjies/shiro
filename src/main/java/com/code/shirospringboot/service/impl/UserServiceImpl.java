package com.code.shirospringboot.service.impl;

import com.code.shirospringboot.entity.UserEntity;
import com.code.shirospringboot.mapper.UserMapper;
import com.code.shirospringboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity findByUserName(String username) {
        return userMapper.findByUserName(username);
    }
}
