package edu.controller;

import edu.model.User;
import edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

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

    ////接下来是测试登录和拦截

    //1.登录界面
    @RequestMapping("login")
    public String login(){
        return "login";
    }


    //2.对登录进行判断，如果成功则跳转到loginsuccess页面


    // 相当于RequestMapping（value="/user/login", method="post"）
//    @PostMapping(value = "/check")
    @RequestMapping("/check")
    // 获得request的参数
    public String check(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        // 暂不涉及数据库
        if ("wang".equals(username) && "123456".equals(password)) {//密码和账号
            // 登录成功，就跳转到下一个页面
            System.out.println("s");
            session.setAttribute("username",username);
            return "loginsuccess";
        } else {
            // 登录失败，刷新本登录页
            System.out.println("f");
            return "login";
        }
    }


    //只有当登录了才能访问，否则会被拦截
    @RequestMapping("loginsuccess")
    public String loginSuccess(){
        return "loginsuccess";
    }


}
