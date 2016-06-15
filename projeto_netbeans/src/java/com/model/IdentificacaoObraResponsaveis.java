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
public class IdentificacaoObraResponsaveis {
    private int id;
    private SuperintendenciaRegional idSuperintendenciaRegional;
    private UnidadeLocal idUnidadeLocal;
    private TipoAdministracao idTipoAdministracao;
    private String administrador;
    private String projetistaOrigem;
    private String projetistaProjetista;
    private String construtorOrigem;
    private String construtorConstrutor;
    private String localizacaoProjeto;
    private String localizacaoDocumentosConstrucao;
    private String localizacaoDocumentosDiversos;

    public IdentificacaoObraResponsaveis() {
    }

    public IdentificacaoObraResponsaveis(int id, SuperintendenciaRegional idSuperintendenciaRegional, 
            UnidadeLocal idUnidadeLocal, TipoAdministracao idTipoAdministracao, String administrador, 
            String projetistaOrigem, String projetistaProjetista, String construtorOrigem, 
            String construtorConstrutor, String localizacaoProjeto, String localizacaoDocumentosConstrucao, 
            String localizacaoDocumentosDiversos) {
        this.id = id;
        this.idSuperintendenciaRegional = idSuperintendenciaRegional;
        this.idUnidadeLocal = idUnidadeLocal;
        this.idTipoAdministracao = idTipoAdministracao;
        this.administrador = administrador;
        this.projetistaOrigem = projetistaOrigem;
        this.projetistaProjetista = projetistaProjetista;
        this.construtorOrigem = construtorOrigem;
        this.construtorConstrutor = construtorConstrutor;
        this.localizacaoProjeto = localizacaoProjeto;
        this.localizacaoDocumentosConstrucao = localizacaoDocumentosConstrucao;
        this.localizacaoDocumentosDiversos = localizacaoDocumentosDiversos;
    }

    public IdentificacaoObraResponsaveis(SuperintendenciaRegional idSuperintendenciaRegional, UnidadeLocal idUnidadeLocal, TipoAdministracao idTipoAdministracao, String administrador, String projetistaOrigem, String projetistaProjetista, String construtorOrigem, String construtorConstrutor, String localizacaoProjeto, String localizacaoDocumentosConstrucao, String localizacaoDocumentosDiversos) {
        this.idSuperintendenciaRegional = idSuperintendenciaRegional;
        this.idUnidadeLocal = idUnidadeLocal;
        this.idTipoAdministracao = idTipoAdministracao;
        this.administrador = administrador;
        this.projetistaOrigem = projetistaOrigem;
        this.projetistaProjetista = projetistaProjetista;
        this.construtorOrigem = construtorOrigem;
        this.construtorConstrutor = construtorConstrutor;
        this.localizacaoProjeto = localizacaoProjeto;
        this.localizacaoDocumentosConstrucao = localizacaoDocumentosConstrucao;
        this.localizacaoDocumentosDiversos = localizacaoDocumentosDiversos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SuperintendenciaRegional getIdSuperintendenciaRegional() {
        return idSuperintendenciaRegional;
    }

    public void setIdSuperintendenciaRegional(SuperintendenciaRegional idSuperintendenciaRegional) {
        this.idSuperintendenciaRegional = idSuperintendenciaRegional;
    }

    public UnidadeLocal getIdUnidadeLocal() {
        return idUnidadeLocal;
    }

    public void setIdUnidadeLocal(UnidadeLocal idUnidadeLocal) {
        this.idUnidadeLocal = idUnidadeLocal;
    }

    public TipoAdministracao getIdTipoAdministracao() {
        return idTipoAdministracao;
    }

    public void setIdTipoAdministracao(TipoAdministracao idTipoAdministracao) {
        this.idTipoAdministracao = idTipoAdministracao;
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
