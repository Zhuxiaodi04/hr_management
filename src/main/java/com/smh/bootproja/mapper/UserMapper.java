package com.smh.bootproja.mapper;

import com.smh.bootproja.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User getUserByAccount(String account);

    int addUser(User user);
}
