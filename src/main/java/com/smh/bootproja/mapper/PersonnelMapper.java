package com.smh.bootproja.mapper;

import com.smh.bootproja.entity.DeptPer;
import com.smh.bootproja.entity.Personnel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonnelMapper {

    int modifyPersonnel(Personnel personnel);

    List<Personnel> getPersonnelList(Personnel personnel);

    int removePersonnel(Integer personnelId);

    int addPersonnel(Personnel personnel);

    void addDeptPer(DeptPer dp);

    void removeDeptPer(Integer personnelId);

    void updateDeptPer(Personnel personnel);
}
