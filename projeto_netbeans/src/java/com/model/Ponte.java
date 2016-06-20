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
public class Ponte {
    private int id;
    private String indicePerformanceRelativo;
    private IdentificacaoObraDadosBasicos identificacaoObraDadosBasicos;
    private IdentificacaoObraLocalizacao identificacaoObraLocalizacao;
    private IdentificacaoObraResponsaveis identificacaoObraResponsaveis;
    private IdentificacaoObraInspecao identificacaoObraInspecao;
    
    //para exibir na tela que lista o ranking
    private Date dataUltimaInspecao;

    public Ponte() {
        identificacaoObraDadosBasicos = new IdentificacaoObraDadosBasicos();
        identificacaoObraInspecao = new IdentificacaoObraInspecao();
        identificacaoObraLocalizacao = new IdentificacaoObraLocalizacao();
        identificacaoObraResponsaveis = new IdentificacaoObraResponsaveis();
    }

    public Ponte(int id, IdentificacaoObraDadosBasicos idIdentificacaoObraDadosBasicos, 
            IdentificacaoObraLocalizacao idIdentificacaoObraLocalizacao, 
            IdentificacaoObraResponsaveis idIdentificacaoObraResponsaveis, 
            IdentificacaoObraInspecao idIdentificacaoObraInspecao,
            String indicePerformanceRelativo) {
        this.id = id;
        this.indicePerformanceRelativo = indicePerformanceRelativo;
        this.identificacaoObraDadosBasicos = idIdentificacaoObraDadosBasicos;
        this.identificacaoObraLocalizacao = idIdentificacaoObraLocalizacao;
        this.identificacaoObraResponsaveis = idIdentificacaoObraResponsaveis;
        this.identificacaoObraInspecao = idIdentificacaoObraInspecao;
    }

    public Ponte(IdentificacaoObraDadosBasicos idIdentificacaoObraDadosBasicos, 
            IdentificacaoObraLocalizacao idIdentificacaoObraLocalizacao, 
            IdentificacaoObraResponsaveis idIdentificacaoObraResponsaveis, 
            IdentificacaoObraInspecao idIdentificacaoObraInspecao,
            String indicePerformanceRelativo) {
        this.indicePerformanceRelativo = indicePerformanceRelativo;
        this.identificacaoObraDadosBasicos = idIdentificacaoObraDadosBasicos;
        this.identificacaoObraLocalizacao = idIdentificacaoObraLocalizacao;
        this.identificacaoObraResponsaveis = idIdentificacaoObraResponsaveis;
        this.identificacaoObraInspecao = idIdentificacaoObraInspecao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IdentificacaoObraDadosBasicos getIdentificacaoObraDadosBasicos() {
        return identificacaoObraDadosBasicos;
    }

    public void setIdentificacaoObraDadosBasicos(IdentificacaoObraDadosBasicos identificacaoObraDadosBasicos) {
        this.identificacaoObraDadosBasicos = identificacaoObraDadosBasicos;
    }

    public IdentificacaoObraLocalizacao getIdentificacaoObraLocalizacao() {
        return identificacaoObraLocalizacao;
    }

    public void setIdentificacaoObraLocalizacao(IdentificacaoObraLocalizacao identificacaoObraLocalizacao) {
        this.identificacaoObraLocalizacao = identificacaoObraLocalizacao;
    }

    public IdentificacaoObraResponsaveis getIdentificacaoObraResponsaveis() {
        return identificacaoObraResponsaveis;
    }

    public void setIdentificacaoObraResponsaveis(IdentificacaoObraResponsaveis identificacaoObraResponsaveis) {
        this.identificacaoObraResponsaveis = identificacaoObraResponsaveis;
    }

    public IdentificacaoObraInspecao getIdentificacaoObraInspecao() {
        return identificacaoObraInspecao;
    }

    public void setIdentificacaoObraInspecao(IdentificacaoObraInspecao identificacaoObraInspecao) {
        this.identificacaoObraInspecao = identificacaoObraInspecao;
    }

    public Date getDataUltimaInspecao() {
        return dataUltimaInspecao;
    }

    public void setDataUltimaInspecao(Date dataUltimaInspecao) {
        this.dataUltimaInspecao = dataUltimaInspecao;
    }

    public String getIndicePerformanceRelativo() {
        return indicePerformanceRelativo;
    }

    public void setIndicePerformanceRelativo(String indicePerformanceRelativo) {
        this.indicePerformanceRelativo = indicePerformanceRelativo;
    }
}
