package com.code.shirospringboot.mapper;

import com.code.shirospringboot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM test.tab_user where username=#{username} limit 1;")
    UserEntity findByUserName(@Param("username")String username);
}
