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
public class Manifestacao implements Serializable {
    private int id;
    private String manifestacao;
    private String beta;

    public Manifestacao() {
    }

    public Manifestacao(int id, String manifestacao, String beta) {
        this.id = id;
        this.manifestacao = manifestacao;
        this.beta = beta;
    }

    public Manifestacao(String manifestacao, String beta) {
        this.manifestacao = manifestacao;
        this.beta = beta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManifestacao() {
        return manifestacao;
    }

    public void setManifestacao(String manifestacao) {
        this.manifestacao = manifestacao;
    }

    public String getBeta() {
        return beta;
    }

    public void setBeta(String beta) {
        this.beta = beta;
    }
    
    @Override
    public String toString() {
        return this.manifestacao;
    }
}
