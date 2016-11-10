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
public class ManifestacaoExtensao implements Serializable {
    private int id;
    private String descricao;
    private String criterio;
    private Double capa2;

    public ManifestacaoExtensao() {
    }

    public ManifestacaoExtensao(int id, String descricao, String criterio, Double capa2) {
        this.id = id;
        this.descricao = descricao;
        this.criterio = criterio;
        this.capa2 = capa2;
    }

    public ManifestacaoExtensao(String descricao, String criterio, Double capa2) {
        this.descricao = descricao;
        this.criterio = criterio;
        this.capa2 = capa2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public Double getCapa2() {
        return capa2;
    }

    public void setCapa2(Double capa2) {
        this.capa2 = capa2;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
