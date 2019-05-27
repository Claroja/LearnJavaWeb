package web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication//包含了以下三个注解
//@SpringBootConfiguration 和@Configuration一样不过名字不一样
//@EnableAutoConfiguration 开启自动配置
//@ComponentScan 相当于xml中的<context:component-scan>，自动扫描注解，默认从被注解的类扫描(这里是App类所在的web包)
public class App
{
    public static void main( String[] args )
    {
        //启动springboot项目

        SpringApplication.run(App.class,args);
    }
}
