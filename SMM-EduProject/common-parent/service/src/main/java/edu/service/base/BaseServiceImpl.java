package edu.service.base;

import edu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<T> implements  IBaseService<T> {
    //统一管理dao
    @Autowired
    protected UserMapper userMapper;
}
