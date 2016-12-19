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
        //cidade mais proxima, pnvAno, pnvversao, pnvcodigo
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param uf {@link #uf}
     * @param via {@link #via}
     * @param localVia {@link #localVia}
     * @param cidadeMaisProxima {@link #cidadeMaisProxima}
     * @param pnvAno {@link #pnvAno}
     * @param pnvVersao {@link #pnvVersao}
     * @param pnvCodigo {@link #pnvCodigo}
     * @param pnvAltitude {@link #pnvAltitude}
     * @param latitudeGrau {@link #latitudeGrau}
     * @param latitudeMinuto {@link #latitudeMinuto}
     * @param longitudeGrau {@link #longitudeGrau}
     * @param longitudeMinuto {@link #longitudeMinuto}
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

    /**
     * Constructor sem id
     * @param uf {@link #uf}
     * @param via {@link #via}
     * @param localVia {@link #localVia}
     * @param cidadeMaisProxima {@link #cidadeMaisProxima}
     * @param pnvAno {@link #pnvAno}
     * @param pnvVersao {@link #pnvVersao}
     * @param pnvCodigo {@link #pnvCodigo}
     * @param pnvAltitude {@link #pnvAltitude}
     * @param latitudeGrau {@link #latitudeGrau}
     * @param latitudeMinuto {@link #latitudeMinuto}
     * @param longitudeGrau {@link #longitudeGrau}
     * @param longitudeMinuto {@link #longitudeMinuto}
     */
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

    /**
     * Constructor para inspecao rotineira
     * @param id {@link #id}
     * @param via {@link #via}
     * @param localVia {@link #localVia}
     */
    public IdentificacaoObraLocalizacao(int id, Via via, double localVia) {
        this.id = id;
        this.via = via;
        this.localVia = localVia;
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
     * retorna {@link #uf}
     * @return {@link #uf}
     */
    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    /**
     * retorna {@link #via}
     * @return {@link #via}
     */
    public Via getVia() {
        return via;
    }

    public void setVia(Via via) {
        this.via = via;
    }

    /**
     * retorna {@link #localVia}
     * @return {@link #localVia}
     */
    public double getLocalVia() {
        return localVia;
    }

    public void setLocalVia(double localVia) {
        this.localVia = localVia;
    }

    /**
     * retorna {@link #cidadeMaisProxima}
     * @return {@link #cidadeMaisProxima}
     */
    public String getCidadeMaisProxima() {
        return cidadeMaisProxima;
    }

    public void setCidadeMaisProxima(String cidadeMaisProxima) {
        this.cidadeMaisProxima = cidadeMaisProxima;
    }

    /**
     * retorna {@link #pnvAno}
     * @return {@link #pnvAno}
     */
    public String getPnvAno() {
        return pnvAno;
    }

    public void setPnvAno(String pnvAno) {
        this.pnvAno = pnvAno;
    }

    /**
     * retorna {@link #pnvVersao}
     * @return {@link #pnvVersao}
     */
    public String getPnvVersao() {
        return pnvVersao;
    }

    public void setPnvVersao(String pnsVersao) {
        this.pnvVersao = pnsVersao;
    }

    /**
     * retorna {@link #pnvCodigo}
     * @return {@link #pnvCodigo}
     */
    public String getPnvCodigo() {
        return pnvCodigo;
    }

    public void setPnvCodigo(String pnvCodigo) {
        this.pnvCodigo = pnvCodigo;
    }

    /**
     * retorna {@link #pnvAltitude}
     * @return {@link #pnvAltitude}
     */
    public String getPnvAltitude() {
        return pnvAltitude;
    }

    public void setPnvAltitude(String pnvAltitude) {
        this.pnvAltitude = pnvAltitude;
    }

    /**
     * retorna {@link #latitudeGrau}
     * @return {@link #latitudeGrau}
     */
    public String getLatitudeGrau() {
        return latitudeGrau;
    }

    public void setLatitudeGrau(String latitudeGrau) {
        this.latitudeGrau = latitudeGrau;
    }

    /**
     * retorna {@link #latitudeMinuto}
     * @return 
     */
    public String getLatitudeMinuto() {
        return latitudeMinuto;
    }

    public void setLatitudeMinuto(String latitudeMinuto) {
        this.latitudeMinuto = latitudeMinuto;
    }

    /**
     * retorna {@link #longitudeGrau}
     * @return {@link #longitudeGrau}
     */
    public String getLongitudeGrau() {
        return longitudeGrau;
    }

    public void setLongitudeGrau(String longitudeGrau) {
        this.longitudeGrau = longitudeGrau;
    }

    /**
     * retorna {@link #longitudeMinuto}
     * @return {@link #longitudeMinuto}
     */
    public String getLongitudeMinuto() {
        return longitudeMinuto;
    }

    public void setLongitudeMinuto(String longitudeMinuto) {
        this.longitudeMinuto = longitudeMinuto;
    }

}
