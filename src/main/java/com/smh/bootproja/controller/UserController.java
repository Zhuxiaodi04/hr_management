package com.smh.bootproja.controller;

import com.smh.bootproja.biz.UserBiz;
import com.smh.bootproja.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value="/user", produces = "application/json;charset=utf-8")
public class UserController {
    @Autowired
    private UserBiz userBiz;

    @PostMapping("/login")
    public Map login(@RequestBody User user, HttpSession session) {

        Map result = new HashMap<>();
        user = userBiz.getUserByAccount(user.getAccount());
        if(user == null){
            result.put("isOk",false);
            result.put("msg","用户不存在");
            return result;
        }else{
            if(!user.getPassword().equals(user.getPassword())){
                result.put("isOk",false);
                result.put("msg","用户名或密码错误");
                return result;
            }else {
                result.put("isOk",true);
                result.put("msg","登录成功");
                result.put("user",user);
                session.setAttribute("login_user",user);
                System.out.println("session:"+session.getAttribute("login_user").toString());
                return result;
            }
        }
    }

    @PostMapping("/register")
    public Map register(@RequestBody User user) {
        System.out.println("user:"+user.getAccount());
        Map result = new HashMap<>();
        User user1 = userBiz.getUserByAccount(user.getAccount());
        if(user1 == null){
            int q = userBiz.addUser(user);
            result.put("isOk",true);
            result.put("msg","注册成功,请登录");
            return result;
        }else{
            result.put("isOk",false);
            result.put("msg","用户已存在");
            return result;
        }
    }

    @GetMapping("/logout")
    public Map logout(HttpSession session){
        // 清除session中的"login_user"属性，实现用户登出
        session.removeAttribute("login_user");
        // 可选：设置session过期时间，立即失效
        session.setMaxInactiveInterval(0);
        Map map = new HashMap();
        map.put("isOk",true);
        map.put("msg","退出成功");
        // 提示用户已登出
        System.out.println("User has been logged out.");
        return map;
    }


}
