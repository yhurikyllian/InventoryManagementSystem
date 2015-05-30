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
public class Retur {
    
    private int id_retur;
    private Date tgl_pembelian;
    private int jml_pembelian;
    private int total_harga;
    private Bahan bahan;
    private Date tgl_retur;

    public Bahan getBahan() {
        return bahan;
    }

    public int getJml_pembelian() {
        return jml_pembelian;
    }

    public Date getTgl_pembelian() {
        return tgl_pembelian;
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public void setBahan(Bahan bahan) {
        this.bahan = bahan;
    }

    public void setJml_pembelian(int jml_pembelian) {
        this.jml_pembelian = jml_pembelian;
    }

    public void setTgl_pembelian(Date tgl_pembelian) {
        this.tgl_pembelian = tgl_pembelian;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }
    
    public int getId_retur() {
        return id_retur;
    }

    public void setId_retur(int id_retur) {
        this.id_retur = id_retur;
    }

    public Date getTgl_retur() {
        return tgl_retur;
    }

    public void setTgl_retur(Date tgl_retur) {
        this.tgl_retur = tgl_retur;
    }
}
