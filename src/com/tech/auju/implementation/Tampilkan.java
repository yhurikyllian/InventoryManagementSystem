/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.implementation;

import com.tech.auju.objects.Bahan;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JTable;

/**
 *
 * @author sora
 */
public class Tampilkan {
    
    private Bahan stock;
    private String[] listBahan;
    private ArrayList stocks;
    
    public Tampilkan() {
        stock = new Bahan();
        stocks = new ArrayList();
        
    }
    
    /**
     * Show current stock. Stock was gained from Bahan.
     * 
     * @param table
     * @return Table fill with current stocks.
     */
    public JTable showCurrentStocks(JTable table) {
        // SQL having fill arraylist
        // Stock was gained from arraylist
//        String satuan = "" + stock.getSatuan();
//        String harga = "" + stock.getHarga();
        //listBahan = new String[]{stock.getId_bahan(), stock.getId_merk(), stock.getNama_bahan(), satuan, harga};
        
        for(int h=0; h<table.getRowCount(); h++) {
            for(int i=0; i<table.getColumnCount(); i++) {
                table.setValueAt(listBahan[i], h, i);
            }
        }
        return table;
    }
    
//    public String[] showEmptyStock(JList list) {
//        //Search empty stock here
//    }
    
}
