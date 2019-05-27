package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HelloController {

    @Autowired
    private DataSource dataSource;//同过@Bean注册方法获得的

    @GetMapping("hello")
    public String hello() {
        return "hello, SpringBoot!" + dataSource;
    }
}