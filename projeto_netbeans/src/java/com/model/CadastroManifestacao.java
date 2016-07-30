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
    private int id;
    private Numero numero;
    private ManifestacaoUfpr manifestacaoUfpr;
    private Foto foto;
    private String tamanho;
    private ExtensaoRelativa extensaoRelativa;
    private Reparo reparo;

    public CadastroManifestacao() {
        numero = new Numero();
        manifestacaoUfpr = new ManifestacaoUfpr();
        foto = new Foto();
        extensaoRelativa = new ExtensaoRelativa();
        reparo = new Reparo();
    }

    public CadastroManifestacao(int id, Numero numero, ManifestacaoUfpr manifestacaoUfpr, Foto foto, String tamanho, ExtensaoRelativa extensaoRelativa, Reparo reparo) {
        this.id = id;
        this.numero = numero;
        this.manifestacaoUfpr = manifestacaoUfpr;
        this.foto = foto;
        this.tamanho = tamanho;
        this.extensaoRelativa = extensaoRelativa;
        this.reparo = reparo;
    }

    public CadastroManifestacao(Numero numero, ManifestacaoUfpr manifestacaoUfpr, Foto foto, String tamanho, ExtensaoRelativa extensaoRelativa, Reparo reparo) {
        this.numero = numero;
        this.manifestacaoUfpr = manifestacaoUfpr;
        this.foto = foto;
        this.tamanho = tamanho;
        this.extensaoRelativa = extensaoRelativa;
        this.reparo = reparo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }

    public ManifestacaoUfpr getManifestacaoUfpr() {
        return manifestacaoUfpr;
    }

    public void setManifestacao(ManifestacaoUfpr manifestacaoUfpr) {
        this.manifestacaoUfpr = manifestacaoUfpr;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public ExtensaoRelativa getExtensaoRelativa() {
        return extensaoRelativa;
    }

    public void setExtensaoRelativa(ExtensaoRelativa extensaoRelativa) {
        this.extensaoRelativa = extensaoRelativa;
    }

    public Reparo getReparo() {
        return reparo;
    }

    public void setReparo(Reparo reparo) {
        this.reparo = reparo;
    }
}
