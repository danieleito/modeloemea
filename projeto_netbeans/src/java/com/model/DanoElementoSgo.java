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
public class DanoElementoSgo implements Serializable {
    /**
     * identificador do DanoElementoSgo no Banco de Dados
     */
    private int id;
    /**
     * identificador da inspeção rotineira
     */
    private InspecaoRotineira inspecaoRotineira;
    /**
     * 
     */
    private String elemento;
    /**
     * 
     */
    private String nota;
    /**
     * 
     */
    private String dano;
    /**
     * 
     */
    private String unidade;
    /**
     * 
     */
    private String quantidade;
    /**
     * 
     */
    private String extensaoRelativa;
    /**
     * 
     */
    private String localizacao;


    /**
     * Constructor padrão.
     */
    public DanoElementoSgo() {
    }

    /**
     * Constructor completo
     * @param id
     * @param inspecaoRotineira
     * @param elemento
     * @param nota
     * @param dano
     * @param unidade
     * @param quantidade
     * @param extensaoRelativa
     * @param localizacao 
     */
    public DanoElementoSgo(int id, InspecaoRotineira inspecaoRotineira, String elemento, String nota, String dano, String unidade, String quantidade, String extensaoRelativa, String localizacao) {
        this.id = id;
        this.inspecaoRotineira = inspecaoRotineira;
        this.elemento = elemento;
        this.nota = nota;
        this.dano = dano;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.extensaoRelativa = extensaoRelativa;
        this.localizacao = localizacao;
    }

    public DanoElementoSgo(InspecaoRotineira inspecaoRotineira, String elemento, String nota, String dano, String unidade, String quantidade, String extensaoRelativa, String localizacao) {
        this.inspecaoRotineira = inspecaoRotineira;
        this.elemento = elemento;
        this.nota = nota;
        this.dano = dano;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.extensaoRelativa = extensaoRelativa;
        this.localizacao = localizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InspecaoRotineira getInspecaoRotineira() {
        return inspecaoRotineira;
    }

    public void setInspecaoRotineira(InspecaoRotineira inspecaoRotineira) {
        this.inspecaoRotineira = inspecaoRotineira;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getExtensaoRelativa() {
        return extensaoRelativa;
    }

    public void setExtensaoRelativa(String extensaoRelativa) {
        this.extensaoRelativa = extensaoRelativa;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
