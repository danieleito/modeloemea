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
public class ElementoComponente implements Serializable {
    private int id;
    private ElementoUfpr elementoUfpr;
    private String detalhe;
    private String quantidade;

    public ElementoComponente() {
    }

    public ElementoComponente(int id, ElementoUfpr elementoUfpr, String detalhe, String quantidade) {
        this.id = id;
        this.elementoUfpr = elementoUfpr;
        this.detalhe = detalhe;
        this.quantidade = quantidade;
    }

    public ElementoComponente(ElementoUfpr elementoUfpr, String detalhe, String quantidade) {
        this.elementoUfpr = elementoUfpr;
        this.detalhe = detalhe;
        this.quantidade = quantidade;
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

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
