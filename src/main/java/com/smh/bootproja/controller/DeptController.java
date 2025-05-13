package com.smh.bootproja.controller;

import com.smh.bootproja.biz.DeptBiz;
import com.smh.bootproja.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptBiz biz;

    @PostMapping("/modify")
    public Map modify(@RequestBody Dept dept)
    {
        boolean isOk = biz.modifyDept(dept);
        Map map = new HashMap();
        if(isOk){
            map.put("isOk",true);
            map.put("msg","修改成功");
        }else{
            map.put("isOk",false);
            map.put("msg","修改失败");
        }
        return map;
    }
    @PostMapping("/list")
    public Map findAll(@RequestBody Dept dept){
        List<Dept> list = biz.getDeptList(dept);
        Map map = new HashMap();
        map.put("isOk", true);
        map.put("depts", list);
        map.put("msg", "查询成功");
        return map;
    }


    @PostMapping("/del")
    public Map del(@RequestBody Dept dept){
        boolean isOk = biz.removeDept(dept.getDeptId());
        Map map = new HashMap();
        if(isOk){
            map.put("isOk",true);
            map.put("msg","删除成功");
        }else{
            map.put("isOk",false);
            map.put("msg","删除失败");
        }
        return map;
    }
    @PostMapping("/add")
    public Map add(@RequestBody Dept dept){
        boolean isOk = biz.addDept(dept);
        Map map = new HashMap();
        if(isOk){
            map.put("isOk",true);
            map.put("msg","添加成功");
        }else{
            map.put("isOk",false);
            map.put("msg","添加失败");
        }
        return map;
    }



    public void setBiz(DeptBiz biz) {
        this.biz = biz;
    }
}
