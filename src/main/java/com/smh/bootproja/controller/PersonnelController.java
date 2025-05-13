package com.smh.bootproja.controller;

import com.smh.bootproja.biz.PersonnelBiz;
import com.smh.bootproja.entity.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    private PersonnelBiz biz;

    @PostMapping("/modify")
    public Map modify(@RequestBody Personnel personnel)
    {
        boolean isOk = biz.modifyPersonnel(personnel);
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
    public Map findAll(@RequestBody Personnel personnel){
        List<Personnel> list = biz.getPersonnelList(personnel);
        Map map = new HashMap();
        map.put("isOk", true);
        map.put("personnels", list);
        map.put("msg", "查询成功");
        return map;
    }


    @PostMapping("/del")
    public Map del(@RequestBody Personnel personnel){
        boolean isOk = biz.removePersonnel(personnel.getPersonnelId());
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
    public Map add(@RequestBody Personnel personnel){
        boolean isOk = biz.addPersonnel(personnel);
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



    public void setBiz(PersonnelBiz biz) {
        this.biz = biz;
    }
}
