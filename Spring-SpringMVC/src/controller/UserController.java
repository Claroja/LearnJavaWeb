package controller;

import model.User;
import model.UserJson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;


@Controller//声明该类用注释
@RequestMapping("/user")//访问类的路径
public class UserController{

    ////1 访问页面
    @RequestMapping("/register")//访问方法的路径

    public String toRegister(){

        return "user/register";//返回注册页面
    }

    // 转发
    @RequestMapping("/forward")
    public String froward(){
        //同一个控制器转发
        return "forward:register.do";
    }

    // 重定向
    @RequestMapping("/redirect")
    public String redirect(){
        //同一个控制器转发
        return "redirect:register.do";
    }


    ////2 get方法传参
    //form表单的get请求和在url中拼贴? &是等价的,下面的演示都适用url
    //1.普通get方法，既? &类型
    @RequestMapping("/get")
    public String getMethod(Integer uid, Model model){
        System.out.println(uid);
        model.addAttribute("uid",uid);
        return "user/getview";
    }
    //2.restfull风格get方法.所谓restfull风格就是将参数放在url的斜杠里面
    @RequestMapping("/getrest/{uid}")
    public String getMethodRest(@PathVariable Integer uid, Model model){
        System.out.println(uid);
        model.addAttribute("uid",uid);
        return "user/getrestview";
    }


    ////3 post方法传参
    //1.获取表单参数方法：将表单提交的参数写入controller方法的参数里
    @RequestMapping(value ="/login",method = RequestMethod.POST)
    public String register(String username,String password,
                           int age,String gender,Date birthday,
                           String[] hobbyIds){

        System.out.println(username);
        System.out.println(password);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(birthday);
        System.out.println(Arrays.toString(hobbyIds));
        return "user/info";
    }


    //2.获取表单参数方法：将表单提交的参数通过model获取
    @RequestMapping(value ="/login2",method = RequestMethod.POST)
    public String register2(User user, Model model){
        System.out.println(user);
        model.addAttribute("user",user);
        return "user/info";
    }



    ////json
    //1.普通方式处理
    @RequestMapping("/registerjson1")
    public String hello(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获得json格式数据
        StringBuffer jb = new StringBuffer();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null)
            jb.append(line);
        //返回json格式数据
        PrintWriter out = response.getWriter();
        out.append(jb.toString());
        return null;
    }



    //2.包装好的json类
    @RequestMapping("/registerjson2")
    public @ResponseBody UserJson registerjson(@RequestBody UserJson userJson){
        return userJson;
    }
}