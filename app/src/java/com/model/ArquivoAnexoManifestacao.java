/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Daniele Harumi Ito
 */
public class ArquivoAnexoManifestacao implements Serializable {
    /**
     * identificador do ArquivoAnexoCadastro no Banco de Dados
     */
    private int id;
    /**
     * tipo de arquivo
     */
    private String tipoArquivo;
    /**
     * numero
     */
    private String numero;
    /**
     * descricao
     */
    private String descricao;
    /**
     * registro
     */
    private String registro;
    /**
     * identificador da data
     */
    private Date dataAnexada;
    /**
     * identificador da imagem
     */
    private Imagem imagem;

    /**
     * Constructor padrão
     */
    public ArquivoAnexoManifestacao() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param tipoArquivo {@link #tipoArquivo}
     * @param numero {@link #numero}
     * @param descricao {@link #descricao}
     * @param registro {@link #registro}
     * @param dataAnexada {@link #dataAnexada}
     * @param imagem {@link #imagem}
     */
    public ArquivoAnexoManifestacao(int id, String tipoArquivo, String numero, String descricao, String registro, Date dataAnexada, Imagem imagem) {
        this.id = id;
        this.tipoArquivo = tipoArquivo;
        this.numero = numero;
        this.descricao = descricao;
        this.registro = registro;
        this.dataAnexada = dataAnexada;
        this.imagem = imagem;
    }

    /**
     * Constructor sem id
     * @param tipoArquivo {@link #tipoArquivo}
     * @param numero {@link #numero}
     * @param descricao {@link #descricao}
     * @param registro {@link #registro}
     * @param dataAnexada {@link #dataAnexada}
     * @param imagem {@link #imagem}
     */
    public ArquivoAnexoManifestacao(String tipoArquivo, String numero, String descricao, String registro, Date dataAnexada, Imagem imagem) {
        this.tipoArquivo = tipoArquivo;
        this.numero = numero;
        this.descricao = descricao;
        this.registro = registro;
        this.dataAnexada = dataAnexada;
        this.imagem = imagem;
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
     * retorna {@link #tipoArquivo}
     * @return {@link #tipoArquivo}
     */
    public String getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(String tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    /**
     * retorna {@link #numero}
     * @return {@link #numero}
     */
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * retorna {@link #descricao}
     * @return {@link #descricao}
     */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * retorna {@link #registro}
     * @return {@link #registro}
     */
    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    /**
     * retorna {@link #dataAnexada}
     * @return {@link #dataAnexada}
     */
    public Date getDataAnexada() {
        return dataAnexada;
    }

    public void setDataAnexada(Date dataAnexada) {
        this.dataAnexada = dataAnexada;
    }

    /**
     * retorna {@link #imagem}
     * @return {@link #imagem}
     */
    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
