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
public class SuperintendenciaRegional implements Serializable {
    /**
     * identificador do SuperintendenciaRegional no Banco de Dados
     */
    private int id;
    /**
     * descrição da superintendência regional 
     */
    private String descricao;
    /**
     * identificador da uf
     */
    private Uf uf;


    /**
     * Constructor padrão
     */
    public SuperintendenciaRegional() {
    }

    /**
     * Conatructor completo
     * @param id {@link #id}
     * @param descricao {@link #descricao}
     * @param uf {@link #uf}
     */
    public SuperintendenciaRegional(int id, String descricao, Uf uf) {
        this.id = id;
        this.descricao = descricao;
        this.uf = uf;
    }

    /**
     * Conatructor sem id
     * @param descricao {@link #descricao}
     * @param uf {@link #uf}
     */
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
