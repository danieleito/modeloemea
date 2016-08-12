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
     * retorna {@link #inspecao}
     * @return {@link #inspecao}
     */
    public Inspecao getInspecao() {
        return inspecao;
    }

    public void setInspecao(Inspecao inspecao) {
        this.inspecao = inspecao;
    }

    /**
     * retorna {@link #identificacaoObraSgo}
     * @return {@link #identificacaoObraSgo}
     */
    public IdentificacaoObraSgo getIdentificacaoObraSgo() {
        return identificacaoObraSgo;
    }

    public void setIdentificacaoObraSgo(IdentificacaoObraSgo identificacaoObraSgo) {
        this.identificacaoObraSgo = identificacaoObraSgo;
    }

    /**
     * retorna {@link #condicaoSgo}
     * @return {@link #condicaoSgo}
     */
    public CondicaoSgo getCondicaoSgo() {
        return condicaoSgo;
    }

    public void setCondicaoSgo(CondicaoSgo condicaoSgo) {
        this.condicaoSgo = condicaoSgo;
    }

    /**
     * retorna {@link #laudoEspecializadoSgo}
     * @return {@link #laudoEspecializadoSgo}
     */
    public LaudoEspecializadoSgo getLaudoEspecializadoSgo() {
        return laudoEspecializadoSgo;
    }

    public void setLaudoEspecializadoSgo(LaudoEspecializadoSgo laudoEspecializadoSgo) {
        this.laudoEspecializadoSgo = laudoEspecializadoSgo;
    }

    /**
     * retorna {@link #monitoramentoSgo}
     * @return {@link #monitoramentoSgo}
     */
    public MonitoramentoSgo getMonitoramentoSgo() {
        return monitoramentoSgo;
    }

    public void setMonitoramentoSgo(MonitoramentoSgo monitoramentoSgo) {
        this.monitoramentoSgo = monitoramentoSgo;
    }

    /**
     * retorna {@link #relatorio}
     * @return {@link #relatorio}
     */
    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    /**
     * retorna {@link #danosElementosSgo}
     * @return {@link #danosElementosSgo}
     */
    public ArrayList<DanoElementoSgo> getDanosElementosSgo() {
        return danosElementosSgo;
    }

    public void setDanosElementosSgo(ArrayList<DanoElementoSgo> danosElementosSgo) {
        this.danosElementosSgo = danosElementosSgo;
    }

    /**
     * retorna {@link #insuficienciasEstruturaisElementosSgo}
     * @return {@link #insuficienciasEstruturaisElementosSgo}
     */
    public ArrayList<InsuficienciaEstruturalElementoSgo> getInsuficienciasEstruturaisElementosSgo() {
        return insuficienciasEstruturaisElementosSgo;
    }

    public void setInsuficienciasEstruturaisElementosSgo(ArrayList<InsuficienciaEstruturalElementoSgo> insuficienciasEstruturaisElementosSgo) {
        this.insuficienciasEstruturaisElementosSgo = insuficienciasEstruturaisElementosSgo;
    }
}
