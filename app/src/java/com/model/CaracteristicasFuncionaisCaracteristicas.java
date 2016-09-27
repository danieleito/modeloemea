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

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param tipoRegiao {@link #tipoRegiao}
     * @param tipoTracado {@link #tipoTracado}
     * @param rampaMaxima {@link #rampaMaxima}
     * @param raioCurva {@link #raioCurva}
     * @param vmd {@link #vmd}
     */
    public CaracteristicasFuncionaisCaracteristicas(int id, TipoRegiao tipoRegiao, TipoTracado tipoTracado, String rampaMaxima, String raioCurva, String vmd) {
        this.id = id;
        this.tipoRegiao = tipoRegiao;
        this.tipoTracado = tipoTracado;
        this.rampaMaxima = rampaMaxima;
        this.raioCurva = raioCurva;
        this.vmd = vmd;
    }

    /**
     * Constructor sem id
     * @param tipoRegiao {@link #tipoRegiao}
     * @param tipoTracado {@link #tipoTracado}
     * @param rampaMaxima {@link #rampaMaxima}
     * @param raioCurva {@link #raioCurva}
     * @param vmd {@link #vmd}
     */
    public CaracteristicasFuncionaisCaracteristicas(TipoRegiao tipoRegiao, TipoTracado tipoTracado, String rampaMaxima, String raioCurva, String vmd) {
        this.tipoRegiao = tipoRegiao;
        this.tipoTracado = tipoTracado;
        this.rampaMaxima = rampaMaxima;
        this.raioCurva = raioCurva;
        this.vmd = vmd;
    }


    /**
     * retorna {@link #id}
     * @return {@link #id}
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * retorna {@link #tipoRegiao}
     * @return {@link #tipoRegiao}
     */
    public TipoRegiao getTipoRegiao() {
        return tipoRegiao;
    }

    public void setTipoRegiao(TipoRegiao tipoRegiao) {
        this.tipoRegiao = tipoRegiao;
    }

    /**
     * retorna {@link #tipoTracado}
     * @return {@link #tipoTracado}
     */
    public TipoTracado getTipoTracado() {
        return tipoTracado;
    }

    public void setTipoTracado(TipoTracado tipoTracado) {
        this.tipoTracado = tipoTracado;
    }

    /**
     * retorna {@link #rampaMaxima}
     * @return {@link #rampaMaxima}
     */
    public String getRampaMaxima() {
        return rampaMaxima;
    }

    public void setRampaMaxima(String rampaMaxima) {
        this.rampaMaxima = rampaMaxima;
    }

    /**
     * retorna {@link #raioCurva}
     * @return {@link #raioCurva}
     */
    public String getRaioCurva() {
        return raioCurva;
    }

    public void setRaioCurva(String raioCurva) {
        this.raioCurva = raioCurva;
    }

    /**
     * retorna {@link #vmd}
     * @return {@link #vmd}
     */
    public String getVmd() {
        return vmd;
    }

    public void setVmd(String vmd) {
        this.vmd = vmd;
    }
}
