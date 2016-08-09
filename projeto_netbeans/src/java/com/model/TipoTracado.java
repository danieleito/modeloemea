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
public class TipoTracado implements Serializable {
    /**
     * identificador do TipoTracado no Banco de Dados
     */
    private int id;
    /**
     * descrição do tipo traçado
     */
    private String descricao;

 
    /**
     * Constructor padrão
     */
    public TipoTracado() {
    }

    /**
     * Constructor completo
     * @param id
     * @param descricao 
     */
    public TipoTracado(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public TipoTracado(String descricao) {
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
