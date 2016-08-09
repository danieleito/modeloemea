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
public class ArquivoAnexo implements Serializable {
    /**
     * identificador do ArquivoAnexo no Banco de Dados
     */
    private int id;
    /**
     * identificador da ponte
     */
    private Ponte ponte;
    /**
     * arquivo
     */
    private String arquivo;
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
     * Constructor padrão.
     */
    public ArquivoAnexo() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param ponte {@link #ponte}
     * @param arquivo {@link #arquivo}
     * @param tipoArquivo {@link #tipoArquivo}
     * @param numero {@link #numero}
     * @param descricao {@link #descricao}
     * @param registro {@link #registro}
     * @param dataAnexada {@link #dataAnexada}
     * @param imagem {@link #imagem}
     */
    public ArquivoAnexo(int id, Ponte ponte, String arquivo, String tipoArquivo, String numero, String descricao, String registro, Date dataAnexada, Imagem imagem) {
        this.id = id;
        this.ponte = ponte;
        this.arquivo = arquivo;
        this.tipoArquivo = tipoArquivo;
        this.numero = numero;
        this.descricao = descricao;
        this.registro = registro;
        this.dataAnexada = dataAnexada;
        this.imagem = imagem;
    }

    /**
     * Constructor sem id
     * @param ponte {@link #ponte}
     * @param arquivo {@link #arquivo}
     * @param tipoArquivo {@link #tipoArquivo}
     * @param numero {@link #numero}
     * @param descricao {@link #descricao}
     * @param registro {@link #registro}
     * @param dataAnexada {@link #dataAnexada}
     * @param imagem {@link #imagem}
     */
    public ArquivoAnexo(Ponte ponte, String arquivo, String tipoArquivo, String numero, String descricao, String registro, Date dataAnexada, Imagem imagem) {
        this.ponte = ponte;
        this.arquivo = arquivo;
        this.tipoArquivo = tipoArquivo;
        this.numero = numero;
        this.descricao = descricao;
        this.registro = registro;
        this.dataAnexada = dataAnexada;
        this.imagem = imagem;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ponte getPonte() {
        return ponte;
    }

    public void setPonte(Ponte ponte) {
        this.ponte = ponte;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(String tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Date getDataAnexada() {
        return dataAnexada;
    }

    public void setDataAnexada(Date dataAnexada) {
        this.dataAnexada = dataAnexada;
    }

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
