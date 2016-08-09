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
public class Elemento implements Serializable {
    /**
     * identificador do Elemento no Banco de Dados
     */
    private int id;
    private String elemento;
    private String capa;

    public Elemento() {
    }

    public Elemento(int id, String elemento, String capa) {
        this.id = id;
        this.elemento = elemento;
        this.capa = capa;
    }

    public Elemento(String elemento, String capa) {
        this.elemento = elemento;
        this.capa = capa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }
    
    @Override
    public String toString() {
        return this.elemento;
    }
}