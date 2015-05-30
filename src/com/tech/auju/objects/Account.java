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
public class Account {
    
    private String pengguna, pass, section;

    public String getPass() {
        return pass;
    }

    public String getSection() {
        return section;
    }

    public String getPengguna() {
        return pengguna;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setPengguna(String pengguna) {
        this.pengguna = pengguna;
    }
}
