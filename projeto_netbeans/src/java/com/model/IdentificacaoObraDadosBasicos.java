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
public class IdentificacaoObraDadosBasicos {
    private int id;
    private String codigo;
    private String codigoIntegracao;
    private String status;
    private String identificacao;
    private NaturezaTransposicao idNaturezaTransposicao;
    private TipoEstrutura idTipoEstrutura;
    private SistemaConstrutivo idSistemaConstrutivo;
    private String comprimento;
    private String largura;
    private TremTipo idTremTipo;
    private String anoConstrucao;

    public IdentificacaoObraDadosBasicos() {
    }

    public IdentificacaoObraDadosBasicos(int id, String codigo, String codigoIntegracao, String status, String identificacao, NaturezaTransposicao idNaturezaTransposicao, TipoEstrutura idTipoEstrutura, SistemaConstrutivo idSistemaConstrutivo, String comprimento, String largura, TremTipo idTremTipo, String anoConstrucao) {
        this.id = id;
        this.codigo = codigo;
        this.codigoIntegracao = codigoIntegracao;
        this.status = status;
        this.identificacao = identificacao;
        this.idNaturezaTransposicao = idNaturezaTransposicao;
        this.idTipoEstrutura = idTipoEstrutura;
        this.idSistemaConstrutivo = idSistemaConstrutivo;
        this.comprimento = comprimento;
        this.largura = largura;
        this.idTremTipo = idTremTipo;
        this.anoConstrucao = anoConstrucao;
    }

    public IdentificacaoObraDadosBasicos(String codigo, String codigoIntegracao, String status, String identificacao, NaturezaTransposicao idNaturezaTransposicao, TipoEstrutura idTipoEstrutura, SistemaConstrutivo idSistemaConstrutivo, String comprimento, String largura, TremTipo idTremTipo, String anoConstrucao) {
        this.codigo = codigo;
        this.codigoIntegracao = codigoIntegracao;
        this.status = status;
        this.identificacao = identificacao;
        this.idNaturezaTransposicao = idNaturezaTransposicao;
        this.idTipoEstrutura = idTipoEstrutura;
        this.idSistemaConstrutivo = idSistemaConstrutivo;
        this.comprimento = comprimento;
        this.largura = largura;
        this.idTremTipo = idTremTipo;
        this.anoConstrucao = anoConstrucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoIntegracao() {
        return codigoIntegracao;
    }

    public void setCodigoIntegracao(String codigoIntegracao) {
        this.codigoIntegracao = codigoIntegracao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public NaturezaTransposicao getIdNaturezaTransposicao() {
        return idNaturezaTransposicao;
    }

    public void setIdNaturezaTransposicao(NaturezaTransposicao idNaturezaTransposicao) {
        this.idNaturezaTransposicao = idNaturezaTransposicao;
    }

    public TipoEstrutura getIdTipoEstrutura() {
        return idTipoEstrutura;
    }

    public void setIdTipoEstrutura(TipoEstrutura idTipoEstrutura) {
        this.idTipoEstrutura = idTipoEstrutura;
    }

    public SistemaConstrutivo getIdSistemaConstrutivo() {
        return idSistemaConstrutivo;
    }

    public void setIdSistemaConstrutivo(SistemaConstrutivo idSistemaConstrutivo) {
        this.idSistemaConstrutivo = idSistemaConstrutivo;
    }

    public String getComprimento() {
        return comprimento;
    }

    public void setComprimento(String comprimento) {
        this.comprimento = comprimento;
    }

    public String getLargura() {
        return largura;
    }

    public void setLargura(String largura) {
        this.largura = largura;
    }

    public TremTipo getIdTremTipo() {
        return idTremTipo;
    }

    public void setIdTremTipo(TremTipo idTremTipo) {
        this.idTremTipo = idTremTipo;
    }

    public String getAnoConstrucao() {
        return anoConstrucao;
    }

    public void setAnoConstrucao(String anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }
}
