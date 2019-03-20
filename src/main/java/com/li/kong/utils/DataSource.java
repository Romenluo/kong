package com.li.kong.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DataSource {
    public SqlSession init() throws IOException {
        SqlSession session ;
        // 创建一个 SqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        Reader reader = Resources.getResourceAsReader( "mybatis-config.xml" );
        // 创建 SqlSessionFactory 对象
        SqlSessionFactory sessionFactory = builder.build( reader ) ;

        // 开启回话
        session = sessionFactory.openSession() ;
        return session;
    }
}
