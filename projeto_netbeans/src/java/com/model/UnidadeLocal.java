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
    private SuperintendenciaRegional superintendenciaRegional;

    public UnidadeLocal(int id, String unidadeLocal, SuperintendenciaRegional superintendenciaRegional) {
        this.id = id;
        this.unidadeLocal = unidadeLocal;
        this.superintendenciaRegional = superintendenciaRegional;
    }

    public UnidadeLocal(String unidadeLocal, SuperintendenciaRegional superintendenciaRegional) {
        this.unidadeLocal = unidadeLocal;
        this.superintendenciaRegional = superintendenciaRegional;
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

    public SuperintendenciaRegional getSuperintendenciaRegional() {
        return superintendenciaRegional;
    }

    public void setSuperintendenciaRegional(SuperintendenciaRegional superintendenciaRegional) {
        this.superintendenciaRegional = superintendenciaRegional;
    }
    
    
}
