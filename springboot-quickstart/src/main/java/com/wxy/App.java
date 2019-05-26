package com.wxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration//自动配置，相当于之前配置spring
@ComponentScan(basePackages = "com.wxy.controller")
public class App {
    public static void main(String[] args) {
        //启动程序，很像flask
        SpringApplication.run(App.class, args);
    }
}
