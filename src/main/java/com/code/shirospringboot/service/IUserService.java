package com.code.shirospringboot.service;

import com.code.shirospringboot.entity.UserEntity;

public interface IUserService {
    UserEntity findByUserName(String username);
}
