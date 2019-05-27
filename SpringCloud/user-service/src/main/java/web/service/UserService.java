package web.service;

import web.dao.UserMapper;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void register(String username, String password) {
        userMapper.save(username,password);
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
