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
public class MonitoramentoSgo implements Serializable {
    /**
     * identificador do MonitoramentoSgo no Banco de Dados
     */
    private int id;
    /**
     * período
     */
    private String periodo;
    /**
     * tipo de monitoramento
     */
    private String tipoMonitoramento;
    /**
     * executor
     */
    private String executor;
    /**
     * custo
     */
    private String custo;
    /**
     * objeto
     */
    private String objeto;
    /**
     * técnicas
     */
    private String tecnicas;


    /**
     * Constructor padrão
     */
    public MonitoramentoSgo() {
    }

    /**
     * Constructor completo
     * @param id
     * @param periodo
     * @param tipoMonitoramento
     * @param executor
     * @param custo
     * @param objeto
     * @param tecnicas 
     */
    public MonitoramentoSgo(int id, String periodo, String tipoMonitoramento, String executor, String custo, String objeto, String tecnicas) {
        this.id = id;
        this.periodo = periodo;
        this.tipoMonitoramento = tipoMonitoramento;
        this.executor = executor;
        this.custo = custo;
        this.objeto = objeto;
        this.tecnicas = tecnicas;
    }

    public MonitoramentoSgo(String periodo, String tipoMonitoramento, String executor, String custo, String objeto, String tecnicas) {
        this.periodo = periodo;
        this.tipoMonitoramento = tipoMonitoramento;
        this.executor = executor;
        this.custo = custo;
        this.objeto = objeto;
        this.tecnicas = tecnicas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getTipoMonitoramento() {
        return tipoMonitoramento;
    }

    public void setTipoMonitoramento(String tipoMonitoramento) {
        this.tipoMonitoramento = tipoMonitoramento;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getTecnicas() {
        return tecnicas;
    }

    public void setTecnicas(String tecnicas) {
        this.tecnicas = tecnicas;
    }
}
