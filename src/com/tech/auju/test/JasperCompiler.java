/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.test;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

/**
 *
 * @author sora
 */
public class JasperCompiler {
    public JasperCompiler() throws JRException{
        String l0 = "/home/sora/NetBeansProjects/InventoryManagementSystem/report/arsip.jrxml";     
        String l = "/home/sora/NetBeansProjects/InventoryManagementSystem/report/arsip.jasper";
        JasperCompileManager.compileReportToFile(l0, l);
               
    }
    
    public static void main(String[] args) throws JRException {
        new JasperCompiler();
    }
}
