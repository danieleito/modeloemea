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
public class Observacao implements Serializable {
    /**
     * identificador do Observacao no Banco de Dados
     */
    private int id;
    private String identificacao;
    private String descricao;

    public Observacao() {
    }

    public Observacao(int id, String identificacao, String descricao) {
        this.id = id;
        this.identificacao = identificacao;
        this.descricao = descricao;
    }

    public Observacao(String identificacao, String descricao) {
        this.identificacao = identificacao;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
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
