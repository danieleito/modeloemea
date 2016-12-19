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
    private String tamanho;
    private String numero;
    private ManifestacaoExtensao manifestacaoExtensao;
    private ManifestacaoUrgencia manifestacaoUrgencia;
    private ArquivoAnexoInspecao arquivoAnexoInspecao;
    private double valorDano;

    public DadosManifestacao() {
    }

    public DadosManifestacao(int id, String tamanho, String numero, ManifestacaoExtensao manifestacaoExtensao, ManifestacaoUrgencia manifestacaoUrgencia, ArquivoAnexoInspecao arquivoAnexoInspecao, double valorDano) {
        this.id = id;
        this.tamanho = tamanho;
        this.numero = numero;
        this.manifestacaoExtensao = manifestacaoExtensao;
        this.manifestacaoUrgencia = manifestacaoUrgencia;
        this.arquivoAnexoInspecao = arquivoAnexoInspecao;
        this.valorDano = valorDano;
    }

    public DadosManifestacao(String tamanho, String numero, ManifestacaoExtensao manifestacaoExtensao, ManifestacaoUrgencia manifestacaoUrgencia, ArquivoAnexoInspecao arquivoAnexoInspecao, double valorDano) {
        this.tamanho = tamanho;
        this.numero = numero;
        this.manifestacaoExtensao = manifestacaoExtensao;
        this.manifestacaoUrgencia = manifestacaoUrgencia;
        this.arquivoAnexoInspecao = arquivoAnexoInspecao;
        this.valorDano = valorDano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArquivoAnexoInspecao getArquivoAnexoInspecao() {
        return arquivoAnexoInspecao;
    }

    public void setArquivoAnexoInspecao(ArquivoAnexoInspecao arquivoAnexoInspecao) {
        this.arquivoAnexoInspecao = arquivoAnexoInspecao;
    }

    public double getValorDano() {
        return valorDano;
    }

    public void setValorDano(double valorDano) {
        this.valorDano = valorDano;
    }
}
