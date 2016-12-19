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
public class Foto implements Serializable {
    /**
     * identificador do Foto no Banco de Dados
     */
    private int id;
    /**
     * descrição da foto
     */
    private String descricao;


    /**
     * Constructor padrão.
     */
    public Foto() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param descricao {@link #descricao}
     */
    public Foto(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    /**
     * Constructor sem id
     * @param descricao {@link #descricao}
     */
    public Foto(String descricao) {
        this.descricao = descricao;
    }


    /**
     * retorna {@link #id}
     * @return {@link #id}
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * retorna {@link #descricao}
     * @return {@link #descricao}
     */
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
