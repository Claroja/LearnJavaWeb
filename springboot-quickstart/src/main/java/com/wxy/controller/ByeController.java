package com.wxy.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//相当于声明Controller - 提共restful 风格
@RequestMapping("bye")
class ByeController {
    @RequestMapping("{name}")//映射路径
    @ResponseBody//响应体
    public String hello(@PathVariable String name) {
        return "Bye " + name;
    }
}