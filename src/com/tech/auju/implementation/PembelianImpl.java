/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.implementation;

import com.tech.auju.objects.Bahan;
import com.tech.auju.objects.Pembelian;
import com.tech.auju.objects.Retur;
import com.tech.auju.util.PembelianService;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.joda.time.DateTime;

/**
 *
 * @author sora
 */
public class PembelianImpl {
    
    private PembelianService ps;
    private Bahan bahan;
    private Retur retur;
    private Pembelian pembelian;
    private ArrayList pembelians;
    private ArrayList bahans;
    private ArrayList returs;
    private Object[] dataArray;
    private ArrayList listBahan;
    private ArrayList listBeli;
    
    public PembelianImpl() {
        ps = new PembelianService();
        bahan = new Bahan();
        bahans = new ArrayList();
        returs = new ArrayList();
        retur = new Retur();
        listBeli = new ArrayList();
        pembelian = new Pembelian();
        pembelians = new ArrayList();
    }
    
    /**
     * Make custom table.
     * @param tableName
     * @return table model
     */
    public DefaultTableModel getTableModel(int tableName) {
        int row= -1;
        String[] columnText = new String[] {"Nama ",
            "Jumlah", "Harga", "Jenis", "Warna", "Merk"};
        
        if(tableName == 0) {
            if(bahans.size() < 1) {
                row = ps.selectBahan().size();
            } else {
                row = bahans.size();
            }            
        } else if(tableName == 2) {
            columnText = new String[] {"Nama", "Tanggal",
                "Jumlah", "Harga", "Supplier"};
            if(returs.size() < 1) {
                row = ps.selectRetur().size();
            } else {
                row = returs.size();
            }
        }
                
        return new DefaultTableModel(columnText, row);
    }
    
    /**
     * Fill table with data from database.
     * @param table
     * @param tableName 
     */
    public void fillTable(JTable table, int tableName) { 
        
        if(tableName == 0) {
            bahans = (ArrayList) ps.selectBahan();
            for(int i=0; i<ps.selectBahan().size(); i++) {
                    bahan = ps.selectBahan().get(i);                   
                    initDataArray(tableName);
                    for(int j=0; j<table.getColumnCount(); j++) {
                        table.setValueAt(dataArray[j], i, j);
                    }
            }
        } else if(tableName==2) {
            returs = (ArrayList) ps.selectRetur();
            for(int i=0; i<ps.selectRetur().size(); i++) {
                    retur = ps.selectRetur().get(i);             
                    initDataArray(tableName);
                    for(int j=0; j<table.getColumnCount(); j++) {
                        table.setValueAt(dataArray[j], i, j);
                    }
            }
        }   
    }
    
    /**
     * fill data array with nama bahan, jumlah, harga, <br>
     * jenis, warna, merk.
     * @param tableName
     */
    private void initDataArray(int tableName) {        
        if(tableName == 0) {
            dataArray = new Object[] {
                bahan.getNama_bahan(), bahan.getJumlah_bahan(), bahan.getHarga_satuan(),
                bahan.getJenis().getNama_jenis(), bahan.getWarna().getNama_warna(), bahan.getMerk().getNama_merk()
            };
        } else if(tableName == 1) {
            dataArray = new Object[] {
                pembelian.getBahan().getNama_bahan(), pembelian.getTgl_pembelian(),
                pembelian.getJml_pembelian(), pembelian.getTotal_harga(),
//                pembelian.getSupplier().getNama_supplier(), pembelian.getStatus_lunas()
            };
        } else if(tableName == 2) {
            dataArray = new Object[] {
                retur.getBahan().getNama_bahan(), retur.getTgl_retur(),
                retur.getJml_pembelian(), retur.getTotal_harga(),
                retur.getBahan().getSupplier().getNama_supplier()
            };
        }
        
    }
    
    /**
     * Get a full data list.
     * @return list model
     */
    public AbstractListModel getListModel() {
        int min = 30 * 1000 / 100;
        if(listBahan == null) {
            listBahan = (ArrayList) ps.selectMinPembelian(min);
        }
        
        AbstractListModel alm = new AbstractListModel() {

            @Override
            public int getSize() {
                return listBahan.size();
            }

            @Override
            public Object getElementAt(int index) {
                bahan = (Bahan) listBahan.get(index);
                return bahan.getNama_bahan();
            }
        };
        return alm;       
    }
    
    /**
     * Set array listBeli with the data from
     * listBahan(index).
     * @param index 
     */
    public void removeListBeli(int index) {
        bahan = (Bahan) listBeli.get(index);
        listBeli.remove(index);
        listBahan.add(bahan);
    }
    
    /**
     * Set array listBeli with the data from
     * listBahan(index).
     * @param index 
     */
    public void setListBeli(int index) {
        bahan = (Bahan) listBahan.get(index);
        listBeli.add(bahan);
        listBahan.remove(index);
    }
    
    /**
     * Return Bahan from listBeli at index.
     * @param index
     * @return Bahan
     */
    public Bahan getBahanBeli(int index) {
        bahan = (Bahan) listBeli.get(index);
        return bahan;
    }
    
    /**
     * Get list model for lstBeli2.
     * @return abstract list model
     */
    public AbstractListModel getBeliListModel() {
        
        AbstractListModel alm = new AbstractListModel() {

            @Override
            public int getSize() {
                return listBeli.size();
            }

            @Override
            public Object getElementAt(int index) {
                
                bahan = (Bahan) listBeli.get(index);
                return bahan.getNama_bahan();
            }
        };
        return alm;
    }
    
    /**
     * Get total price from listBeli. <br>
     * cost = price per piece * amount.
     * @return cost
     */
    public int getTotalHarga() {
        int cost = 0, pricePerPiece = 0, amount = 0;
        for(int i=0; i<listBeli.size(); i++) {
            bahan = (Bahan) listBeli.get(i);
            pricePerPiece = bahan.getHarga_satuan();
            amount = 1000;
            cost += pricePerPiece * amount;
        }
        return cost;
    }
    
    /**
     * Get today date.
     * @return Today date.
     */
    private Date getTime() {
        DateTime dt = new DateTime();
        int d = dt.getDayOfWeek();
        int m = dt.getMonthOfYear();
        int y = dt.getYear();
        
        return new Date(y-1900, m, d);
    }
    
    /**
     * Making order.
     */
    public void makingOrder() {
        for(int i=0; i<listBeli.size(); i++) {
            int cost = bahan.getHarga_satuan() * 1000;
            bahan = (Bahan) listBeli.get(i);
            pembelian.setBahan(bahan);
            pembelian.setJml_pembelian(1000);
//            pembelian.setStatus_lunas(false);
//            pembelian.setSupplier(bahan.getSupplier());
            pembelian.setTgl_pembelian(getTime());
            pembelian.setTotal_harga(cost);
            ps.insertPembelian(pembelian);
        }
        
        listBeli.clear();
    }
    
    
    
}
