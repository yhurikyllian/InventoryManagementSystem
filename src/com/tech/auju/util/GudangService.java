/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.util;

import com.tech.auju.mappers.GudangMapper;
import com.tech.auju.objects.Bahan;
import com.tech.auju.objects.Pembelian;
import com.tech.auju.objects.Retur;
import java.sql.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author sora
 */
public class GudangService implements GudangMapper{

    @Override
    public List<Pembelian> selectPembelian() {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            GudangMapper gudangMapper = sqlSession.getMapper(GudangMapper.class);
            return gudangMapper.selectPembelian();
        } finally{
            sqlSession.close();
        }   
    }

    @Override
    public void insertRetur(Retur retur) {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            GudangMapper gudangMapper = sqlSession.getMapper(GudangMapper.class);
            gudangMapper.insertRetur(retur);
            sqlSession.commit();
        } finally{
            sqlSession.close();
        }  
    }

    @Override
    public List<Retur> selectRetur() {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            GudangMapper gudangMapper = sqlSession.getMapper(GudangMapper.class);
            return gudangMapper.selectRetur();
        } finally{
            sqlSession.close();
        }   
    }

    @Override
    public void insertBahan(Bahan bahan) {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            GudangMapper gudangMapper = sqlSession.getMapper(GudangMapper.class);
            gudangMapper.insertBahan(bahan);
            sqlSession.commit();
        } finally{
            sqlSession.close();
        }  
    }

    @Override
    public void updateJumlahBahan(int amount, int id) {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            GudangMapper gudangMapper = sqlSession.getMapper(GudangMapper.class);
            gudangMapper.updateJumlahBahan(amount, id);
            sqlSession.commit();
        } finally{
            sqlSession.close();
        }  
    }

    @Override
    public void removePembelian(int idPembelian) {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            GudangMapper gudangMapper = sqlSession.getMapper(GudangMapper.class);
            gudangMapper.removePembelian(idPembelian);
            sqlSession.commit();
        } finally{
            sqlSession.close();
        }  
    }

    @Override
    public void insertToArsip(Pembelian pembelian) {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            GudangMapper gudangMapper = sqlSession.getMapper(GudangMapper.class);
            gudangMapper.insertToArsip(pembelian);
            sqlSession.commit();
        } finally{
            sqlSession.close();
        } 
    }

    @Override
    public void updateTanggalPembelian(Date date, int id) {
        SqlSession sqlSession = new MyBatisSqlSessionFactory().openSession();
        try{            
            GudangMapper gudangMapper = sqlSession.getMapper(GudangMapper.class);
            gudangMapper.updateTanggalPembelian(date, id);
            sqlSession.commit();
        } finally{
            sqlSession.close();
        }  
    }
    
}
