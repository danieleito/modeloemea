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
public class ManifestacaoUfpr {
    private int id;
    private ElementoUfpr elementoUfpr;
    private String codigo;
    private String descricao;
    private String unidade;
    private String beta;

    public ManifestacaoUfpr() {
        elementoUfpr = new ElementoUfpr();
    }

    public ManifestacaoUfpr(int id, ElementoUfpr elementoUfpr, String codigo, String descricao, String unidade, String beta) {
        this.id = id;
        this.elementoUfpr = elementoUfpr;
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidade = unidade;
        this.beta = beta;
    }

    public ManifestacaoUfpr(ElementoUfpr elementoUfpr, String codigo, String descricao, String unidade, String beta) {
        this.elementoUfpr = elementoUfpr;
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidade = unidade;
        this.beta = beta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElementoUfpr getElementoUfpr() {
        return elementoUfpr;
    }

    public void setElementoUfpr(ElementoUfpr elementoUfpr) {
        this.elementoUfpr = elementoUfpr;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getBeta() {
        return beta;
    }

    public void setBeta(String beta) {
        this.beta = beta;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}
