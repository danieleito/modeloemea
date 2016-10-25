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
public class DadosManifestacao implements Serializable {
    private int id;
    private String foto;
    private String tamanho;
    private String numero;
    private ManifestacaoExtensao manifestacaoExtensao;
    private ManifestacaoUrgencia manifestacaoUrgencia;
    private ArquivoAnexoManifestacao arquivoAnexoManifestacao;

    public DadosManifestacao() {
    }

    public DadosManifestacao(int id, String foto, String tamanho, String numero, ManifestacaoExtensao manifestacaoExtensao, ManifestacaoUrgencia manifestacaoUrgencia, ArquivoAnexoManifestacao arquivoAnexoManifestacao) {
        this.id = id;
        this.foto = foto;
        this.tamanho = tamanho;
        this.numero = numero;
        this.manifestacaoExtensao = manifestacaoExtensao;
        this.manifestacaoUrgencia = manifestacaoUrgencia;
        this.arquivoAnexoManifestacao = arquivoAnexoManifestacao;
    }

    public DadosManifestacao(String foto, String tamanho, String numero, ManifestacaoExtensao manifestacaoExtensao, ManifestacaoUrgencia manifestacaoUrgencia, ArquivoAnexoManifestacao arquivoAnexoManifestacao) {
        this.foto = foto;
        this.tamanho = tamanho;
        this.numero = numero;
        this.manifestacaoExtensao = manifestacaoExtensao;
        this.manifestacaoUrgencia = manifestacaoUrgencia;
        this.arquivoAnexoManifestacao = arquivoAnexoManifestacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ManifestacaoExtensao getManifestacaoExtensao() {
        return manifestacaoExtensao;
    }

    public void setManifestacaoExtensao(ManifestacaoExtensao manifestacaoExtensao) {
        this.manifestacaoExtensao = manifestacaoExtensao;
    }

    public ManifestacaoUrgencia getManifestacaoUrgencia() {
        return manifestacaoUrgencia;
    }

    public void setManifestacaoUrgencia(ManifestacaoUrgencia manifestacaoUrgencia) {
        this.manifestacaoUrgencia = manifestacaoUrgencia;
    }

    public ArquivoAnexoManifestacao getArquivoAnexoManifestacao() {
        return arquivoAnexoManifestacao;
    }

    public void setArquivoAnexoManifestacao(ArquivoAnexoManifestacao arquivoAnexoManifestacao) {
        this.arquivoAnexoManifestacao = arquivoAnexoManifestacao;
    }
}
