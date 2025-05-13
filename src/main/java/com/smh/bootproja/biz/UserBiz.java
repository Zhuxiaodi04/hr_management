package com.smh.bootproja.biz;

import com.smh.bootproja.entity.User;
import com.smh.bootproja.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:师墨涵
 **/
@Service
public class UserBiz {

    @Autowired
    private UserMapper userMapper;

    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
