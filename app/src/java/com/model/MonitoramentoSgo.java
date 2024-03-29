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
     * @param id {@link #id}
     * @param periodo {@link #periodo}
     * @param tipoMonitoramento {@link #tipoMonitoramento}
     * @param executor {@link #executor}
     * @param custo {@link #custo}
     * @param objeto {@link #objeto}
     * @param tecnicas {@link #tecnicas}
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

    /**
     * Constructor sem id
     * @param periodo {@link #periodo}
     * @param tipoMonitoramento {@link #tipoMonitoramento}
     * @param executor {@link #executor}
     * @param custo {@link #custo}
     * @param objeto {@link #objeto}
     * @param tecnicas {@link #tecnicas}
     */
    public MonitoramentoSgo(String periodo, String tipoMonitoramento, String executor, String custo, String objeto, String tecnicas) {
        this.periodo = periodo;
        this.tipoMonitoramento = tipoMonitoramento;
        this.executor = executor;
        this.custo = custo;
        this.objeto = objeto;
        this.tecnicas = tecnicas;
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
     * retorna {@link #periodo}
     * @return {@link #periodo}
     */
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    /**
     * retorna {@link #tipoMonitoramento}
     * @return {@link #tipoMonitoramento}
     */
    public String getTipoMonitoramento() {
        return tipoMonitoramento;
    }

    public void setTipoMonitoramento(String tipoMonitoramento) {
        this.tipoMonitoramento = tipoMonitoramento;
    }

    /**
     * retorna {@link #executor}
     * @return {@link #executor}
     */
    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    /**
     * retorna {@link #custo}
     * @return {@link #custo}
     */
    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    /**
     * retorna {@link #objeto}
     * @return {@link #objeto}
     */
    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    /**
     * retorna {@link #tecnicas}
     * @return {@link #tecnicas}
     */
    public String getTecnicas() {
        return tecnicas;
    }

    public void setTecnicas(String tecnicas) {
        this.tecnicas = tecnicas;
    }
}
