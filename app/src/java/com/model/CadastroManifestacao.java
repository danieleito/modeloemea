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
public class CadastroManifestacao implements Serializable {
    /**
     * identificador do CadastroManifestacao no Banco de Dados
     */
    private int id;
    /**
     * identificador do numero
     */
    private Numero numero;
    /**
     * identificador da manifestacao ufpr
     */
    private ManifestacaoUfpr manifestacaoUfpr;
    /**
     * identificador da foto
     */
    private Foto foto;
    /**
     * tamanho 
     */
    private String tamanho;
    /**
     * identificador da extensao relativa
     */
    private ExtensaoRelativa extensaoRelativa;
    /**
     * identificador do reparo
     */
    private Reparo reparo;

    /**
     * Constructor padrão.
     */
    public CadastroManifestacao() {
        numero = new Numero();
        manifestacaoUfpr = new ManifestacaoUfpr();
        foto = new Foto();
        extensaoRelativa = new ExtensaoRelativa();
        reparo = new Reparo();
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param numero {@link #numero}
     * @param manifestacaoUfpr {@link #manifestacaoUfpr}
     * @param foto {@link #foto}
     * @param tamanho {@link #tamanho}
     * @param extensaoRelativa {@link #extensaoRelativa}
     * @param reparo {@link #reparo}
     */
    public CadastroManifestacao(int id, Numero numero, ManifestacaoUfpr manifestacaoUfpr, Foto foto, String tamanho, ExtensaoRelativa extensaoRelativa, Reparo reparo) {
        this.id = id;
        this.numero = numero;
        this.manifestacaoUfpr = manifestacaoUfpr;
        this.foto = foto;
        this.tamanho = tamanho;
        this.extensaoRelativa = extensaoRelativa;
        this.reparo = reparo;
    }

    /**
     * Constructor sem id
     * @param numero {@link #numero}
     * @param manifestacaoUfpr {@link #manifestacaoUfpr}
     * @param foto {@link #foto}
     * @param tamanho {@link #tamanho}
     * @param extensaoRelativa {@link #extensaoRelativa}
     * @param reparo {@link #reparo}
     */
    public CadastroManifestacao(Numero numero, ManifestacaoUfpr manifestacaoUfpr, Foto foto, String tamanho, ExtensaoRelativa extensaoRelativa, Reparo reparo) {
        this.numero = numero;
        this.manifestacaoUfpr = manifestacaoUfpr;
        this.foto = foto;
        this.tamanho = tamanho;
        this.extensaoRelativa = extensaoRelativa;
        this.reparo = reparo;
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
     * retorna {@link #numero}
     * @return {@link #numero}
     */
    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }

    /**
     * retorna {@link #manifestacaoUfpr}
     * @return {@link #manifestacaoUfpr}
     */
    public ManifestacaoUfpr getManifestacaoUfpr() {
        return manifestacaoUfpr;
    }

    public void setManifestacao(ManifestacaoUfpr manifestacaoUfpr) {
        this.manifestacaoUfpr = manifestacaoUfpr;
    }

    /**
     * retorna {@link #foto}
     * @return {@link #foto}
     */
    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    /**
     * retorna {@link #tamanho}
     * @return {@link #tamanho}
     */
    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * retorna {@link #extensaoRelativa}
     * @return {@link #extensaoRelativa}
     */
    public ExtensaoRelativa getExtensaoRelativa() {
        return extensaoRelativa;
    }

    public void setExtensaoRelativa(ExtensaoRelativa extensaoRelativa) {
        this.extensaoRelativa = extensaoRelativa;
    }

    /**
     * retorna {@link #reparo}
     * @return {@link #reparo}
     */
    public Reparo getReparo() {
        return reparo;
    }

    public void setReparo(Reparo reparo) {
        this.reparo = reparo;
    }
}
