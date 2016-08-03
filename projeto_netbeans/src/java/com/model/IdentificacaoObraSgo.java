/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Daniele Harumi Ito
 */
public class IdentificacaoObraSgo implements Serializable {
    private int id;
    private String codigo;
    private Date dataInspecao;
    private String nomePonte;
    private String nomeInspetor;
    private int via;
    private int uf;
    private String km;
    private int superintendenciaRegional;
    private String ul;

    public IdentificacaoObraSgo() {
    }

    public IdentificacaoObraSgo(int id, String codigo, Date dataInspecao, String nomePonte, String nomeInspetor, int via, int uf, String km, int superintendenciaRegional, String ul) {
        this.id = id;
        this.codigo = codigo;
        this.dataInspecao = dataInspecao;
        this.nomePonte = nomePonte;
        this.nomeInspetor = nomeInspetor;
        this.via = via;
        this.uf = uf;
        this.km = km;
        this.superintendenciaRegional = superintendenciaRegional;
        this.ul = ul;
    }

    public IdentificacaoObraSgo(String codigo, Date dataInspecao, String nomePonte, String nomeInspetor, int via, int uf, String km, int superintendenciaRegional, String ul) {
        this.codigo = codigo;
        this.dataInspecao = dataInspecao;
        this.nomePonte = nomePonte;
        this.nomeInspetor = nomeInspetor;
        this.via = via;
        this.uf = uf;
        this.km = km;
        this.superintendenciaRegional = superintendenciaRegional;
        this.ul = ul;
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

    public Date getDataInspecao() {
        return dataInspecao;
    }

    public void setDataInspecao(Date dataInspecao) {
        this.dataInspecao = dataInspecao;
    }

    public String getNomePonte() {
        return nomePonte;
    }

    public void setNomePonte(String nomePonte) {
        this.nomePonte = nomePonte;
    }

    public String getNomeInspetor() {
        return nomeInspetor;
    }

    public void setNomeInspetor(String nomeInspetor) {
        this.nomeInspetor = nomeInspetor;
    }

    public int getVia() {
        return via;
    }

    public void setVia(int via) {
        this.via = via;
    }

    public int getUf() {
        return uf;
    }

    public void setUf(int uf) {
        this.uf = uf;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public int getSuperintendenciaRegional() {
        return superintendenciaRegional;
    }

    public void setSuperintendenciaRegional(int superintendenciaRegional) {
        this.superintendenciaRegional = superintendenciaRegional;
    }

    public String getUl() {
        return ul;
    }

    public void setUl(String ul) {
        this.ul = ul;
    }
}
