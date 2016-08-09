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
public class CaracteristicasFuncionaisDimensoes implements Serializable {
    /**
     * identificador do CaracteristicasFuncionaisDimensoes no Banco de Dados
     */
    private int id;
    /**
     * numero de faixas
     */
    private String numeroFaixas;
    /**
     * largura da faixa
     */
    private String larguraFaixa;
    /**
     * acostamento direito
     */
    private String acostamentoDireito;
    /**
     * acostamento Esquerdo
     */
    private String acostamentoEsquerdo;
    /**
     * calçada Direita
     */
    private String calcadaDireita;
    /**
     * calçada Esquerda
     */
    private String calcadaEsquerda;
    /**
     * largura Total da Pista
     */
    private String larguraTotalPista;
    /**
     * gabarito Horizontal
     */
    private String gabaritoHorizontal;
    /**
     * gabarito Vertical
     */
    private String gabaritoVertical;
    /**
     * numero Vãos
     */
    private String numeroVaos;
    /**
     * descrição dos Vãos
     */
    private String descricaoVaos;

    /**
     * Constructor padrão.
     */
    public CaracteristicasFuncionaisDimensoes() {
    }

    public CaracteristicasFuncionaisDimensoes(int id, String numeroFaixas, String larguraFaixa, String acostamentoDireito, String acostamentoEsquerdo, String calcadaDireita, String calcadaEsquerda, String larguraTotalPista, String gabaritoHorizontal, String gabaritoVertical, String numeroVaos, String descricaoVaos) {
        this.id = id;
        this.numeroFaixas = numeroFaixas;
        this.larguraFaixa = larguraFaixa;
        this.acostamentoDireito = acostamentoDireito;
        this.acostamentoEsquerdo = acostamentoEsquerdo;
        this.calcadaDireita = calcadaDireita;
        this.calcadaEsquerda = calcadaEsquerda;
        this.larguraTotalPista = larguraTotalPista;
        this.gabaritoHorizontal = gabaritoHorizontal;
        this.gabaritoVertical = gabaritoVertical;
        this.numeroVaos = numeroVaos;
        this.descricaoVaos = descricaoVaos;
    }

    public CaracteristicasFuncionaisDimensoes(String numeroFaixas, String larguraFaixa, String acostamentoDireito, String acostamentoEsquerdo, String calcadaDireita, String calcadaEsquerda, String larguraTotalPista, String gabaritoHorizontal, String gabaritoVertical, String numeroVaos, String descricaoVaos) {
        this.numeroFaixas = numeroFaixas;
        this.larguraFaixa = larguraFaixa;
        this.acostamentoDireito = acostamentoDireito;
        this.acostamentoEsquerdo = acostamentoEsquerdo;
        this.calcadaDireita = calcadaDireita;
        this.calcadaEsquerda = calcadaEsquerda;
        this.larguraTotalPista = larguraTotalPista;
        this.gabaritoHorizontal = gabaritoHorizontal;
        this.gabaritoVertical = gabaritoVertical;
        this.numeroVaos = numeroVaos;
        this.descricaoVaos = descricaoVaos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroFaixas() {
        return numeroFaixas;
    }

    public void setNumeroFaixas(String numeroFaixas) {
        this.numeroFaixas = numeroFaixas;
    }

    public String getLarguraFaixa() {
        return larguraFaixa;
    }

    public void setLarguraFaixa(String larguraFaixa) {
        this.larguraFaixa = larguraFaixa;
    }

    public String getAcostamentoDireito() {
        return acostamentoDireito;
    }

    public void setAcostamentoDireito(String acostamentoDireito) {
        this.acostamentoDireito = acostamentoDireito;
    }

    public String getAcostamentoEsquerdo() {
        return acostamentoEsquerdo;
    }

    public void setAcostamentoEsquerdo(String acostamentoEsquerdo) {
        this.acostamentoEsquerdo = acostamentoEsquerdo;
    }

    public String getCalcadaDireita() {
        return calcadaDireita;
    }

    public void setCalcadaDireita(String calcadaDireita) {
        this.calcadaDireita = calcadaDireita;
    }

    public String getCalcadaEsquerda() {
        return calcadaEsquerda;
    }

    public void setCalcadaEsquerda(String calcadaEsquerda) {
        this.calcadaEsquerda = calcadaEsquerda;
    }

    public String getLarguraTotalPista() {
        return larguraTotalPista;
    }

    public void setLarguraTotalPista(String larguraTotalPista) {
        this.larguraTotalPista = larguraTotalPista;
    }

    public String getGabaritoHorizontal() {
        return gabaritoHorizontal;
    }

    public void setGabaritoHorizontal(String gabaritoHorizontal) {
        this.gabaritoHorizontal = gabaritoHorizontal;
    }

    public String getGabaritoVertical() {
        return gabaritoVertical;
    }

    public void setGabaritoVertical(String gabaritoVertical) {
        this.gabaritoVertical = gabaritoVertical;
    }

    public String getNumeroVaos() {
        return numeroVaos;
    }

    public void setNumeroVaos(String numeroVaos) {
        this.numeroVaos = numeroVaos;
    }

    public String getDescricaoVaos() {
        return descricaoVaos;
    }

    public void setDescricaoVaos(String descricaoVaos) {
        this.descricaoVaos = descricaoVaos;
    }
}
