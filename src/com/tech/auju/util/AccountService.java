/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.util;

import com.tech.auju.mappers.AccountMapper;
import com.tech.auju.objects.Account;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author sora
 */
public class AccountService implements AccountMapper{

    @Override
    public int accountCount(String user, String pass, String section) {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            AccountMapper formMapper = sqlSession.getMapper(AccountMapper.class);
            return formMapper.accountCount(user, pass, section);
        } finally{
            sqlSession.close();
        }     
    }

    @Override
    public ArrayList<Account> test() {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            AccountMapper formMapper = sqlSession.getMapper(AccountMapper.class);
            return formMapper.test();
        } finally{
            sqlSession.close();
        }   
    }
    
    
}
