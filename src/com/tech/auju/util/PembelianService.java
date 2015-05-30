/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.util;

import com.tech.auju.mappers.PembelianMapper;
import com.tech.auju.mappers.PembelianMapper;
import com.tech.auju.objects.Bahan;
import com.tech.auju.objects.Pembelian;
import com.tech.auju.objects.Retur;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author sora
 */
public class PembelianService implements PembelianMapper {

    @Override
    public List<Bahan> selectBahan() {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            PembelianMapper pembelianMapper = sqlSession.getMapper(PembelianMapper.class);
            return pembelianMapper.selectBahan();
        } finally{
            sqlSession.close();
        }   
    }

    @Override
    public List<Retur> selectRetur() {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            PembelianMapper pembelianMapper = sqlSession.getMapper(PembelianMapper.class);
            return pembelianMapper.selectRetur();
        } finally{
            sqlSession.close();
        }
    }

    @Override
    public List<Bahan> selectMinPembelian(int min) {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            PembelianMapper pembelianMapper = sqlSession.getMapper(PembelianMapper.class);
            return pembelianMapper.selectMinPembelian(min);
        } finally{
            sqlSession.close();
        }
    }

    @Override
    public void insertPembelian(Pembelian pembelian) {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            PembelianMapper pembelianMapper = sqlSession.getMapper(PembelianMapper.class);
            pembelianMapper.insertPembelian(pembelian);
            sqlSession.commit();
        } finally{
            sqlSession.close();
        }  
    }

//    @Override
//    public List<Pembelian> selectStatusPembelian() {
//        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
//        try{            
//            PembelianMapper pembelianMapper = sqlSession.getMapper(PembelianMapper.class);
//            return pembelianMapper.selectStatusPembelian();
//        } finally{
//            sqlSession.close();
//        }
//    }
    
}
