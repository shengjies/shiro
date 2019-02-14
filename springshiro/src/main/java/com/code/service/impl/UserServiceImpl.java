package com.code.service.impl;

import com.code.entity.UserEntity;
import com.code.mapper.UserMapper;
import com.code.service.IUserService;
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
