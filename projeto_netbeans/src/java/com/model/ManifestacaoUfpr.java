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
public class ManifestacaoUfpr implements Serializable {
    /**
     * identificador do ManifestacaoUfpr no Banco de Dados
     */
    private int id;
    /**
     * elemento da ufpr
     */
    private ElementoUfpr elementoUfpr;
    /**
     * código da manifestação
     */
    private String codigo;
    /**
     * descrição da manifestação
     */
    private String descricao;
    /**
     * unidade 
     */
    private String unidade;
    /**
     * beta da manifestação da ufpr 
     */
    private String beta;


    /**
     * Constructor padrão
     */
    public ManifestacaoUfpr() {
        elementoUfpr = new ElementoUfpr();
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param elementoUfpr {@link #elementoUfpr}
     * @param codigo {@link #codigo}
     * @param descricao {@link #descricao}
     * @param unidade {@link #unidade}
     * @param beta {@link #beta}
     */
    public ManifestacaoUfpr(int id, ElementoUfpr elementoUfpr, String codigo, String descricao, String unidade, String beta) {
        this.id = id;
        this.elementoUfpr = elementoUfpr;
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidade = unidade;
        this.beta = beta;
    }

    /**
     * Constructor sem id
     * @param elementoUfpr {@link #elementoUfpr}
     * @param codigo {@link #codigo}
     * @param descricao {@link #descricao}
     * @param unidade {@link #unidade}
     * @param beta {@link #beta}
     */
    public ManifestacaoUfpr(ElementoUfpr elementoUfpr, String codigo, String descricao, String unidade, String beta) {
        this.elementoUfpr = elementoUfpr;
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidade = unidade;
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
     * retorna {@link #elementoUfpr}
     * @return {@link #elementoUfpr}
     */
    public ElementoUfpr getElementoUfpr() {
        return elementoUfpr;
    }

    public void setElementoUfpr(ElementoUfpr elementoUfpr) {
        this.elementoUfpr = elementoUfpr;
    }

    /**
     * retorna {@link #codigo}
     * @return {@link #codigo}
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * retorna {@link #unidade}
     * @return {@link #unidade}
     */
    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
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
        return descricao;
    }
}
