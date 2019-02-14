package com.code.mapper;

import com.code.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM test.tab_user where username=#{username} limit 1;")
    UserEntity findByUserName(@Param("username")String username);
}
