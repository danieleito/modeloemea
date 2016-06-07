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
    private int idVia;
    private int idUf;
    private String localVia;
    private int idSuperintendenciaRegional;
    private int idUnidadeLocal;

    public Ponte() {
    }

    public Ponte(int id, String codigo, String identificacaoObra, int idVia, int idUf, String localVia, int idSuperintendenciaRegional, int idUnidadeLocal) {
        this.id = id;
        this.codigo = codigo;
        this.identificacaoObra = identificacaoObra;
        this.idVia = idVia;
        this.idUf = idUf;
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

    public int getIdUf() {
        return idUf;
    }

    public void setIdUf(int idUf) {
        this.idUf = idUf;
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
