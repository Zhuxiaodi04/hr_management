package com.smh.bootproja.biz;

import com.smh.bootproja.entity.Dept;
import com.smh.bootproja.entity.DeptPer;
import com.smh.bootproja.entity.Personnel;
import com.smh.bootproja.mapper.PersonnelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:师墨涵
 **/

@Service
public class PersonnelBiz {
    @Autowired
    PersonnelMapper mapper;

    public boolean modifyPersonnel(Personnel personnel) {
        mapper.updateDeptPer(personnel);
        return mapper.modifyPersonnel(personnel) > 0;
    }

    public List<Personnel> getPersonnelList(Personnel personnel) {
        return mapper.getPersonnelList(personnel);
    }

    public boolean removePersonnel(Integer personnelId) {
        mapper.removeDeptPer(personnelId);
        return mapper.removePersonnel(personnelId) > 0;
    }

    public boolean addPersonnel(Personnel personnel) {
        DeptPer dp = new DeptPer(personnel.getDeptId(), personnel.getPersonnelId());
//        将部门人员关联表插入数据
        mapper.addDeptPer(dp);
        return mapper.addPersonnel(personnel) > 0;
    }

}
