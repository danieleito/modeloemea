/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Daniele Harumi Ito
 */
public class cadastroManifestacao {
    private int id;
    private ElementoUfpr elementoUfpr;
    private Numero numero;
    private ManifestacaoUfpr manifestacao;
    private Foto foto;
    private String tamanho;
    private ExtensaoRelativa extensaoRelativa;
    private Reparo reparo;

    public cadastroManifestacao() {
    }

    public cadastroManifestacao(int id, ElementoUfpr elementoUfpr, Numero numero, ManifestacaoUfpr manifestacao, Foto foto, String tamanho, ExtensaoRelativa extensaoRelativa, Reparo reparo) {
        this.id = id;
        this.elementoUfpr = elementoUfpr;
        this.numero = numero;
        this.manifestacao = manifestacao;
        this.foto = foto;
        this.tamanho = tamanho;
        this.extensaoRelativa = extensaoRelativa;
        this.reparo = reparo;
    }

    public cadastroManifestacao(ElementoUfpr elementoUfpr, Numero numero, ManifestacaoUfpr manifestacao, Foto foto, String tamanho, ExtensaoRelativa extensaoRelativa, Reparo reparo) {
        this.elementoUfpr = elementoUfpr;
        this.numero = numero;
        this.manifestacao = manifestacao;
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

    public ElementoUfpr getElementoUfpr() {
        return elementoUfpr;
    }

    public void setElementoUfpr(ElementoUfpr elementoUfpr) {
        this.elementoUfpr = elementoUfpr;
    }

    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }

    public ManifestacaoUfpr getManifestacao() {
        return manifestacao;
    }

    public void setManifestacao(ManifestacaoUfpr manifestacao) {
        this.manifestacao = manifestacao;
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
