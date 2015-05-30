/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.implementation;

import com.tech.auju.objects.Bahan;
import com.tech.auju.util.ProduksiService;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sora
 */
public class ProduksiImpl {
    
    private ProduksiService ps;
    private Bahan bahan;
    private ArrayList bahans;
    private Object[] dataArray;
    
    public ProduksiImpl() {
        ps = new ProduksiService();
        bahan = new Bahan();
        bahans = new ArrayList();
    }
    
    /**
     * Make custom table.
     * @return table model
     */
    public DefaultTableModel getTableModel() {
        int row= -1;
        String[] columnText = new String[] {"Nama ",
            "Jumlah", "Harga", "Jenis", "Warna", "Merk"};
        
            if(bahans.size() < 1) {
                row = ps.selectBahan().size();
            } else {
                row = bahans.size();
            }            
                
        return new DefaultTableModel(columnText, row);
    }
    
    /**
     * Fill table with data from database.
     * @param table
     */
    public void fillTable(JTable table) { 
        bahans = (ArrayList) ps.selectBahan();
        updateTable(table);
    }
    
    /**
     * fill data array with nama bahan, jumlah, harga, <br>
     * jenis, warna, merk.
     */
    private void initDataArray() {
        dataArray = new Object[] {
            bahan.getNama_bahan(), bahan.getJumlah_bahan(), bahan.getHarga_satuan(),
            bahan.getJenis().getNama_jenis(), bahan.getWarna().getNama_warna(), bahan.getMerk().getNama_merk()
        };        
    }
    
    /**
     * Search bahan by name.
     * @param name 
     */
    public void searchBahan(String name) {
        String patternName = "%" + name + "%";
        bahans = (ArrayList) ps.selectBahanByName(patternName);
    }
    
    /**
     * Fill table with value of bahans.
     * @param table 
     */
    public void updateTable(JTable table) {
        for(int i=0; i<bahans.size(); i++) {
            bahan = (Bahan) bahans.get(i);
            
            initDataArray();    
            for(int j=0; j<table.getColumnCount(); j++) {
                table.setValueAt(dataArray[j], i, j);
            }
        }
    }
    
    /**
     * Return Bahan from listBeli at index.
     * @param index
     * @return Bahan
     */
    public Bahan getSelectedBahan(int index) {
        bahan = (Bahan) bahans.get(index);
        return bahan;
    }
    
    /**
     * Update the amount of bahan in database.
     * @param index
     * @param amount 
     */
    public void submitData(int index, int amount) {
        bahan = getSelectedBahan(index);
        int before = bahan.getJumlah_bahan();        
        ps.updateJumlahBahan(before - amount, bahan.getId_bahan());
    }
    
}
