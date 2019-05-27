package web.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import web.model.User;


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
        User user = userMapper.findByUsername("li");
        System.out.println(user);
    }

}