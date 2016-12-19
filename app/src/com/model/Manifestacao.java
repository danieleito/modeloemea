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
public class Manifestacao implements Serializable {
    /**
     * identificador do Manifestacao no Banco de Dados
     */
    private int id;
    /**
     * descrição da manifestação
     */
    private String descricao;
    /**
     * beta da manifestação
     */
    private String beta;


    /**
     * Constructor padrão
     */
    public Manifestacao() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param manifestacao {@link #manifestacao}
     * @param beta {@link #beta}
     */
    public Manifestacao(int id, String manifestacao, String beta) {
        this.id = id;
        this.descricao = manifestacao;
        this.beta = beta;
    }

    /**
     * Constructor sem id
     * @param manifestacao {@link #manifestacao}
     * @param beta {@link #beta}
     */
    public Manifestacao(String manifestacao, String beta) {
        this.descricao = manifestacao;
        this.beta = beta;
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

    /**
     * retorna {@link #beta}
     * @return {@link #beta}
     */
    public String getBeta() {
        return beta;
    }

    public void setBeta(String beta) {
        this.beta = beta;
    }
    
    @Override
    public String toString() {
        return this.descricao;
    }
}
