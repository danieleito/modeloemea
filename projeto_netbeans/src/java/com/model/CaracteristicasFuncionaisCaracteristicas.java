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
public class CaracteristicasFuncionaisCaracteristicas implements Serializable {
    /**
     * identificador do CaracteristicasFuncionaisCaracteristicas no Banco de Dados
     */
    private int id;
    /**
     * identificador do tipo regiao
     */
    private TipoRegiao tipoRegiao;
    /**
     * identificador do tipo tracado
     */
    private TipoTracado tipoTracado;
    /**
     * rampa maxima
     */
    private String rampaMaxima;
    /**
     * raio da curva
     */
    private String raioCurva;
    /**
     * vmd
     */
    private String vmd;

    /**
     * Constructor padrão.
     */
    public CaracteristicasFuncionaisCaracteristicas() {
    }

    public CaracteristicasFuncionaisCaracteristicas(int id, TipoRegiao tipoRegiao, TipoTracado tipoTracado, String rampaMaxima, String raioCurva, String vmd) {
        this.id = id;
        this.tipoRegiao = tipoRegiao;
        this.tipoTracado = tipoTracado;
        this.rampaMaxima = rampaMaxima;
        this.raioCurva = raioCurva;
        this.vmd = vmd;
    }

    public CaracteristicasFuncionaisCaracteristicas(TipoRegiao tipoRegiao, TipoTracado tipoTracado, String rampaMaxima, String raioCurva, String vmd) {
        this.tipoRegiao = tipoRegiao;
        this.tipoTracado = tipoTracado;
        this.rampaMaxima = rampaMaxima;
        this.raioCurva = raioCurva;
        this.vmd = vmd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoRegiao getTipoRegiao() {
        return tipoRegiao;
    }

    public void setTipoRegiao(TipoRegiao tipoRegiao) {
        this.tipoRegiao = tipoRegiao;
    }

    public TipoTracado getTipoTracado() {
        return tipoTracado;
    }

    public void setTipoTracado(TipoTracado tipoTracado) {
        this.tipoTracado = tipoTracado;
    }

    public String getRampaMaxima() {
        return rampaMaxima;
    }

    public void setRampaMaxima(String rampaMaxima) {
        this.rampaMaxima = rampaMaxima;
    }

    public String getRaioCurva() {
        return raioCurva;
    }

    public void setRaioCurva(String raioCurva) {
        this.raioCurva = raioCurva;
    }

    public String getVmd() {
        return vmd;
    }

    public void setVmd(String vmd) {
        this.vmd = vmd;
    }
}
