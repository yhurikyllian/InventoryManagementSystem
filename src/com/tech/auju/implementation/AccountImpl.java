/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.implementation;

import com.tech.auju.objects.Account;
import com.tech.auju.util.AccountService;
import java.util.ArrayList;

/**
 *
 * @author sora
 */
public class AccountImpl {
    
    private AccountService accountService;
    
    public AccountImpl() {
        accountService = new AccountService();
    }
    
    /**
     * Confirm if user, pass, and section matched and available.
     * @param user
     * @param pass
     * @param section
     * @return status
     */
    public boolean verify(String user, String pass, String section) {
        boolean status = false;
        int count = accountService.accountCount(user, pass, section);
        
        if(count>=1)
            status = true;
        
        return status;
    }
}
