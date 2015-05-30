/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sora
 */
public class DocumentMaker {
    
    MyBatisSqlSessionFactory sf = new MyBatisSqlSessionFactory();
    Connection con = MyBatisSqlSessionFactory.openSession().getConnection();
    
    public DocumentMaker() {
        
    }
    
    /**
     * Show print preview for pembelian.
     * @throws FileNotFoundException
     * @throws JRException 
     */
    public void printPembelian() throws FileNotFoundException, JRException{    
        HashMap param = new HashMap();
        String s = System.getProperty("file.separator");
        String l = System.getProperty("user.dir") + s + "src" + s + "com" + s + "tech" + s + "auju" + s + "report" + s + "pembelian.jasper";            
        String logoPath = System.getProperty("user.dir") + s + "pic" + s + "logo.jpg";
        FileInputStream rStream = new FileInputStream(l);
        JasperReport jReport = (JasperReport) JRLoader.loadObject(rStream);
        param.put("LOGO", logoPath);
        JasperPrint print;
        print = JasperFillManager.fillReport(jReport, param, con);
       
        JasperViewer.viewReport(print, false);  
    }
    
    public void printArsip(Date d1, Date d2) throws FileNotFoundException, JRException {
        HashMap param = new HashMap();
        String s = System.getProperty("file.separator");
        String l = System.getProperty("user.dir") + s + "src" + s + "com" + s + "tech" + s + "auju" + s + "report" + s + "arsip.jasper";            
        String logoPath = System.getProperty("user.dir") + s + "pic" + s + "logo.jpg";
        
        param.put("LOGO", logoPath);
        param.put("DATE1", d1);
        param.put("DATE2", d2);
        
        String a = d1.getYear() + "-" + d1.getMonth() + "-" + d1.getDay();
        String b = d2.getYear() + "-" + d2.getMonth() + "-" + d2.getDay();
        param.put("EX1", a);
        param.put("EX2", b);
        
        FileInputStream rStream = new FileInputStream(l);
        JasperReport jReport = (JasperReport) JRLoader.loadObject(rStream);
        
        JasperPrint print;
        print = JasperFillManager.fillReport(jReport, param, con);
       
        JasperViewer.viewReport(print, false); 
    }
}
