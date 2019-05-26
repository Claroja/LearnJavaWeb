package edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
@MapperScan(basePackages = "edu.dao" )
@ComponentScan(basePackages = {"edu.controller","edu.service","edu.config"})
public class App
{
    public static void main( String[] args )
    {
        //启动springboot项目
        SpringApplication.run(App.class,args);
    }
}
