/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.Date;

/**
 *
 * @author Daniele Harumi Ito
 */
public class Ranking {
    private int id;
    private Date dataUltimaInspecao;
    private Ponte ponte;
    //private Simulacao simulacao;
    private int classificacao;
    private String indicePerformanceRelativo;

    public Ranking() {
    }

    public Ranking(int id, Date dataUltimaInspecao, Ponte ponte, int classificacao, String indicePerformanceRelativo) {
        this.id = id;
        this.dataUltimaInspecao = dataUltimaInspecao;
        this.ponte = ponte;
        this.classificacao = classificacao;
        this.indicePerformanceRelativo = indicePerformanceRelativo;
    }

    public Ranking(Date dataUltimaInspecao, Ponte ponte, int classificacao, String indicePerformanceRelativo) {
        this.dataUltimaInspecao = dataUltimaInspecao;
        this.ponte = ponte;
        this.classificacao = classificacao;
        this.indicePerformanceRelativo = indicePerformanceRelativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataUltimaInspecao() {
        return dataUltimaInspecao;
    }

    public void setDataUltimaInspecao(Date dataUltimaInspecao) {
        this.dataUltimaInspecao = dataUltimaInspecao;
    }

    public Ponte getPonte() {
        return ponte;
    }

    public void setPonte(Ponte ponte) {
        this.ponte = ponte;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getIndicePerformanceRelativo() {
        return indicePerformanceRelativo;
    }

    public void setIndicePerformanceRelativo(String indicePerformanceRelativo) {
        this.indicePerformanceRelativo = indicePerformanceRelativo;
    }
}
