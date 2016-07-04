/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Daniele Harumi Ito
 */
public class Substituicao {
    private int id;
    private String identificacao;
    private String existeProjetoIdentificacao;
    private String custoEstimado;
    private String descricao;

    public Substituicao() {
    }

    public Substituicao(int id, String identificacao, String existeProjetoIdentificacao, String custoEstimado, String descricao) {
        this.id = id;
        this.identificacao = identificacao;
        this.existeProjetoIdentificacao = existeProjetoIdentificacao;
        this.custoEstimado = custoEstimado;
        this.descricao = descricao;
    }

    public Substituicao(String identificacao, String existeProjetoIdentificacao, String custoEstimado, String descricao) {
        this.identificacao = identificacao;
        this.existeProjetoIdentificacao = existeProjetoIdentificacao;
        this.custoEstimado = custoEstimado;
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

    public String getExisteProjetoIdentificacao() {
        return existeProjetoIdentificacao;
    }

    public void setExisteProjetoIdentificacao(String existeProjetoIdentificacao) {
        this.existeProjetoIdentificacao = existeProjetoIdentificacao;
    }

    public String getCustoEstimado() {
        return custoEstimado;
    }

    public void setCustoEstimado(String custoEstimado) {
        this.custoEstimado = custoEstimado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
