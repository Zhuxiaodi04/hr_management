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
public class Personnel {
    private Integer personnelId;
    private String name;
    private String sex;
    private String age;
    private String phone;
//    此属性数据库中没有,是为了方便前端向后端发送信息解析方便
    private Integer deptId;
    private String deptName;
}
