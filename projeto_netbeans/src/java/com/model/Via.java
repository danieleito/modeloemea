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
    /**
     * identificador do Via no Banco de Dados
     */
    private int id;
    /**
     * descrição da via
     */
    private String descricao;


    /**
     * Constructor padrão
     */
    public Via() {
    }

    /**
     * Constructor completo
     * @param id
     * @param via 
     */
    public Via(int id, String via) {
        this.id = id;
        this.descricao = via;
    }

    public Via(String via) {
        this.descricao = via;
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
    
    @Override
    public String toString() {
        return descricao;
    }
}
