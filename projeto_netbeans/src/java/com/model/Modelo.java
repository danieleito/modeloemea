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
    private int id;
    private String indiceBase;
    private String indicePerformance;

    public Modelo() {
    }

    public Modelo(int id, String indiceBase, String indicePerformance) {
        this.id = id;
        this.indiceBase = indiceBase;
        this.indicePerformance = indicePerformance;
    }

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
