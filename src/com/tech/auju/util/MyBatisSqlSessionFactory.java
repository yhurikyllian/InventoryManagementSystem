/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author sora
 */
public class MyBatisSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;
        
    public static SqlSessionFactory getSqlSessionFactory() {
        if(sqlSessionFactory==null){
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException ex) {
                Logger.getLogger(MyBatisSqlSessionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sqlSessionFactory;
    }
    
    public static SqlSession openSession(){
        return getSqlSessionFactory().openSession();
    }
}
