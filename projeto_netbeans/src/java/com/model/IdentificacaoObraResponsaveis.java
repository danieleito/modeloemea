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
public class IdentificacaoObraResponsaveis implements Serializable {
    /**
     * identificador do IdentificacaoObraResponsaveis no Banco de Dados
     */
    private int id;
    /**
     * identificador da unidade local
     */
    private UnidadeLocal unidadeLocal;
    /**
     * identifidor do tipo administração 
     */
    private TipoAdministracao tipoAdministracao;
    /**
     * administrador
     */
    private String administrador;
    /**
     * projetista origem
     */
    private String projetistaOrigem;
    /**
     * projetista
     */
    private String projetistaProjetista;
    /**
     * construtor origem
     */
    private String construtorOrigem;
    /**
     * construtor
     */
    private String construtorConstrutor;
    /**
     * localização do projeto
     */
    private String localizacaoProjeto;
    /**
     * localização documentos de construção
     */
    private String localizacaoDocumentosConstrucao;
    /**
     * localização de documentos diversos
     */
    private String localizacaoDocumentosDiversos;


    /**
     * Constructor padrão.
     */
    public IdentificacaoObraResponsaveis() {
    }

    /**
     * Constructor completo
     * @param id
     * @param unidadeLocal
     * @param tipoAdministracao
     * @param administrador
     * @param projetistaOrigem
     * @param projetistaProjetista
     * @param construtorOrigem
     * @param construtorConstrutor
     * @param localizacaoProjeto
     * @param localizacaoDocumentosConstrucao
     * @param localizacaoDocumentosDiversos 
     */
    public IdentificacaoObraResponsaveis(int id, UnidadeLocal unidadeLocal, TipoAdministracao tipoAdministracao, String administrador, String projetistaOrigem, String projetistaProjetista, String construtorOrigem, String construtorConstrutor, String localizacaoProjeto, String localizacaoDocumentosConstrucao, String localizacaoDocumentosDiversos) {
        this.id = id;
        this.unidadeLocal = unidadeLocal;
        this.tipoAdministracao = tipoAdministracao;
        this.administrador = administrador;
        this.projetistaOrigem = projetistaOrigem;
        this.projetistaProjetista = projetistaProjetista;
        this.construtorOrigem = construtorOrigem;
        this.construtorConstrutor = construtorConstrutor;
        this.localizacaoProjeto = localizacaoProjeto;
        this.localizacaoDocumentosConstrucao = localizacaoDocumentosConstrucao;
        this.localizacaoDocumentosDiversos = localizacaoDocumentosDiversos;
    }

    public IdentificacaoObraResponsaveis(UnidadeLocal unidadeLocal, TipoAdministracao tipoAdministracao, String administrador, String projetistaOrigem, String projetistaProjetista, String construtorOrigem, String construtorConstrutor, String localizacaoProjeto, String localizacaoDocumentosConstrucao, String localizacaoDocumentosDiversos) {
        this.unidadeLocal = unidadeLocal;
        this.tipoAdministracao = tipoAdministracao;
        this.administrador = administrador;
        this.projetistaOrigem = projetistaOrigem;
        this.projetistaProjetista = projetistaProjetista;
        this.construtorOrigem = construtorOrigem;
        this.construtorConstrutor = construtorConstrutor;
        this.localizacaoProjeto = localizacaoProjeto;
        this.localizacaoDocumentosConstrucao = localizacaoDocumentosConstrucao;
        this.localizacaoDocumentosDiversos = localizacaoDocumentosDiversos;
    }

    //    Constructor para inspecao rotineira
    public IdentificacaoObraResponsaveis(int id, UnidadeLocal unidadeLocal) {
        this.id = id;
        this.unidadeLocal = unidadeLocal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UnidadeLocal getUnidadeLocal() {
        return unidadeLocal;
    }

    public void setUnidadeLocal(UnidadeLocal unidadeLocal) {
        this.unidadeLocal = unidadeLocal;
    }

    public TipoAdministracao getTipoAdministracao() {
        return tipoAdministracao;
    }

    public void setTipoAdministracao(TipoAdministracao tipoAdministracao) {
        this.tipoAdministracao = tipoAdministracao;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public String getProjetistaOrigem() {
        return projetistaOrigem;
    }

    public void setProjetistaOrigem(String projetistaOrigem) {
        this.projetistaOrigem = projetistaOrigem;
    }

    public String getProjetistaProjetista() {
        return projetistaProjetista;
    }

    public void setProjetistaProjetista(String projetistaProjetista) {
        this.projetistaProjetista = projetistaProjetista;
    }

    public String getConstrutorOrigem() {
        return construtorOrigem;
    }

    public void setConstrutorOrigem(String construtorOrigem) {
        this.construtorOrigem = construtorOrigem;
    }

    public String getConstrutorConstrutor() {
        return construtorConstrutor;
    }

    public void setConstrutorConstrutor(String construtorConstrutor) {
        this.construtorConstrutor = construtorConstrutor;
    }

    public String getLocalizacaoProjeto() {
        return localizacaoProjeto;
    }

    public void setLocalizacaoProjeto(String localizacaoProjeto) {
        this.localizacaoProjeto = localizacaoProjeto;
    }

    public String getLocalizacaoDocumentosConstrucao() {
        return localizacaoDocumentosConstrucao;
    }

    public void setLocalizacaoDocumentosConstrucao(String localizacaoDocumentosConstrucao) {
        this.localizacaoDocumentosConstrucao = localizacaoDocumentosConstrucao;
    }

    public String getLocalizacaoDocumentosDiversos() {
        return localizacaoDocumentosDiversos;
    }

    public void setLocalizacaoDocumentosDiversos(String localizacaoDocumentosDiversos) {
        this.localizacaoDocumentosDiversos = localizacaoDocumentosDiversos;
    }
    
    
}
