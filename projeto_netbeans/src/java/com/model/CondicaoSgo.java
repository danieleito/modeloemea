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
public class CondicaoSgo implements Serializable {
    /**
     * identificador do CondicaoSgo no Banco de Dados
     */
    private int id;
    /**
     * condição estabilidade
     */
    private String condicaoEstabilididade;
    /**
     * condição conservação
     */
    private String condicaoConservacao;
    /**
     * observações
     */
    private String observacoes;
    /**
     * nota técnica
     */
    private String notaTecnica;


    /**
     * Constructor padrão.
     */
    public CondicaoSgo() {
    }

    /**
     * Constructor completo
     * @param id
     * @param condicaoEstabilididade
     * @param condicaoConservacao
     * @param observacoes
     * @param notaTecnica 
     */
    public CondicaoSgo(int id, String condicaoEstabilididade, String condicaoConservacao, String observacoes, String notaTecnica) {
        this.id = id;
        this.condicaoEstabilididade = condicaoEstabilididade;
        this.condicaoConservacao = condicaoConservacao;
        this.observacoes = observacoes;
        this.notaTecnica = notaTecnica;
    }

    public CondicaoSgo(String condicaoEstabilididade, String condicaoConservacao, String observacoes, String notaTecnica) {
        this.condicaoEstabilididade = condicaoEstabilididade;
        this.condicaoConservacao = condicaoConservacao;
        this.observacoes = observacoes;
        this.notaTecnica = notaTecnica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCondicaoEstabilididade() {
        return condicaoEstabilididade;
    }

    public void setCondicaoEstabilididade(String condicaoEstabilididade) {
        this.condicaoEstabilididade = condicaoEstabilididade;
    }

    public String getCondicaoConservacao() {
        return condicaoConservacao;
    }

    public void setCondicaoConservacao(String condicaoConservacao) {
        this.condicaoConservacao = condicaoConservacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getNotaTecnica() {
        return notaTecnica;
    }

    public void setNotaTecnica(String notaTecnica) {
        this.notaTecnica = notaTecnica;
    }
}
