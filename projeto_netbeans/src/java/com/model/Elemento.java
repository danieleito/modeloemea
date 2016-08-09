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
    
    /**
     * descricao do elemento
     */
    private String descricao;
    /**
     * capa do elemento
     */
    private String capa;


    /**
     * Constructor padrão.
     */
    public Elemento() {
    }

    /**
     * Constructor completo
     * @param id
     * @param descricao
     * @param capa 
     */
    public Elemento(int id, String descricao, String capa) {
        this.id = id;
        this.descricao = descricao;
        this.capa = capa;
    }

    public Elemento(String descricao, String capa) {
        this.descricao = descricao;
        this.capa = capa;
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

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }
    
    @Override
    public String toString() {
        return this.descricao;
    }
}