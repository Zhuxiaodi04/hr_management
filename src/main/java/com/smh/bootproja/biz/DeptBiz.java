package com.smh.bootproja.biz;

import com.smh.bootproja.entity.Dept;
import com.smh.bootproja.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Author:师墨涵
 **/

@Service
public class DeptBiz {
    @Autowired
    DeptMapper mapper;


    public boolean modifyDept(Dept dept) {
        return mapper.modifyDept(dept) > 0;
    }

    public List<Dept> getDeptList(Dept dept) {
        return mapper.getDeptList(dept);
    }

    public boolean removeDept(Integer deptId) {
        if(mapper.getDeptPersonnel(deptId) == 0){
            return mapper.removeDept(deptId) > 0;
        }
        else return false;
    }

    public boolean addDept(Dept dept) {
        return mapper.addDept(dept) > 0;
    }

}
