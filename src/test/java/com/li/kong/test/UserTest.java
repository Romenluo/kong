package com.li.kong.test;

import com.li.kong.entity.Role;
import com.li.kong.entity.User;
import com.li.kong.mapper.UserMapper;
import com.li.kong.utils.DataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserTest {
    private SqlSession session ;
    private DateFormat dateFormat ;

    /*public @Before
    void init() throws IOException {

        dateFormat = new SimpleDateFormat( "G yyyy年MM月dd日 E HH:mm:ss" );

        // 创建一个 SqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        Reader reader = Resources.getResourceAsReader( "mybatis-config.xml" );
        // 创建 SqlSessionFactory 对象
        SqlSessionFactory sessionFactory = builder.build( reader ) ;

        // 开启回话
        this.session = sessionFactory.openSession() ;
    }*/
    public @Test
    void saveTest() throws IOException{
        session = new DataSource().init();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Role role = new Role();
        role.setId(1);
        User user = new User();
        user.setEmail("kong@li.com");
        user.setPassword("123456");
        user.setPetName("门");
        user.setQq("123456789");
        user.setForbidden("N");
        user.setRole(role);
        int count = mapper.save(user);
        session.commit();
        System.out.println(count);
    }
    public @After
    void destory(){
        if( session != null ) {
            session.close();
        }
    }
}
