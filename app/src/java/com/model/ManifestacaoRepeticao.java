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
public class ManifestacaoRepeticao implements Serializable {
    private int id;
    private String criterio;
    private String limiteSuperior;
    private Double capa3;

    public ManifestacaoRepeticao() {
    }

    public ManifestacaoRepeticao(int id, String criterio, String limiteSuperior, Double capa3) {
        this.id = id;
        this.criterio = criterio;
        this.limiteSuperior = limiteSuperior;
        this.capa3 = capa3;
    }

    public ManifestacaoRepeticao(String criterio, String limiteSuperior, Double capa3) {
        this.criterio = criterio;
        this.limiteSuperior = limiteSuperior;
        this.capa3 = capa3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public String getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(String limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public Double getCapa3() {
        return capa3;
    }

    public void setCapa3(Double capa3) {
        this.capa3 = capa3;
    }
}
