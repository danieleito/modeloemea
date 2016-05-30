/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.Date;

/**
 *
 * @author Daniele Harumi Ito
 */
public class Inspecao {
    private int id;
    private Date data;
    private Usuario usuario;
    private String condicaoEstabilidade;
    private String condicaoConservacao;

    public Inspecao() {
    }

    public Inspecao(int id, Date data, Usuario usuario, String condicaoEstabilidade, String condicaoConservacao) {
        this.id = id;
        this.data = data;
        this.usuario = usuario;
        this.condicaoEstabilidade = condicaoEstabilidade;
        this.condicaoConservacao = condicaoConservacao;
    }

    public Inspecao(Date data, Usuario usuario, String condicaoEstabilidade, String condicaoConservacao) {
        this.data = data;
        this.usuario = usuario;
        this.condicaoEstabilidade = condicaoEstabilidade;
        this.condicaoConservacao = condicaoConservacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCondicaoEstabilidade() {
        return condicaoEstabilidade;
    }

    public void setCondicaoEstabilidade(String condicaoEstabilidade) {
        this.condicaoEstabilidade = condicaoEstabilidade;
    }

    public String getCondicaoConservacao() {
        return condicaoConservacao;
    }

    public void setCondicaoConservacao(String condicaoConservacao) {
        this.condicaoConservacao = condicaoConservacao;
    }
}
