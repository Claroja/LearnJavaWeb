package edu.controller;

import edu.model.User;
import edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller //声明Rest风格的控制器
@RequestMapping("user")//url路由
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("register")
    @ResponseBody//设置返回为response体中的内容
    public String register(String username,String password){
        userService.register(username,password);
        return "success";
    }

    @RequestMapping("login")
    public String login(){
        return "/login";
    }

    @RequestMapping("find")
    @ResponseBody
    public User find(String username){
        return userService.findByUsername(username);
    }
}
