/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Daniele Harumi Ito
 */
public class Inspecao implements Serializable {
    /**
     * identificador do Inspecao no Banco de Dados
     */
    private int id;
    /**
     * data da inspeção
     */
    private Date data;
    /**
     * identificador do usuário
     */
    private Usuario usuario;
    /**
     * identificador do modelo
     */
    private Modelo modelo;    

    /**
     * identificador da identificação obra do sgo
     */
    private IdentificacaoObraSgo identificacaoObraSgo;
    /**
     * identificador da condição do sgo
     */
    private CondicaoSgo condicaoSgo;
    /**
     * identificador do laudo especializado do sgo
     */
    private LaudoEspecializadoSgo laudoEspecializadoSgo;
    /**
     * identificador do monitoramento do sgo
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
     * lista arquivos anexos
     */
    private ArrayList<ArquivoAnexoInspecao> arquivosAnexosInspecao;
    
    private int idPonte;
    private ArrayList<InspecaoManifestacaoElemento> inspecaoManifestacaoElemento;


    /**
     * Constructor padrão.
     */
    public Inspecao() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param data {@link #data}
     * @param usuario {@link #usuario}
     * @param modelo {@link #modelo}
     */
    public Inspecao(int id, Date data, Usuario usuario, Modelo modelo) {
        this.id = id;
        this.data = data;
        this.usuario = usuario;
        this.modelo = modelo;
    }

    /**
     * Constructor sem id
     * @param data {@link #data}
     * @param usuario {@link #usuario}
     * @param modelo {@link #modelo}
     */
    public Inspecao(Date data, Usuario usuario, Modelo modelo) {
        this.data = data;
        this.usuario = usuario;
        this.modelo = modelo;
    
    }

    /**
     * Constructor apenas com id
     * @param id {@link #id}
     */
    public Inspecao(int id) {
        this.id = id;
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
     * retorna {@link #data}
     * @return {@link #data}
     */
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    /**
     * retorna {@link #usuario}
     * @return {@link #usuario}
     */
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * retorna {@link #modelo}
     * @return {@link #modelo}
     */
    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
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

    public ArrayList<ArquivoAnexoInspecao> getArquivosAnexosInspecao() {
        return arquivosAnexosInspecao;
    }

    public void setArquivosAnexosInspecao(ArrayList<ArquivoAnexoInspecao> arquivosAnexosInspecao) {
        this.arquivosAnexosInspecao = arquivosAnexosInspecao;
    }

    public int getIdPonte() {
        return idPonte;
    }

    public void setIdPonte(int idPonte) {
        this.idPonte = idPonte;
    }

    public ArrayList<InspecaoManifestacaoElemento> getInspecaoManifestacaoElemento() {
        return inspecaoManifestacaoElemento;
    }

    public void setInspecaoManifestacaoElemento(ArrayList<InspecaoManifestacaoElemento> inspecaoManifestacaoElemento) {
        this.inspecaoManifestacaoElemento = inspecaoManifestacaoElemento;
    }    
}
