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
public class SistemaConstrutivo implements Serializable {
    /**
     * identificador do SistemaConstrutivo no Banco de Dados
     */
    private int id;
    /**
     * decrição do sistema construtivo
     */
    private String descricao;


    /**
     * Constructor padrão
     */
    public SistemaConstrutivo() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param descricao {@link #descricao}
     */
    public SistemaConstrutivo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    /**
     * Constructor sem id
     * @param descricao {@link #descricao}
     */
    public SistemaConstrutivo(String descricao) {
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
