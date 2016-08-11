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
public class DeficienciaFuncional implements Serializable {
    /**
     * identificador do DeficienciaFuncional no Banco de Dados
     */
    private int id;
    /**
     * código da deficiência funcional
     */
    private String codigo;
    /**
     * deficiência funcional
     */
    private String descricao;
    /**
     * unidade
     */
    private String unidadeMedida;


    /**
     * Constructor padrão.
     */
    public DeficienciaFuncional() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param codigo {@link #codigo}
     * @param descricao {@link #descricao}
     * @param unidadeMedida {@link #unidadeMedida}
     */
    public DeficienciaFuncional(int id, String codigo, String descricao, String unidadeMedida) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
    }

    /**
     * Constructor sem id
     * @param codigo {@link #codigo}
     * @param descricao {@link #descricao}
     * @param unidadeMedida {@link #unidadeMedida}
     */
    public DeficienciaFuncional(String codigo, String descricao, String unidadeMedida) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
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

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}
