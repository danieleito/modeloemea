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
public class Imagem implements Serializable {
    /**
     * identificador do Imagem no Banco de Dados
     */
    private int id;
    /**
     * nome da imagem
     */
    private String nome;
    /**
     * 
     */
    private String tipoMime;
    /**
     * 
     */
    //private byte[] imagem;
    /**
     * 
     */
    //private String caminho;

    /**
     * Constructor padrão.
     */
    public Imagem() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param nome {@link #nome}
     * @param tipoMime {@link #tipoMime}
     * @param caminho {@link #caminho}
     */
    public Imagem(int id, String nome, String tipoMime) {
        this.id = id;
        this.nome = nome;
        this.tipoMime = tipoMime;
        //this.imagem = imagem;
    }

    /**
     * Constructor sem id
     * @param nome {@link #nome}
     * @param tipoMime {@link #tipoMime}
     * @param caminho {@link #caminho}
     */
    public Imagem(String nome, String tipoMime) {
        this.nome = nome;
        this.tipoMime = tipoMime;
        //this.imagem = imagem;
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
     * retorna {@link #nome}
     * @return {@link #nome}
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * retorna {@link #tipoMime}
     * @return {@link #tipoMime}
     */
    public String getTipoMime() {
        return tipoMime;
    }

    public void setTipoMime(String tipoMime) {
        this.tipoMime = tipoMime;
    }

//    public byte[] getImagem() {
//        return imagem;
//    }
//
//    public void setImagem(byte[] imagem) {
//        this.imagem = imagem;
//    }

}