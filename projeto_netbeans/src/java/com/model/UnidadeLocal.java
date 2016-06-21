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
    private String descricao;
    private SuperintendenciaRegional superintendenciaRegional;

    public UnidadeLocal(int id, String unidadeLocal, SuperintendenciaRegional superintendenciaRegional) {
        this.id = id;
        this.descricao = unidadeLocal;
        this.superintendenciaRegional = superintendenciaRegional;
    }

    public UnidadeLocal(String unidadeLocal, SuperintendenciaRegional superintendenciaRegional) {
        this.descricao = unidadeLocal;
        this.superintendenciaRegional = superintendenciaRegional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public SuperintendenciaRegional getSuperintendenciaRegional() {
        return superintendenciaRegional;
    }

    public void setSuperintendenciaRegional(SuperintendenciaRegional superintendenciaRegional) {
        this.superintendenciaRegional = superintendenciaRegional;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}
