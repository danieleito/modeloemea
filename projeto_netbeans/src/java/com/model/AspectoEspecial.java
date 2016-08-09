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
public class AspectoEspecial implements Serializable {
    /**
     * identificador do AspectoEspecial no Banco de Dados
     */
    private int id;
    /**
     * descricao do aspecto especial
     */
    private String descricao;

    public AspectoEspecial() {
    }

    public AspectoEspecial(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public AspectoEspecial(String descricao) {
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
