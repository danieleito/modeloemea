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
public class SuperintendenciaRegional {
    private int id;
    private String descricao;
    private Uf uf;

    public SuperintendenciaRegional(int id, String descricao, Uf uf) {
        this.id = id;
        this.descricao = descricao;
        this.uf = uf;
    }

    public SuperintendenciaRegional(String descricao, Uf uf) {
        this.descricao = descricao;
        this.uf = uf;
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

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}
