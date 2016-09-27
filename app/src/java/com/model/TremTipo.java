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
public class TremTipo implements Serializable {
    /**
     * identificador do TremTipo no Banco de Dados
     */
    private int id;
    /**
     * descrição do trem-tipo
     */
    private String descricao;


    /**
     * Constructor padrão
     */
    public TremTipo() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param descricao  {@link #descricao}
     */
    public TremTipo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    /**
     * Constructor sem id
     * @param descricao  {@link #descricao}
     */
    public TremTipo(String descricao) {
        this.descricao = descricao;
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
