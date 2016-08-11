/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class InspecaoRotineira implements Serializable {
    private int id;
    /**
     * identificador do InspecaoRotineira no Banco de Dados
     */
    private Inspecao inspecao;
    /**
     * identificador da identificação da obra
     */
    private IdentificacaoObraSgo identificacaoObraSgo;
    /**
     * identificador da condição
     */
    private CondicaoSgo condicaoSgo;
//    private DanoElementoSgo danoElementoSgo;
//    private InsuficienciaEstruturalElementoSgo insuficienciaEstruturalElementoSgo;
    /**
     * identificador do laudo especializado
     */
    private LaudoEspecializadoSgo laudoEspecializadoSgo;
    /**
     * identificador do monitoramento
     */
    private MonitoramentoSgo monitoramentoSgo;
    /**
     * relatório
     */
    private String relatorio;
    /**
     * lista de danos elementos
     */
    private ArrayList<DanoElementoSgo> danosElementosSgo;
    /**
     * lista de insuficiências estruturais elementos
     */
    private ArrayList<InsuficienciaEstruturalElementoSgo> insuficienciasEstruturaisElementosSgo;


    /**
     * Constructor padrão.
     */
    public InspecaoRotineira() {
        danosElementosSgo = new ArrayList<>();
        insuficienciasEstruturaisElementosSgo = new ArrayList<>();
    }

    /**
     * Constructor apenas com id
     * @param id {@link #id}
     */
    public InspecaoRotineira(int id) {
        this.id = id;
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param inspecao {@link #inspecao}
     * @param identificacaoObraSgo {@link #identificacaoObraSgo}
     * @param condicaoSgo {@link #condicaoSgo}
     * @param laudoEspecializadoSgo {@link #laudoEspecializadoSgo}
     * @param monitoramentoSgo {@link #monitoramentoSgo}
     * @param relatorio {@link #relatorio}
     */
    public InspecaoRotineira(int id, Inspecao inspecao, IdentificacaoObraSgo identificacaoObraSgo, CondicaoSgo condicaoSgo, LaudoEspecializadoSgo laudoEspecializadoSgo, MonitoramentoSgo monitoramentoSgo, String relatorio) {
        this.id = id;
        this.inspecao = inspecao;
        this.identificacaoObraSgo = identificacaoObraSgo;
        this.condicaoSgo = condicaoSgo;
        this.laudoEspecializadoSgo = laudoEspecializadoSgo;
        this.monitoramentoSgo = monitoramentoSgo;
        this.relatorio = relatorio;
    }

    /**
     * 
     * @param inspecao {@link #inspecao}
     * @param identificacaoObraSgo {@link #identificacaoObraSgo}
     * @param condicaoSgo {@link #condicaoSgo}
     * @param laudoEspecializadoSgo {@link #laudoEspecializadoSgo}
     * @param monitoramentoSgo {@link #monitoramentoSgo}
     * @param relatorio {@link #relatorio}
     */
    public InspecaoRotineira(Inspecao inspecao, IdentificacaoObraSgo identificacaoObraSgo, CondicaoSgo condicaoSgo, LaudoEspecializadoSgo laudoEspecializadoSgo, MonitoramentoSgo monitoramentoSgo, String relatorio) {
        this.inspecao = inspecao;
        this.identificacaoObraSgo = identificacaoObraSgo;
        this.condicaoSgo = condicaoSgo;
        this.laudoEspecializadoSgo = laudoEspecializadoSgo;
        this.monitoramentoSgo = monitoramentoSgo;
        this.relatorio = relatorio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Inspecao getInspecao() {
        return inspecao;
    }

    public void setInspecao(Inspecao inspecao) {
        this.inspecao = inspecao;
    }

    public IdentificacaoObraSgo getIdentificacaoObraSgo() {
        return identificacaoObraSgo;
    }

    public void setIdentificacaoObraSgo(IdentificacaoObraSgo identificacaoObraSgo) {
        this.identificacaoObraSgo = identificacaoObraSgo;
    }

    public CondicaoSgo getCondicaoSgo() {
        return condicaoSgo;
    }

    public void setCondicaoSgo(CondicaoSgo condicaoSgo) {
        this.condicaoSgo = condicaoSgo;
    }

    public LaudoEspecializadoSgo getLaudoEspecializadoSgo() {
        return laudoEspecializadoSgo;
    }

    public void setLaudoEspecializadoSgo(LaudoEspecializadoSgo laudoEspecializadoSgo) {
        this.laudoEspecializadoSgo = laudoEspecializadoSgo;
    }

    public MonitoramentoSgo getMonitoramentoSgo() {
        return monitoramentoSgo;
    }

    public void setMonitoramentoSgo(MonitoramentoSgo monitoramentoSgo) {
        this.monitoramentoSgo = monitoramentoSgo;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public ArrayList<DanoElementoSgo> getDanosElementosSgo() {
        return danosElementosSgo;
    }

    public void setDanosElementosSgo(ArrayList<DanoElementoSgo> danosElementosSgo) {
        this.danosElementosSgo = danosElementosSgo;
    }

    public ArrayList<InsuficienciaEstruturalElementoSgo> getInsuficienciasEstruturaisElementosSgo() {
        return insuficienciasEstruturaisElementosSgo;
    }

    public void setInsuficienciasEstruturaisElementosSgo(ArrayList<InsuficienciaEstruturalElementoSgo> insuficienciasEstruturaisElementosSgo) {
        this.insuficienciasEstruturaisElementosSgo = insuficienciasEstruturaisElementosSgo;
    }
}
