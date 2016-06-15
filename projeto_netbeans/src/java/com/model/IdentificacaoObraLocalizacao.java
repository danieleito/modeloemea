/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Daniele Harumi Ito
 */
public class IdentificacaoObraLocalizacao {
    private int id;
    private Uf idUf;
    private Via idVia;
    private String localVia;
    private String cidadeMaisProxima;
    private String pnvAno;
    private String pnsVersao;
    private String pnvCodigo;
    private String pnvAltitude;
    private String latitudeGrau;
    private String latitudeMinuto;
    private String longitudeGrau;
    private String longitudeMinuto;

    public IdentificacaoObraLocalizacao() {
    }

    public IdentificacaoObraLocalizacao(int id, Uf idUf, Via idVia, String localVia, 
            String cidadeMaisProxima, String pnvAno, String pnsVersao, String pnvCodigo, 
            String pnvAltitude, String latitudeGrau, String latitudeMinuto, 
            String longitudeGrau, String longitudeMinuto) {
        this.id = id;
        this.idUf = idUf;
        this.idVia = idVia;
        this.localVia = localVia;
        this.cidadeMaisProxima = cidadeMaisProxima;
        this.pnvAno = pnvAno;
        this.pnsVersao = pnsVersao;
        this.pnvCodigo = pnvCodigo;
        this.pnvAltitude = pnvAltitude;
        this.latitudeGrau = latitudeGrau;
        this.latitudeMinuto = latitudeMinuto;
        this.longitudeGrau = longitudeGrau;
        this.longitudeMinuto = longitudeMinuto;
    }

    public IdentificacaoObraLocalizacao(Uf idUf, Via idVia, String localVia, String cidadeMaisProxima, String pnvAno, String pnsVersao, String pnvCodigo, String pnvAltitude, String latitudeGrau, String latitudeMinuto, String longitudeGrau, String longitudeMinuto) {
        this.idUf = idUf;
        this.idVia = idVia;
        this.localVia = localVia;
        this.cidadeMaisProxima = cidadeMaisProxima;
        this.pnvAno = pnvAno;
        this.pnsVersao = pnsVersao;
        this.pnvCodigo = pnvCodigo;
        this.pnvAltitude = pnvAltitude;
        this.latitudeGrau = latitudeGrau;
        this.latitudeMinuto = latitudeMinuto;
        this.longitudeGrau = longitudeGrau;
        this.longitudeMinuto = longitudeMinuto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Uf getIdUf() {
        return idUf;
    }

    public void setIdUf(Uf idUf) {
        this.idUf = idUf;
    }

    public Via getIdVia() {
        return idVia;
    }

    public void setIdVia(Via idVia) {
        this.idVia = idVia;
    }

    public String getLocalVia() {
        return localVia;
    }

    public void setLocalVia(String localVia) {
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

    public String getPnsVersao() {
        return pnsVersao;
    }

    public void setPnsVersao(String pnsVersao) {
        this.pnsVersao = pnsVersao;
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
