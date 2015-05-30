/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.mappers;

import com.tech.auju.objects.Account;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sora
 */
public interface AccountMapper {
    int accountCount(String user, String pass, String section);
    ArrayList<Account> test();
}
