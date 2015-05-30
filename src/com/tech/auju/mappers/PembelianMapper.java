/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.mappers;

import com.tech.auju.objects.Bahan;
import com.tech.auju.objects.Pembelian;
import com.tech.auju.objects.Retur;
import java.util.List;

/**
 *
 * @author sora
 */
public interface PembelianMapper {
    
    List<Bahan> selectBahan();
    List<Retur> selectRetur();
    List<Bahan> selectMinPembelian(int min);
    //List<Pembelian> selectStatusPembelian();
    void insertPembelian(Pembelian pembelian);
}
