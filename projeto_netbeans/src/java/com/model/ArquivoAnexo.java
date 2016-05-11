/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.Date;

/**
 *
 * @author Daniele Harumi Ito
 */
public class ArquivoAnexo {
    private int id;
    private String arquivo;
    private String tipoArquivo;
    private String numero;
    private String descricao;
    private String registro;
    private Date dataAnexada;

    public ArquivoAnexo() {
    }

    public ArquivoAnexo(int id, String arquivo, String tipoArquivo, String numero, String descricao, String registro, Date dataAnexada) {
        this.id = id;
        this.arquivo = arquivo;
        this.tipoArquivo = tipoArquivo;
        this.numero = numero;
        this.descricao = descricao;
        this.registro = registro;
        this.dataAnexada = dataAnexada;
    }

    public ArquivoAnexo(String arquivo, String tipoArquivo, String numero, String descricao, String registro, Date dataAnexada) {
        this.arquivo = arquivo;
        this.tipoArquivo = tipoArquivo;
        this.numero = numero;
        this.descricao = descricao;
        this.registro = registro;
        this.dataAnexada = dataAnexada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(String tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Date getDataAnexada() {
        return dataAnexada;
    }

    public void setDataAnexada(Date dataAnexada) {
        this.dataAnexada = dataAnexada;
    }
}