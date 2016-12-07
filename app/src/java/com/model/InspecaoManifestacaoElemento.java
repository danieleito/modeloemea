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
public class InspecaoManifestacaoElemento implements Serializable {
    private int id;
    private int idInspecao;
    private DadosManifestacao dadosManifestacao;
    private ElementoUfprManifestacaoUfpr elementoUfprManifestacaoUfpr;
    
    //campos utilizados apenas para exibir dados na view
    private double capa3;
    private double valorDano;
    //utilizado para saber se elemento entrou na soma, para que ele seja colorido na aba Modelo EMEA
    private boolean somou;

    public InspecaoManifestacaoElemento() {
        somou = false;
    }

    public InspecaoManifestacaoElemento(int id, int idInspecao, DadosManifestacao dadosManifestacao, ElementoUfprManifestacaoUfpr elementoUfprManifestacaoUfpr) {
        this.id = id;
        this.idInspecao = idInspecao;
        this.dadosManifestacao = dadosManifestacao;
        this.elementoUfprManifestacaoUfpr = elementoUfprManifestacaoUfpr;
        somou = false;
    }

    public InspecaoManifestacaoElemento(int idInspecao, DadosManifestacao dadosManifestacao, ElementoUfprManifestacaoUfpr elementoUfprManifestacaoUfpr) {
        this.idInspecao = idInspecao;
        this.dadosManifestacao = dadosManifestacao;
        this.elementoUfprManifestacaoUfpr = elementoUfprManifestacaoUfpr;
        somou = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInspecao() {
        return idInspecao;
    }

    public void setIdInspecao(int idInspecao) {
        this.idInspecao = idInspecao;
    }

    public DadosManifestacao getDadosManifestacao() {
        return dadosManifestacao;
    }

    public void setDadosManifestacao(DadosManifestacao dadosManifestacao) {
        this.dadosManifestacao = dadosManifestacao;
    }

    public ElementoUfprManifestacaoUfpr getElementoUfprManifestacaoUfpr() {
        return elementoUfprManifestacaoUfpr;
    }

    public void setElementoUfprManifestacaoUfpr(ElementoUfprManifestacaoUfpr elementoUfprManifestacaoUfpr) {
        this.elementoUfprManifestacaoUfpr = elementoUfprManifestacaoUfpr;
    }

    public double getCapa3() {
        return capa3;
    }

    public void setCapa3(double capa3) {
        this.capa3 = capa3;
    }

    public double getValorDano() {
        return valorDano;
    }

    public void setValorDano(double valorDano) {
        this.valorDano = valorDano;
    }

    public boolean isSomou() {
        return somou;
    }

    public void setSomou(boolean somou) {
        this.somou = somou;
    }
}
