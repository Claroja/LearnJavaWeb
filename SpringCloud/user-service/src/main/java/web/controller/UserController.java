package web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import web.model.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("findByUsername/{username}")
    @ResponseBody
    public User findByUsername(@PathVariable String username){
        System.out.println("control");
        return userService.findByUsername(username);
    }


}
