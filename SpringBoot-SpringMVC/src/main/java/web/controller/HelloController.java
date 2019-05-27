package web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("hello.do")

    public String hello() {
        System.out.println("hello");
        return "hello, SpringBoot!";
    }
}