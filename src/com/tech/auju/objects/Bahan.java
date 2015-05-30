/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.objects;

/**
 *
 * @author sora
 */
public class Bahan {
    
    private int id_bahan;
    private Merk merk;
    private Jenis jenis;
    private Warna warna;
    private String nama_bahan;
    private int harga_satuan;
    private int jumlah_bahan;
    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getHarga_satuan() {
        return harga_satuan;
    }

    public Jenis getJenis() {
        return jenis;
    }

    public Merk getMerk() {
        return merk;
    }

    public Warna getWarna() {
        return warna;
    }

    public void setJenis(Jenis jenis) {
        this.jenis = jenis;
    }

    public void setMerk(Merk merk) {
        this.merk = merk;
    }

    public void setWarna(Warna warna) {
        this.warna = warna;
    }

    public int getId_bahan() {
        return id_bahan;
    }

    public String getNama_bahan() {
        return nama_bahan;
    }

    public void setHarga_satuan(int harga_satuan) {
        this.harga_satuan = harga_satuan;
    }

    public void setId_bahan(int id_bahan) {
        this.id_bahan = id_bahan;
    }

    public void setNama_bahan(String nama_bahan) {
        this.nama_bahan = nama_bahan;
    }

    public int getJumlah_bahan() {
        return jumlah_bahan;
    }

    public void setJumlah_bahan(int jumlah_bahan) {
        this.jumlah_bahan = jumlah_bahan;
    }
}
