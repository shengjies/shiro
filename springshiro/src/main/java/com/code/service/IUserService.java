package com.code.service;

import com.code.entity.UserEntity;

public interface IUserService {
    /**
     * 按照用户名查询用户信息
     * @param username
     * @return
     */
    UserEntity findByUserName(String username);
}
