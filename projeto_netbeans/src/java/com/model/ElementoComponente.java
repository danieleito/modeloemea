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
    /**
     * identificador do ElementoComponente no Banco de Dados
     */
    private int id;
    /**
     * elemento da ufpr
     */
    private ElementoUfpr elementoUfpr;
    /**
     * detalhe
     */
    private String detalhe;
    /**
     * quantidade do elemento componente
     */
    private String quantidade;


    /**
     * Constructor padrão.
     */
    public ElementoComponente() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param elementoUfpr {@link #elementoUfpr}
     * @param detalhe {@link #detalhe}
     * @param quantidade {@link #quantidade}
     */
    public ElementoComponente(int id, ElementoUfpr elementoUfpr, String detalhe, String quantidade) {
        this.id = id;
        this.elementoUfpr = elementoUfpr;
        this.detalhe = detalhe;
        this.quantidade = quantidade;
    }

    /**
     * Constructor sem id
     * @param elementoUfpr {@link #elementoUfpr}
     * @param detalhe {@link #detalhe}
     * @param quantidade {@link #quantidade}
     */
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
