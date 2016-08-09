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
public class Uf implements Serializable {
    /**
     * identificador do Uf no Banco de Dados
     */
    private int id;
    private String estado;
    private String uf;

    public Uf() {
    }

    public Uf(int id, String estado, String uf) {
        this.id = id;
        this.estado = estado;
        this.uf = uf;
    }

    public Uf(String estado, String uf) {
        this.estado = estado;
        this.uf = uf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    @Override
    public String toString() {
        return uf;
    }
}
