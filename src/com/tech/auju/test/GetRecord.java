/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.test;

import com.tech.auju.objects.Account;
import com.tech.auju.objects.Pembelian;
import com.tech.auju.util.AccountService;
import com.tech.auju.util.GudangService;

/**
 *
 * @author sora
 */
public class GetRecord {
    
    public GetRecord() {
        AccountService as = new AccountService();
        Account acc = new Account();
        
        acc = as.test().get(1);
        
        System.out.println("" + acc.getPass());
    }
    
    private void testJoin() {
        GudangService gs = new GudangService();
        for(int i=0; i<gs.selectPembelian().size(); i++) {
            Pembelian p = gs.selectPembelian().get(i);
            System.out.println(" " + p.getBahan().getNama_bahan());
        }
    }
    
    public static void main(String[] args) {
        new GetRecord().testJoin();
    }
}
