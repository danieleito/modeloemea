/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.awt.Image;
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
    private String nome;
    private String tipoMime;
    private byte[] imagem;

    public Imagem() {
    }

    public Imagem(int id, String nome, String tipoMime, byte[] imagem) {
        this.id = id;
        this.nome = nome;
        this.tipoMime = tipoMime;
        this.imagem = imagem;
    }

    public Imagem(String nome, String tipoMime, byte[] imagem) {
        this.nome = nome;
        this.tipoMime = tipoMime;
        this.imagem = imagem;
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
}