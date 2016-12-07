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
    /**
     * código da elemento da ufpr
     */
    private String codigo;
    /**
     * descrição do elemento da ufpr
     */
    private String descricao;
    /**
     * capa do elemento da ufpr
     */
    private double capa1;


    /**
     * Constructor padrão.
     */
    public ElementoUfpr() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param codigo {@link #codigo}
     * @param descricao {@link #descricao}
     * @param capa1 {@link #capa1}
     */
    public ElementoUfpr(int id, String codigo, String descricao, double capa1) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.capa1 = capa1;
    }

    /**
     * Constructor sem id
     * @param codigo {@link #codigo}
     * @param descricao {@link #descricao}
     * @param capa1 {@link #capa1}
     */
    public ElementoUfpr(String codigo, String descricao, double capa1) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.capa1 = capa1;
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
     * retorna {@link #capa}
     * @return {@link #capa}
     */
    public double getCapa1() {
        return capa1;
    }

    public void setCapa1(double capa1) {
        this.capa1 = capa1;
    }
    
    @Override
    public String toString() {
        return this.descricao;
    }
}
