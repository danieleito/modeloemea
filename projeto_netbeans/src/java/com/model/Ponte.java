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
public class Ponte {
    private int id;
    private String codigo;
    private String identificacaoObra;
    private String via;
    private String uf;
    private String localVia;

    public Ponte() {
    }

    public Ponte(int id, String codigo, String identificacaoObra, String via, String uf, String localVia) {
        this.id = id;
        this.codigo = codigo;
        this.identificacaoObra = identificacaoObra;
        this.via = via;
        this.uf = uf;
        this.localVia = localVia;
    }

    public Ponte(String codigo, String identificacaoObra, String via, String uf, String localVia) {
        this.codigo = codigo;
        this.identificacaoObra = identificacaoObra;
        this.via = via;
        this.uf = uf;
        this.localVia = localVia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdentificacaoObra() {
        return identificacaoObra;
    }

    public void setIdentificacaoObra(String identificacaoObra) {
        this.identificacaoObra = identificacaoObra;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLocalVia() {
        return localVia;
    }

    public void setLocalVia(String localVia) {
        this.localVia = localVia;
    }
    
    @Override
    public String toString() {
        return this.codigo;
    }
}
