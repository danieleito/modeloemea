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
public class ElementoUfpr implements Serializable {
    /**
     * identificador do ElementoUfpr no Banco de Dados
     */
    private int id;
    private String codigo;
    private String descricao;
    private String capa;

    public ElementoUfpr() {
    }

    public ElementoUfpr(int id, String codigo, String descricao, String capa) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.capa = capa;
    }

    public ElementoUfpr(String codigo, String descricao, String capa) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.capa = capa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }
    
    @Override
    public String toString() {
        return this.descricao;
    }
}
