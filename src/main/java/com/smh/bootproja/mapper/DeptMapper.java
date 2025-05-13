package com.smh.bootproja.mapper;

import com.smh.bootproja.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    int modifyDept(Dept dept);

    List<Dept> getDeptList(Dept dept);

    int removeDept(Integer deptId);

    int addDept(Dept dept);

    int getDeptPersonnel(Integer deptId);
}
