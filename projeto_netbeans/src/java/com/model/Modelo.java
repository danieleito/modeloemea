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
public class Modelo implements Serializable {
    /**
     * identificador do Modelo no Banco de Dados
     */
    private int id;
    /**
     * indice base
     */
    private String indiceBase;
    /**
     * indice de performance
     */
    private String indicePerformance;


    /**
     * Constructor padrão
     */
    public Modelo() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param indiceBase {@link #indiceBase}
     * @param indicePerformance {@link #indicePerformance}
     */
    public Modelo(int id, String indiceBase, String indicePerformance) {
        this.id = id;
        this.indiceBase = indiceBase;
        this.indicePerformance = indicePerformance;
    }

    /**
     * Constructor sem id
     * @param indiceBase {@link #indiceBase}
     * @param indicePerformance {@link #indicePerformance}
     */
    public Modelo(String indiceBase, String indicePerformance) {
        this.indiceBase = indiceBase;
        this.indicePerformance = indicePerformance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndiceBase() {
        return indiceBase;
    }

    public void setIndiceBase(String indiceBase) {
        this.indiceBase = indiceBase;
    }

    public String getIndicePerformance() {
        return indicePerformance;
    }

    public void setIndicePerformance(String indicePerformance) {
        this.indicePerformance = indicePerformance;
    }
}
