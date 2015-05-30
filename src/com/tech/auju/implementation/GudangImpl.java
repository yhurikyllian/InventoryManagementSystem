/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.implementation;

import com.tech.auju.objects.Bahan;
import com.tech.auju.objects.Pembelian;
import com.tech.auju.objects.Retur;
import com.tech.auju.util.GudangService;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.joda.time.DateTime;

/**
 *
 * @author sora
 */
public class GudangImpl {
    
    private final int PEMBELIAN = 0;
    private final int RETUR = 1;
    private Object[] dataArray;
    private Pembelian pembelian;
    private GudangService gs;
    private Retur retur;
    private ArrayList pembelians, pembeliansApproved, idCollection, returs;
    private Bahan bahan;
    
    public GudangImpl() {
        pembelian = new Pembelian();   
        pembelians = new ArrayList();
        retur = new Retur();        
        bahan = new Bahan();
        pembeliansApproved = new ArrayList();
        idCollection = new ArrayList();
        returs = new ArrayList<Retur>();
    }
    
    /**
     * Initialization array of data that will show for table.
     * @param index 
     */
    private void initDataArray(int index) {
        if(index == PEMBELIAN) {
            dataArray = new Object[] {
                pembelian.getBahan().getNama_bahan(), pembelian.getJml_pembelian(), pembelian.getTotal_harga(),
                pembelian.getTgl_pembelian(), pembelian.getBahan().getSupplier().getNama_supplier()
            };
        } else if(index == RETUR) {
            dataArray = new Object[] {
                retur.getBahan().getNama_bahan(), retur.getJml_pembelian(), retur.getTotal_harga(),
                retur.getTgl_pembelian(), retur.getBahan().getSupplier().getNama_supplier()
            };
        }
    }
    
    /**
     * Fill the table with data from database.
     * 
     * @param table Target table
     */
    public void fillTable(JTable table) {
        gs = new GudangService();
        
        for(int i=0; i<gs.selectPembelian().size(); i++) {
            pembelian = gs.selectPembelian().get(i);
            pembelians = (ArrayList) gs.selectPembelian();
            initDataArray(PEMBELIAN);
            for(int j=0; j<table.getColumnCount(); j++) {
                table.setValueAt(dataArray[j], i, j);
            }
        }
    }
    
    /**
     * Getter for Pembelian object.
     * @return pembelian
     */
    public Pembelian getPembelian(int index) {
        return (Pembelian) pembelians.get(index);
    }
    
    /**
     * Set table model according with the amount
     * of data.
     * 
     * @param tableName <br>0 : Pembelian's table <br>1 : Retur's table
     * 
     * @return DefaultTableModel
     */
    public DefaultTableModel getTableModel(int tableName) {
        gs = new GudangService();
        int row= -1;
        String[] columnText = new String[] {"Nama ",
            "Jumlah", "Harga", "Tanggal", "Supplier"};
        
        if(tableName == 0) {
            if(pembelians.size() < 1) {
                row = gs.selectPembelian().size();
            } else {
                row = pembelians.size();
            }            
        } else if(tableName == 1) {
            row = returs.size();
        } else if(tableName == 2) {
            row = pembeliansApproved.size();
        }
                
        return new DefaultTableModel(columnText, row);
    }
    
    /**
     * Get today date.
     * @return Today date.
     */
    private Date getTime() {
        DateTime dt = new DateTime();
        int d = dt.getDayOfMonth();
        int m = dt.getMonthOfYear();
        int y = dt.getYear();
        System.out.println("GETTIME : " + y + m + d);
        return new Date(y-1900, m, d);
    }
    
    /**
     * Insert Pembelian to Retur table.
     * @param index 
     */
    public void returnPembelian(int index) {
        retur = new Retur();
        retur.setJml_pembelian(getPembelian(index).getJml_pembelian());
        retur.setTgl_pembelian(getPembelian(index).getTgl_pembelian());
        retur.setTotal_harga(getPembelian(index).getTotal_harga());
        retur.setBahan(getPembelian(index).getBahan());
        retur.setTgl_retur(getTime());
        returs.add(retur);
    }
    
    /**
     * Fill Retur's table with data from database.
     * @param table 
     */
    public void updateReturTable(JTable table) {
        for(int i=0; i<returs.size(); i++) {
            retur = (Retur) returs.get(i);            
            initDataArray(RETUR);
            for(int j=0; j<table.getColumnCount(); j++) {
                table.setValueAt(dataArray[j], i, j);
            }
        }
    }
    
    /**
     * Initialize returs (Array list).
     */
    public void initReturTable() {
        returs = (ArrayList) gs.selectRetur();
    }
    
    /**
     * Remove Pembelians in database.
     * @param index 
     */
    private void removePembelians() {
        for(int i=0; i<idCollection.size(); i++) {
            int id = (int) idCollection.get(i);
            gs.removePembelian(id);
        }
    }
    
    /**
     * Make pembelian table up to date.
     * @param table 
     */
    public void updatePembelianTable(JTable table) {
        for(int i=0; i<pembelians.size(); i++) {
            pembelian = (Pembelian) pembelians.get(i);
            initDataArray(PEMBELIAN);
            for(int j=0; j<table.getColumnCount(); j++) {
                table.setValueAt(dataArray[j], i, j);
            }
        }       
    }
    
    /**
     * Make approved table up to date.
     * @param table 
     */
    public void updateApprovedTable(JTable table) {
        for(int i=0; i<pembeliansApproved.size(); i++) {
            pembelian = (Pembelian) pembeliansApproved.get(i);
            initDataArray(PEMBELIAN);
            for(int j=0; j<table.getColumnCount(); j++) {
                table.setValueAt(dataArray[j], i, j);
            }
        }       
    }
    
    /**
     * Submit data to database Pembelian.
     */
    public void submitData() {
        for(int i=0; i<pembeliansApproved.size(); i++) {            
            pembelian = (Pembelian) pembeliansApproved.get(i);
            int before = pembelian.getBahan().getJumlah_bahan();
            pembelian.getBahan().setJumlah_bahan(before + pembelian.getJml_pembelian());            
            gs.updateJumlahBahan(pembelian.getBahan().getJumlah_bahan(), pembelian.getBahan().getId_bahan());
            //gs.updateTanggalPembelian(getTime(), pembelian.getId_pembelian());
            pembelian.setTgl_pembelian(getTime());
            gs.insertToArsip(pembelian);
        }
        
        for(int i=0; i<returs.size(); i++) {
            retur = (Retur) returs.get(i);
            gs.insertRetur(retur);
        }
        
        removePembelians();
    }
    
    /**
     * Add pembelian to pembelians approved.
     * @param index 
     */
    public void addToPembeliansApproved(int index) {
        pembeliansApproved.add(pembelians.get(index));
    }
    
    /**
     * Remove a pembelian by index.
     * @param index 
     */
    public void remove(int index) {
        Pembelian idPemb = (Pembelian) pembelians.get(index);
        int id = idPemb.getId_pembelian();
        idCollection.add(Integer.valueOf(id));
        pembelians.remove(index);
    }
}
