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
    private byte[] imagem;
    
    private String caminho;


    /**
     * Constructor padrão.
     */
    public Imagem() {
    }

    /**
     * Constructor completo
     * @param id
     * @param nome
     * @param tipoMime
     * @param imagem 
     * @param caminho 
     */
    public Imagem(int id, String nome, String tipoMime, byte[] imagem, String caminho) {
        this.id = id;
        this.nome = nome;
        this.tipoMime = tipoMime;
        this.imagem = imagem;
        this.caminho = caminho;
    }

    public Imagem(String nome, String tipoMime, byte[] imagem, String caminho) {
        this.nome = nome;
        this.tipoMime = tipoMime;
        this.imagem = imagem;
        this.caminho = caminho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoMime() {
        return tipoMime;
    }

    public void setTipoMime(String tipoMime) {
        this.tipoMime = tipoMime;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
}