/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Daniele Harumi Ito
 */
public class UnidadeLocal {
    private int id;
    private String unidadeLocal;

    public UnidadeLocal() {
    }

    public UnidadeLocal(int id, String unidadeLocal) {
        this.id = id;
        this.unidadeLocal = unidadeLocal;
    }

    public UnidadeLocal(String unidadeLocal) {
        this.unidadeLocal = unidadeLocal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnidadeLocal() {
        return unidadeLocal;
    }

    public void setUnidadeLocal(String unidadeLocal) {
        this.unidadeLocal = unidadeLocal;
    }
}
