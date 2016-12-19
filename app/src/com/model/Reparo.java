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
public class Reparo implements Serializable {
    /**
     * identificador do Reparo no Banco de Dados
     */
    private int id;
    /**
     * descrição do reparo
     */
    private String descricao;


    /**
     * Constructor padrão
     */
    public Reparo() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param descricao {@link #descricao}
     */
    public Reparo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    /**
     * Constructor sem id
     * @param descricao {@link #descricao}
     */
    public Reparo(String descricao) {
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
