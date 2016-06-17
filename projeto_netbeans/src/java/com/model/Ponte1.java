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
public class Ponte1 {
    private int id;
    private String codigo;
    private String identificacaoObra;
    private int idVia;
    private Uf uf;
    private String localVia;
    private int idSuperintendenciaRegional;
    private int idUnidadeLocal;

    public Ponte1() {
        uf = new Uf();
//        this.uf = new Uf();
    }

    public Ponte1(int id, String codigo, String identificacaoObra, int idVia, 
            Uf uf, String localVia, int idSuperintendenciaRegional, int idUnidadeLocal) {
        this.id = id;
        this.codigo = codigo;
        this.identificacaoObra = identificacaoObra;
        this.idVia = idVia;
        this.uf = uf;
        this.localVia = localVia;
        this.idSuperintendenciaRegional = idSuperintendenciaRegional;
        this.idUnidadeLocal = idUnidadeLocal;
    }

    public Ponte1(String codigo, String identificacaoObra, int idVia, Uf uf, 
            String localVia, int idSuperintendenciaRegional, int idUnidadeLocal) {
        this.codigo = codigo;
        this.identificacaoObra = identificacaoObra;
        this.idVia = idVia;
        this.uf = uf;
        this.localVia = localVia;
        this.idSuperintendenciaRegional = idSuperintendenciaRegional;
        this.idUnidadeLocal = idUnidadeLocal;
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

    public int getIdVia() {
        return idVia;
    }

    public void setIdVia(int idVia) {
        this.idVia = idVia;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public String getLocalVia() {
        return localVia;
    }

    public void setLocalVia(String localVia) {
        this.localVia = localVia;
    }

    public int getIdSuperintendenciaRegional() {
        return idSuperintendenciaRegional;
    }

    public void setIdSuperintendenciaRegional(int idSuperintendenciaRegional) {
        this.idSuperintendenciaRegional = idSuperintendenciaRegional;
    }

    public int getIdUnidadeLocal() {
        return idUnidadeLocal;
    }

    public void setIdUnidadeLocal(int idUnidadeLocal) {
        this.idUnidadeLocal = idUnidadeLocal;
    }

    @Override
    public String toString() {
        return this.codigo;
    }
}
