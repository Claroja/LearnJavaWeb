package edu.service;

import edu.model.User;
import edu.service.base.IBaseService;

public interface IUserService extends IBaseService<User> {

    //特有的方法
    public User login (String username, String password);
}






