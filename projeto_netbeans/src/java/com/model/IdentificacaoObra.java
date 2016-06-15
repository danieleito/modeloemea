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
public class IdentificacaoObra {
    private int id;
    private IdentificacaoObraDadosBasicos idIdentificacaoObraDadosBasicos;
    private IdentificacaoObraLocalizacao idIdentificacaoObraLocalizacao;
    private IdentificacaoObraResponsaveis idIdentificacaoObraResponsaveis;
    private IdentificacaoObraInspecao idIdentificacaoObraInspecao;

    public IdentificacaoObra() {
    }

    public IdentificacaoObra(int id, IdentificacaoObraDadosBasicos idIdentificacaoObraDadosBasicos, 
            IdentificacaoObraLocalizacao idIdentificacaoObraLocalizacao, 
            IdentificacaoObraResponsaveis idIdentificacaoObraResponsaveis, 
            IdentificacaoObraInspecao idIdentificacaoObraInspecao) {
        this.id = id;
        this.idIdentificacaoObraDadosBasicos = idIdentificacaoObraDadosBasicos;
        this.idIdentificacaoObraLocalizacao = idIdentificacaoObraLocalizacao;
        this.idIdentificacaoObraResponsaveis = idIdentificacaoObraResponsaveis;
        this.idIdentificacaoObraInspecao = idIdentificacaoObraInspecao;
    }

    public IdentificacaoObra(IdentificacaoObraDadosBasicos idIdentificacaoObraDadosBasicos, 
            IdentificacaoObraLocalizacao idIdentificacaoObraLocalizacao, 
            IdentificacaoObraResponsaveis idIdentificacaoObraResponsaveis, 
            IdentificacaoObraInspecao idIdentificacaoObraInspecao) {
        this.idIdentificacaoObraDadosBasicos = idIdentificacaoObraDadosBasicos;
        this.idIdentificacaoObraLocalizacao = idIdentificacaoObraLocalizacao;
        this.idIdentificacaoObraResponsaveis = idIdentificacaoObraResponsaveis;
        this.idIdentificacaoObraInspecao = idIdentificacaoObraInspecao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IdentificacaoObraDadosBasicos getIdIdentificacaoObraDadosBasicos() {
        return idIdentificacaoObraDadosBasicos;
    }

    public void setIdIdentificacaoObraDadosBasicos(IdentificacaoObraDadosBasicos idIdentificacaoObraDadosBasicos) {
        this.idIdentificacaoObraDadosBasicos = idIdentificacaoObraDadosBasicos;
    }

    public IdentificacaoObraLocalizacao getIdIdentificacaoObraLocalizacao() {
        return idIdentificacaoObraLocalizacao;
    }

    public void setIdIdentificacaoObraLocalizacao(IdentificacaoObraLocalizacao idIdentificacaoObraLocalizacao) {
        this.idIdentificacaoObraLocalizacao = idIdentificacaoObraLocalizacao;
    }

    public IdentificacaoObraResponsaveis getIdIdentificacaoObraResponsaveis() {
        return idIdentificacaoObraResponsaveis;
    }

    public void setIdIdentificacaoObraResponsaveis(IdentificacaoObraResponsaveis idIdentificacaoObraResponsaveis) {
        this.idIdentificacaoObraResponsaveis = idIdentificacaoObraResponsaveis;
    }

    public IdentificacaoObraInspecao getIdIdentificacaoObraInspecao() {
        return idIdentificacaoObraInspecao;
    }

    public void setIdIdentificacaoObraInspecao(IdentificacaoObraInspecao idIdentificacaoObraInspecao) {
        this.idIdentificacaoObraInspecao = idIdentificacaoObraInspecao;
    }
}
