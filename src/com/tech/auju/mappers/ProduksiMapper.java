/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.mappers;

import com.tech.auju.objects.Bahan;
import java.util.List;

/**
 *
 * @author sora
 */
public interface ProduksiMapper {
    
    List<Bahan> selectBahan();
    List<Bahan> selectBahanByName(String name);
    void updateJumlahBahan(int amount, int id);
}
