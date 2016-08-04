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
public class InspecaoRotineira implements Serializable {
    private int id;
    private Inspecao inspecao;
    private IdentificacaoObraSgo identificacaoObraSgo;
    private CondicaoSgo condicaoSgo;
    private DanoElementoSgo danoElementoSgo;
    private InsuficienciaEstruturalElementoSgo insuficienciaEstruturalElementoSgo;
    private LaudoEspecializadoSgo laudoEspecializadoSgo;
    private MonitoramentoSgo monitoramentoSgo;
    private String relatorio;

    public InspecaoRotineira() {
    }

    public InspecaoRotineira(int id, Inspecao inspecao, IdentificacaoObraSgo identificacaoObraSgo, CondicaoSgo condicaoSgo, DanoElementoSgo danoElementoSgo, InsuficienciaEstruturalElementoSgo insuficienciaEstruturalElementoSgo, LaudoEspecializadoSgo laudoEspecializadoSgo, MonitoramentoSgo monitoramentoSgo, String relatorio) {
        this.id = id;
        this.inspecao = inspecao;
        this.identificacaoObraSgo = identificacaoObraSgo;
        this.condicaoSgo = condicaoSgo;
        this.danoElementoSgo = danoElementoSgo;
        this.insuficienciaEstruturalElementoSgo = insuficienciaEstruturalElementoSgo;
        this.laudoEspecializadoSgo = laudoEspecializadoSgo;
        this.monitoramentoSgo = monitoramentoSgo;
        this.relatorio = relatorio;
    }

    public InspecaoRotineira(Inspecao inspecao, IdentificacaoObraSgo identificacaoObraSgo, CondicaoSgo condicaoSgo, DanoElementoSgo danoElementoSgo, InsuficienciaEstruturalElementoSgo insuficienciaEstruturalElementoSgo, LaudoEspecializadoSgo laudoEspecializadoSgo, MonitoramentoSgo monitoramentoSgo, String relatorio) {
        this.inspecao = inspecao;
        this.identificacaoObraSgo = identificacaoObraSgo;
        this.condicaoSgo = condicaoSgo;
        this.danoElementoSgo = danoElementoSgo;
        this.insuficienciaEstruturalElementoSgo = insuficienciaEstruturalElementoSgo;
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

    public DanoElementoSgo getDanoElementoSgo() {
        return danoElementoSgo;
    }

    public void setDanoElementoSgo(DanoElementoSgo danoElementoSgo) {
        this.danoElementoSgo = danoElementoSgo;
    }

    public InsuficienciaEstruturalElementoSgo getInsuficienciaEstruturalElementoSgo() {
        return insuficienciaEstruturalElementoSgo;
    }

    public void setInsuficienciaEstruturalElementoSgo(InsuficienciaEstruturalElementoSgo insuficienciaEstruturalElementoSgo) {
        this.insuficienciaEstruturalElementoSgo = insuficienciaEstruturalElementoSgo;
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
}
