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
public class IdentificacaoObraLocalizacao implements Serializable {
    /**
     * identificador do IdentificacaoObraLocalizacao no Banco de Dados
     */
    private int id;
    /**
     * idenficador do uf
     */
    private Uf uf;
    /**
     * identificador da via
     */
    private Via via;
    /**
     * km na via
     */
    private double localVia;
    /**
     * cidade mais próxima 
     */
    private String cidadeMaisProxima;
    /**
     * pnv ano
     */
    private String pnvAno;
    /**
     * pnv versão
     */
    private String pnvVersao;
    /**
     * pnv código
     */
    private String pnvCodigo;
    /**
     * pnv altitude
     */
    private String pnvAltitude;
    /**
     * latitude em graus
     */
    private String latitudeGrau;
    /**
     * latitude em minutos
     */
    private String latitudeMinuto;
    /**
     * lontitude em grau
     */
    private String longitudeGrau;
    /**
     * longitude em minutos
     */
    private String longitudeMinuto;


    /**
     * Constructor padrão.
     */
    public IdentificacaoObraLocalizacao() {
        uf = new Uf();
        via = new Via();
    }

    /**
     * Constructor completo
     * @param id
     * @param uf
     * @param via
     * @param localVia
     * @param cidadeMaisProxima
     * @param pnvAno
     * @param pnvVersao
     * @param pnvCodigo
     * @param pnvAltitude
     * @param latitudeGrau
     * @param latitudeMinuto
     * @param longitudeGrau
     * @param longitudeMinuto 
     */
    public IdentificacaoObraLocalizacao(int id, Uf uf, Via via, double localVia, String cidadeMaisProxima, String pnvAno, String pnvVersao, String pnvCodigo, String pnvAltitude, String latitudeGrau, String latitudeMinuto, String longitudeGrau, String longitudeMinuto) {
        this.id = id;
        this.uf = uf;
        this.via = via;
        this.localVia = localVia;
        this.cidadeMaisProxima = cidadeMaisProxima;
        this.pnvAno = pnvAno;
        this.pnvVersao = pnvVersao;
        this.pnvCodigo = pnvCodigo;
        this.pnvAltitude = pnvAltitude;
        this.latitudeGrau = latitudeGrau;
        this.latitudeMinuto = latitudeMinuto;
        this.longitudeGrau = longitudeGrau;
        this.longitudeMinuto = longitudeMinuto;
    }

    public IdentificacaoObraLocalizacao(Uf uf, Via via, double localVia, String cidadeMaisProxima, String pnvAno, String pnvVersao, String pnvCodigo, String pnvAltitude, String latitudeGrau, String latitudeMinuto, String longitudeGrau, String longitudeMinuto) {
        this.uf = uf;
        this.via = via;
        this.localVia = localVia;
        this.cidadeMaisProxima = cidadeMaisProxima;
        this.pnvAno = pnvAno;
        this.pnvVersao = pnvVersao;
        this.pnvCodigo = pnvCodigo;
        this.pnvAltitude = pnvAltitude;
        this.latitudeGrau = latitudeGrau;
        this.latitudeMinuto = latitudeMinuto;
        this.longitudeGrau = longitudeGrau;
        this.longitudeMinuto = longitudeMinuto;
    }

//    Constructor para inspecao rotineira
    public IdentificacaoObraLocalizacao(int id, Via via, double localVia) {
        this.id = id;
        this.via = via;
        this.localVia = localVia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public Via getVia() {
        return via;
    }

    public void setVia(Via via) {
        this.via = via;
    }

    public double getLocalVia() {
        return localVia;
    }

    public void setLocalVia(double localVia) {
        this.localVia = localVia;
    }

    public String getCidadeMaisProxima() {
        return cidadeMaisProxima;
    }

    public void setCidadeMaisProxima(String cidadeMaisProxima) {
        this.cidadeMaisProxima = cidadeMaisProxima;
    }

    public String getPnvAno() {
        return pnvAno;
    }

    public void setPnvAno(String pnvAno) {
        this.pnvAno = pnvAno;
    }

    public String getPnvVersao() {
        return pnvVersao;
    }

    public void setPnvVersao(String pnsVersao) {
        this.pnvVersao = pnsVersao;
    }

    public String getPnvCodigo() {
        return pnvCodigo;
    }

    public void setPnvCodigo(String pnvCodigo) {
        this.pnvCodigo = pnvCodigo;
    }

    public String getPnvAltitude() {
        return pnvAltitude;
    }

    public void setPnvAltitude(String pnvAltitude) {
        this.pnvAltitude = pnvAltitude;
    }

    public String getLatitudeGrau() {
        return latitudeGrau;
    }

    public void setLatitudeGrau(String latitudeGrau) {
        this.latitudeGrau = latitudeGrau;
    }

    public String getLatitudeMinuto() {
        return latitudeMinuto;
    }

    public void setLatitudeMinuto(String latitudeMinuto) {
        this.latitudeMinuto = latitudeMinuto;
    }

    public String getLongitudeGrau() {
        return longitudeGrau;
    }

    public void setLongitudeGrau(String longitudeGrau) {
        this.longitudeGrau = longitudeGrau;
    }

    public String getLongitudeMinuto() {
        return longitudeMinuto;
    }

    public void setLongitudeMinuto(String longitudeMinuto) {
        this.longitudeMinuto = longitudeMinuto;
    }

}
