package edu.dao;

import edu.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Insert("insert into public.user (username,password) values (#{username},#{password})")
    public int save(@Param("username") String username, @Param("password") String password);

    @Select("select * from public.user where username = #{username}")
    public User findByUsername(@Param("username") String username);
}