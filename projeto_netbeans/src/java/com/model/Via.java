/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;

/**
 *
 * @author Daniele Harumi Ito
 */
public class Via implements Serializable {
    private int id;
    private String via;

    public Via() {
    }

    public Via(int id, String via) {
        this.id = id;
        this.via = via;
    }

    public Via(String via) {
        this.via = via;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }
    
    @Override
    public String toString() {
        return via;
    }
}
