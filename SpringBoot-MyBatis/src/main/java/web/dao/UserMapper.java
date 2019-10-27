package web.dao;

import web.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.HashMap;


public interface UserMapper {

    @Insert("insert into public.user (username,password) values (#{username},#{password})")
    public int save(@Param("username") String username, @Param("password") String password);

    @Select("select * from public.user where username = #{username}")
    public User findByUsername(@Param("username") String username);

    @Select("select * from public.user where username = #{username}")
    public ArrayList findJson(@Param("username") String username);
}