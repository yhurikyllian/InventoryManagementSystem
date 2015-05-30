/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.mappers;

import com.tech.auju.objects.Bahan;
import com.tech.auju.objects.Pembelian;
import com.tech.auju.objects.Retur;
import java.sql.Date;
import java.util.List;


/**
 *
 * @author sora
 */
public interface GudangMapper {
    List<Pembelian> selectPembelian(); 
    void insertRetur(Retur retur);
    List<Retur> selectRetur();
    void insertBahan(Bahan bahan);
    void updateJumlahBahan(int jumlah, int id);
    void removePembelian(int idPembelian);
    void insertToArsip(Pembelian pembelian);
    void updateTanggalPembelian(Date date, int id);
}
