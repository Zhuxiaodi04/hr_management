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
public class Dept {
    private Integer deptId;
    private String deptName;
    private String deptDesc;
    private String deptCode;
}
