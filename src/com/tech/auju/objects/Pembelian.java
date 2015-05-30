/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.objects;

import java.sql.Date;

/**
 *
 * @author sora
 */
public class Pembelian {
    
    private int id_pembelian;
    private Date tgl_pembelian;
    private int jml_pembelian;
    private int total_harga;
    private Bahan bahan;

    public Bahan getBahan() {
        return bahan;
    }

    public void setBahan(Bahan bahan) {
        this.bahan = bahan;
    }

    public int getId_pembelian() {
        return id_pembelian;
    }

    public int getJml_pembelian() {
        return jml_pembelian;
    }

    public void setId_pembelian(int id_pembelian) {
        this.id_pembelian = id_pembelian;
    }

    public void setJml_pembelian(int jml_pembelian) {
        this.jml_pembelian = jml_pembelian;
    }

    public Date getTgl_pembelian() {
        return tgl_pembelian;
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public void setTgl_pembelian(Date tgl_pembelian) {
        this.tgl_pembelian = tgl_pembelian;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }
}
