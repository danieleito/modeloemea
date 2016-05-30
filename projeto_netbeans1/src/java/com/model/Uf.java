/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Daniele Harumi Ito
 */
@ManagedBean
public class Uf {
    private int id;
    private String uf;

    public Uf() {
    }

    public Uf(int id, String uf) {
        this.id = id;
        this.uf = uf;
    }

    public Uf(String uf) {
        this.uf = uf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
