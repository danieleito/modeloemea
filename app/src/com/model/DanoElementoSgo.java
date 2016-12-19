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
     * @param id {@link #id}
     * @param elemento {@link #elemento}
     * @param nota {@link #nota}
     * @param dano {@link #dano}
     * @param unidade {@link #unidade}
     * @param quantidade {@link #quantidade}
     * @param extensaoRelativa {@link #extensaoRelativa}
     * @param localizacao {@link #localizacao}
     */
    public DanoElementoSgo(int id, String elemento, String nota, String dano, String unidade, String quantidade, String extensaoRelativa, String localizacao) {
        this.id = id;
        this.elemento = elemento;
        this.nota = nota;
        this.dano = dano;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.extensaoRelativa = extensaoRelativa;
        this.localizacao = localizacao;
    }

    /**
     * Constructor sem id
     * @param elemento {@link #elemento}
     * @param nota {@link #nota}
     * @param dano {@link #dano}
     * @param unidade {@link #unidade}
     * @param quantidade {@link #quantidade}
     * @param extensaoRelativa {@link #extensaoRelativa}
     * @param localizacao {@link #localizacao}
     */
    public DanoElementoSgo(String elemento, String nota, String dano, String unidade, String quantidade, String extensaoRelativa, String localizacao) {
        this.elemento = elemento;
        this.nota = nota;
        this.dano = dano;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.extensaoRelativa = extensaoRelativa;
        this.localizacao = localizacao;
    }


    /**
     * retorna {@link #id}
     * @return {@link #id}
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * retorna {@link #elemento}
     * @return {@link #elemento}
     */
    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    /**
     * retorna {@link #nota}
     * @return {@link #nota}
     */
    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    /**
     * retorna {@link #dano}
     * @return {@link #dano}
     */
    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
    }

    /**
     * retorna {@link #unidade}
     * @return {@link #unidade}
     */
    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * retorna {@link #quantidade}
     * @return {@link #quantidade}
     */
    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * retorna {@link #extensaoRelativa}
     * @return {@link #extensaoRelativa}
     */
    public String getExtensaoRelativa() {
        return extensaoRelativa;
    }

    public void setExtensaoRelativa(String extensaoRelativa) {
        this.extensaoRelativa = extensaoRelativa;
    }

    /**
     * retorna {@link #localizacao}
     * @return {@link #localizacao}
     */
    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
