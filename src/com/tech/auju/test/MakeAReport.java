/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.test;

import com.tech.auju.util.MyBatisSqlSessionFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
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
public class MakeAReport {
    MyBatisSqlSessionFactory sf = new MyBatisSqlSessionFactory();
    Connection con = MyBatisSqlSessionFactory.openSession().getConnection();
    
    public MakeAReport(){
        try {
            print() ;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MakeAReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(MakeAReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void print() throws FileNotFoundException, JRException{
        //HashMap param = new HashMap();
        //param.put("TANGGAL", "2015");
        
        String l = System.getProperty("user.dir") + "/src/com/tech/auju/report/pembelian.jasper";            
        //String l = ih.getReportPath();
        FileInputStream rStream = new FileInputStream(l);
        //JRDataSource dataSource = new JRBeanCollectionDataSource(forms);
        JasperReport jReport = (JasperReport) JRLoader.loadObject(rStream);
        
        JasperPrint print;
        print = JasperFillManager.fillReport(jReport, new HashMap<>(), con);
       
        //JasperPrintManager.printReport(print, true);
        JasperViewer.viewReport(print, false);  
    }
    
    public static void main(String[] args) {
        new MakeAReport();
    }
}
