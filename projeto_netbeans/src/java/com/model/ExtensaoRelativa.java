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
public class ExtensaoRelativa implements Serializable {
    /**
     * identificador do ExtensaoRelativa no Banco de Dados
     */
    private int id;
    /**
     * descrição da extensão relativa
     */
    private String descricao;


    /**
     * Constructor padrão.
     */
    public ExtensaoRelativa() {
    }

    /**
     * Constructor completo
     * @param id
     * @param descricao 
     */
    public ExtensaoRelativa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public ExtensaoRelativa(String descricao) {
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
