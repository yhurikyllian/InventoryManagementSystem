/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.util;

import com.tech.auju.mappers.ProduksiMapper;
import com.tech.auju.objects.Bahan;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author sora
 */
public class ProduksiService implements ProduksiMapper {

    @Override
    public List<Bahan> selectBahan() {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            ProduksiMapper produksiMapper = sqlSession.getMapper(ProduksiMapper.class);
            return produksiMapper.selectBahan();
        } finally{
            sqlSession.close();
        }   
    }

    @Override
    public List<Bahan> selectBahanByName(String name) {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            ProduksiMapper produksiMapper = sqlSession.getMapper(ProduksiMapper.class);
            return produksiMapper.selectBahanByName(name);
        } finally{
            sqlSession.close();
        }  
    }

    @Override
    public void updateJumlahBahan(int amount, int id) {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            ProduksiMapper produksiMapper = sqlSession.getMapper(ProduksiMapper.class);
            produksiMapper.updateJumlahBahan(amount, id);
            sqlSession.commit();
        } finally{
            sqlSession.close();
        } 
    }
    
}
