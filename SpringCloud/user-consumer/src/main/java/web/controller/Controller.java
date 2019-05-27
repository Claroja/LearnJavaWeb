package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import web.model.User;

@RestController
@RequestMapping("user")
public class Controller {

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("queryByUsername/{username}")
    public User queryByUsername(@PathVariable String username){
        System.out.println("query");
        String url = "http://localhost:8000/user/findByUsername/" + username;
        return this.restTemplate.getForObject(url, User.class);
    }
}