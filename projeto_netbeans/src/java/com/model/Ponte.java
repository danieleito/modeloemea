/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Daniele Harumi Ito
 */
public class Ponte implements Serializable {
    /**
     * identificador do Ponte no Banco de Dados
     */
    private int id;
    /**
     * indice de performance relativo
     */
    private String indicePerformanceRelativo;
    /**
     * identificador da identificação obra de dados básicos
     */
    private IdentificacaoObraDadosBasicos identificacaoObraDadosBasicos;
    /**
     * identificador da identificação obra localização
     */
    private IdentificacaoObraLocalizacao identificacaoObraLocalizacao;
    /**
     * identificador da identificação obra responsáveis
     */
    private IdentificacaoObraResponsaveis identificacaoObraResponsaveis;
    /**
     * identificador da identificação obra inspeção
     */
    private IdentificacaoObraInspecao identificacaoObraInspecao;
    /**
     * identificador da caracteristicas funcionais 
     */
    private CaracteristicasFuncionaisCaracteristicas caracteristicasFuncionaisCaracteristicas;
    /**
     * identificador da caracteristicas funcionais dimensões
     */
    private CaracteristicasFuncionaisDimensoes caracteristicasFuncionaisDimensoes;
    /**
     * identificador das rotas alternativas
     */
    private RotasAlternativas rotasAlternativas;
    /**
     * lista de deficiências funcionais
     */
    private ArrayList<DeficienciaFuncional> deficienciasFuncionais;
    /**
     * lista de aspectos especiais
     */
    private ArrayList<CadastroAspectoEspecial> aspectosEspeciais;
    /**
     * lista de elementos componentes
     */
    private ArrayList<ElementoComponente> elementosComponentes;
    /**
     * identificador de observação
     */
    private Observacao observacao;
    /**
     * identificador da substituição
     */
    private Substituicao substituicao;
    /**
     * identificador do cadastro manifestação
     */
//    private CadastroManifestacao cadastroManifestacao;
    /**
     * lista arquivos anexos
     */
    private ArrayList<ArquivoAnexoCadastro> arquivosAnexosCadastro;
   
    /**
     * lista inspeção
     */
    private ArrayList<Inspecao> inspecoes;

    /**
     * data da última inspeção
     * para exibir na tela que lista o ranking
     */
    private Date dataUltimaInspecao;


    /**
     * Constructor padrão
     */
    public Ponte() {
        identificacaoObraDadosBasicos = new IdentificacaoObraDadosBasicos();
        identificacaoObraInspecao = new IdentificacaoObraInspecao();
        identificacaoObraLocalizacao = new IdentificacaoObraLocalizacao();
        identificacaoObraResponsaveis = new IdentificacaoObraResponsaveis();
        caracteristicasFuncionaisCaracteristicas = new CaracteristicasFuncionaisCaracteristicas();
        caracteristicasFuncionaisDimensoes = new CaracteristicasFuncionaisDimensoes();
        rotasAlternativas = new RotasAlternativas();
        deficienciasFuncionais = new ArrayList<>();
        aspectosEspeciais = new ArrayList<>();
        elementosComponentes = new ArrayList<>();
        observacao = new Observacao();
        substituicao = new Substituicao();
//        cadastroManifestacao = new CadastroManifestacao();
        arquivosAnexosCadastro = new ArrayList<>();
        inspecoes = new ArrayList<>();
    }

    /**
     * Constructor apenas com id
     * @param id {@link #id}
     */
    public Ponte(int id) {
        this.id = id;
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param indicePerformanceRelativo {@link #indicePerformanceRelativo}
     * @param identificacaoObraDadosBasicos {@link #identificacaoObraDadosBasicos}
     * @param identificacaoObraLocalizacao {@link #identificacaoObraLocalizacao}
     * @param identificacaoObraResponsaveis {@link #identificacaoObraResponsaveis}
     * @param identificacaoObraInspecao {@link #identificacaoObraInspecao}
     * @param caracteristicasFuncionaisCaracteristicas {@link #caracteristicasFuncionaisCaracteristicas}
     * @param caracteristicasFuncionaisDimensoes {@link #caracteristicasFuncionaisDimensoes}
     * @param rotasAlternativas {@link #rotasAlternativas}
     * @param observacao {@link #observacao}
     * @param substituicao {@link #substituicao}
     */
    public Ponte(int id, String indicePerformanceRelativo, IdentificacaoObraDadosBasicos identificacaoObraDadosBasicos, 
            IdentificacaoObraLocalizacao identificacaoObraLocalizacao, IdentificacaoObraResponsaveis identificacaoObraResponsaveis, 
            IdentificacaoObraInspecao identificacaoObraInspecao, CaracteristicasFuncionaisCaracteristicas caracteristicasFuncionaisCaracteristicas, 
            CaracteristicasFuncionaisDimensoes caracteristicasFuncionaisDimensoes, RotasAlternativas rotasAlternativas,
            Observacao observacao, Substituicao substituicao) {
        this.id = id;
        this.indicePerformanceRelativo = indicePerformanceRelativo;
        this.identificacaoObraDadosBasicos = identificacaoObraDadosBasicos;
        this.identificacaoObraLocalizacao = identificacaoObraLocalizacao;
        this.identificacaoObraResponsaveis = identificacaoObraResponsaveis;
        this.identificacaoObraInspecao = identificacaoObraInspecao;
        this.caracteristicasFuncionaisCaracteristicas = caracteristicasFuncionaisCaracteristicas;
        this.caracteristicasFuncionaisDimensoes = caracteristicasFuncionaisDimensoes;
        this.rotasAlternativas = rotasAlternativas;
        this.observacao = observacao;
        this.substituicao = substituicao;
//        this.cadastroManifestacao = cadastroManifestacao;
    }

    /**
     * Constructor sem id
     * @param indicePerformanceRelativo {@link #indicePerformanceRelativo}
     * @param identificacaoObraDadosBasicos {@link #identificacaoObraDadosBasicos}
     * @param identificacaoObraLocalizacao {@link #identificacaoObraLocalizacao}
     * @param identificacaoObraResponsaveis {@link #identificacaoObraResponsaveis}
     * @param identificacaoObraInspecao {@link #identificacaoObraInspecao}
     * @param caracteristicasFuncionaisCaracteristicas {@link #caracteristicasFuncionaisCaracteristicas}
     * @param caracteristicasFuncionaisDimensoes {@link #caracteristicasFuncionaisDimensoes}
     * @param rotasAlternativas {@link #rotasAlternativas}
     * @param observacao {@link #observacao}
     * @param substituicao {@link #substituicao}
     */
    public Ponte(String indicePerformanceRelativo, IdentificacaoObraDadosBasicos identificacaoObraDadosBasicos, IdentificacaoObraLocalizacao identificacaoObraLocalizacao, 
            IdentificacaoObraResponsaveis identificacaoObraResponsaveis, IdentificacaoObraInspecao identificacaoObraInspecao, 
            CaracteristicasFuncionaisCaracteristicas caracteristicasFuncionaisCaracteristicas, CaracteristicasFuncionaisDimensoes caracteristicasFuncionaisDimensoes, 
            RotasAlternativas rotasAlternativas, Observacao observacao, Substituicao substituicao) {
        this.indicePerformanceRelativo = indicePerformanceRelativo;
        this.identificacaoObraDadosBasicos = identificacaoObraDadosBasicos;
        this.identificacaoObraLocalizacao = identificacaoObraLocalizacao;
        this.identificacaoObraResponsaveis = identificacaoObraResponsaveis;
        this.identificacaoObraInspecao = identificacaoObraInspecao;
        this.caracteristicasFuncionaisCaracteristicas = caracteristicasFuncionaisCaracteristicas;
        this.caracteristicasFuncionaisDimensoes = caracteristicasFuncionaisDimensoes;
        this.rotasAlternativas = rotasAlternativas;
        this.observacao = observacao;
        this.substituicao = substituicao;
//        this.cadastroManifestacao = cadastroManifestacao;
    }

    /**
     * Constructor apenas com id, identificacaoObraDadosBasicos, identificacaoObraLocalizacao, identificacaoObraResponsaveis
     * @param id {@link #id}
     * @param identificacaoObraDadosBasicos {@link #identificacaoObraDadosBasicos}
     * @param identificacaoObraLocalizacao {@link #identificacaoObraLocalizacao}
     * @param identificacaoObraResponsaveis {@link #identificacaoObraResponsaveis}
     */
//    constructor para inspecao rotineira
    public Ponte(int id, IdentificacaoObraDadosBasicos identificacaoObraDadosBasicos, IdentificacaoObraLocalizacao identificacaoObraLocalizacao, IdentificacaoObraResponsaveis identificacaoObraResponsaveis) {
        this.id = id;
        this.identificacaoObraDadosBasicos = identificacaoObraDadosBasicos;
        this.identificacaoObraLocalizacao = identificacaoObraLocalizacao;
        this.identificacaoObraResponsaveis = identificacaoObraResponsaveis;
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
     * retorna {@link #identificacaoObraDadosBasicos}
     * @return {@link #identificacaoObraDadosBasicos}
     */
    public IdentificacaoObraDadosBasicos getIdentificacaoObraDadosBasicos() {
        return identificacaoObraDadosBasicos;
    }

    public void setIdentificacaoObraDadosBasicos(IdentificacaoObraDadosBasicos identificacaoObraDadosBasicos) {
        this.identificacaoObraDadosBasicos = identificacaoObraDadosBasicos;
    }

    /**
     * retorna {@link #identificacaoObraLocalizacao}
     * @return {@link #identificacaoObraLocalizacao}
     */
    public IdentificacaoObraLocalizacao getIdentificacaoObraLocalizacao() {
        return identificacaoObraLocalizacao;
    }

    public void setIdentificacaoObraLocalizacao(IdentificacaoObraLocalizacao identificacaoObraLocalizacao) {
        this.identificacaoObraLocalizacao = identificacaoObraLocalizacao;
    }

    /**
     * retorna {@link #identificacaoObraresponsaveis}
     * @return {@link #identificacaoObraresponsaveis}
     */
    public IdentificacaoObraResponsaveis getIdentificacaoObraResponsaveis() {
        return identificacaoObraResponsaveis;
    }

    public void setIdentificacaoObraResponsaveis(IdentificacaoObraResponsaveis identificacaoObraResponsaveis) {
        this.identificacaoObraResponsaveis = identificacaoObraResponsaveis;
    }

    public IdentificacaoObraInspecao getIdentificacaoObraInspecao() {
        return identificacaoObraInspecao;
    }

    public void setIdentificacaoObraInspecao(IdentificacaoObraInspecao identificacaoObraInspecao) {
        this.identificacaoObraInspecao = identificacaoObraInspecao;
    }

    public Date getDataUltimaInspecao() {
        return dataUltimaInspecao;
    }

    public void setDataUltimaInspecao(Date dataUltimaInspecao) {
        this.dataUltimaInspecao = dataUltimaInspecao;
    }

    public String getIndicePerformanceRelativo() {
        return indicePerformanceRelativo;
    }

    public void setIndicePerformanceRelativo(String indicePerformanceRelativo) {
        this.indicePerformanceRelativo = indicePerformanceRelativo;
    }

    public CaracteristicasFuncionaisCaracteristicas getCaracteristicasFuncionaisCaracteristicas() {
        return caracteristicasFuncionaisCaracteristicas;
    }

    public void setCaracteristicasFuncionaisCaracteristicas(CaracteristicasFuncionaisCaracteristicas caracteristicasFuncionaisCaracteristicas) {
        this.caracteristicasFuncionaisCaracteristicas = caracteristicasFuncionaisCaracteristicas;
    }

    public CaracteristicasFuncionaisDimensoes getCaracteristicasFuncionaisDimensoes() {
        return caracteristicasFuncionaisDimensoes;
    }

    public void setCaracteristicasFuncionaisDimensoes(CaracteristicasFuncionaisDimensoes caracteristicasFuncionaisDimensoes) {
        this.caracteristicasFuncionaisDimensoes = caracteristicasFuncionaisDimensoes;
    }

    public RotasAlternativas getRotasAlternativas() {
        return rotasAlternativas;
    }

    public void setRotasAlternativas(RotasAlternativas rotasAlternativas) {
        this.rotasAlternativas = rotasAlternativas;
    }

    public ArrayList<DeficienciaFuncional> getDeficienciasFuncionais() {
        return deficienciasFuncionais;
    }

    public void setDeficienciasFuncionais(ArrayList<DeficienciaFuncional> deficienciasFuncionais) {
        this.deficienciasFuncionais = deficienciasFuncionais;
    }

    public ArrayList<CadastroAspectoEspecial> getAspectosEspeciais() {
        return aspectosEspeciais;
    }

    public void setAspectosEspeciais(ArrayList<CadastroAspectoEspecial> aspectosEspeciais) {
        this.aspectosEspeciais = aspectosEspeciais;
    }   

    public ArrayList<ElementoComponente> getElementosComponentes() {
        return elementosComponentes;
    }

    public void setElementosComponentes(ArrayList<ElementoComponente> elementosComponentes) {
        this.elementosComponentes = elementosComponentes;
    }

    public ArrayList<ArquivoAnexoCadastro> getArquivosAnexosCadastro() {
        return arquivosAnexosCadastro;
    }

    public void setArquivosAnexosCadastro(ArrayList<ArquivoAnexoCadastro> arquivosAnexosCadastro) {
        this.arquivosAnexosCadastro = arquivosAnexosCadastro;
    }

    public ArrayList<Inspecao> getInspecoes() {
        return inspecoes;
    }

    public void setInspecoes(ArrayList<Inspecao> inspecoes) {
        this.inspecoes = inspecoes;
    }

    public Observacao getObservacao() {
        return observacao;
    }

    public void setObservacao(Observacao observacao) {
        this.observacao = observacao;
    }

    public Substituicao getSubstituicao() {
        return substituicao;
    }

    public void setSubstituicao(Substituicao substituicao) {
        this.substituicao = substituicao;
    }

//    public CadastroManifestacao getCadastroManifestacao() {
//        return cadastroManifestacao;
//    }
//
//    public void setCadastroManifestacao(CadastroManifestacao cadastroManifestacao) {
//        this.cadastroManifestacao = cadastroManifestacao;
//    }
}