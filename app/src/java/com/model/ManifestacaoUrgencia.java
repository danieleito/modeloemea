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
public class ManifestacaoUrgencia implements Serializable {
    private int id;
    private String descricao;
    private String criterio;
    private double capa4;

    public ManifestacaoUrgencia() {
    }

    public ManifestacaoUrgencia(int id, String descricao, String criterio, double capa4) {
        this.id = id;
        this.descricao = descricao;
        this.criterio = criterio;
        this.capa4 = capa4;
    }

    public ManifestacaoUrgencia(String descricao, String criterio, double capa4) {
        this.descricao = descricao;
        this.criterio = criterio;
        this.capa4 = capa4;
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

    public double getCapa4() {
        return capa4;
    }

    public void setCapa4(double capa4) {
        this.capa4 = capa4;
    }
    
    @Override
    public String toString() {
        return this.descricao;
    }
}
