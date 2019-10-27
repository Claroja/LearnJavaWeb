package web.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import web.model.User;

import java.util.ArrayList;
import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest

public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void register() {
        String username ="www";
        String password = "3232";
        userMapper.save(username,password);
    }

    @Test
    public void select(){
        User user = userMapper.findByUsername("wang");
        System.out.println(user);
    }

    @Test
    public void selectJson(){
        ArrayList list = userMapper.findJson("wang");
        System.out.println(list);
    }
}