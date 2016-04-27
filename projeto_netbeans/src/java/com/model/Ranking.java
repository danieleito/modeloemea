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
public class Ranking {
    private int id;
    private Ponte ponte;
    private Simulacao simulacao;
    private int classificacao;
    private String indicePerformanceRelativo;

    public Ranking() {
    }

    public Ranking(int id, Ponte ponte, Simulacao simulacao, int classificacao, String indicePerformanceRelativo) {
        this.id = id;
        this.ponte = ponte;
        this.simulacao = simulacao;
        this.classificacao = classificacao;
        this.indicePerformanceRelativo = indicePerformanceRelativo;
    }

    public Ranking(Ponte ponte, Simulacao simulacao, int classificacao, String indicePerformanceRelativo) {
        this.ponte = ponte;
        this.simulacao = simulacao;
        this.classificacao = classificacao;
        this.indicePerformanceRelativo = indicePerformanceRelativo;
    }

    public int getId() {
        return id;
    }

    public Ponte getPonte() {
        return ponte;
    }

    public Simulacao getSimulacao() {
        return simulacao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public String getIndicePerformanceRelativo() {
        return indicePerformanceRelativo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPonte(Ponte ponte) {
        this.ponte = ponte;
    }

    public void setSimulacao(Simulacao simulacao) {
        this.simulacao = simulacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public void setIndicePerformanceRelativo(String indicePerformanceRelativo) {
        this.indicePerformanceRelativo = indicePerformanceRelativo;
    }
}
