package com.smh.bootproja.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:师墨涵
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String account;
    private String password;
    private String username;
}
