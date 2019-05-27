package test;
import mapper.UserMapper;
import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;


public class test {
    @Test
    public void test1() throws IOException {
        //a)配置文件；
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //b)创建SqlSessionFactory会话
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //c)创建SqlSession。
        SqlSession session = sessionFactory.openSession();
        //d)调用SqlSession的操作数据库方法。
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.findUser(2);
        System.out.println(user);
        //关闭SqlSession。
        session.close();
    }
}
