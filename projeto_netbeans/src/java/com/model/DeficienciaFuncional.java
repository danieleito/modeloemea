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
public class DeficienciaFuncional {
    private int id;
    private String codigo;
    private String descricao;
    private String unidadeMedida;

    public DeficienciaFuncional() {
    }

    public DeficienciaFuncional(int id, String codigo, String descricao, String unidadeMedida) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
    }

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
