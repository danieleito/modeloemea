/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Daniele Harumi Ito
 */
public class Ponte {
    private int id;
    private String indicePerformanceRelativo;
    private IdentificacaoObraDadosBasicos identificacaoObraDadosBasicos;
    private IdentificacaoObraLocalizacao identificacaoObraLocalizacao;
    private IdentificacaoObraResponsaveis identificacaoObraResponsaveis;
    private IdentificacaoObraInspecao identificacaoObraInspecao;
    private CaracteristicasFuncionaisCaracteristicas caracteristicasFuncionaisCaracteristicas;
    private CaracteristicasFuncionaisDimensoes caracteristicasFuncionaisDimensoes;
    private RotasAlternativas rotasAlternativas;
    private ArrayList<DeficienciaFuncional> deficienciasFuncionais;    
    private ArrayList<CadastroAspectoEspecial> aspectosEspeciais;
    private ArrayList<ElementoComponente> elementosComponentes;
    private Observacao observacao;
    private Substituicao substituicao;
//    private ArrayList<ArquivoAnexo> arquivosAnexos;
    
    //para exibir na tela que lista o ranking
    private Date dataUltimaInspecao;

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
    }

    public Ponte(int id, String indicePerformanceRelativo, IdentificacaoObraDadosBasicos identificacaoObraDadosBasicos, 
            IdentificacaoObraLocalizacao identificacaoObraLocalizacao, IdentificacaoObraResponsaveis identificacaoObraResponsaveis, 
            IdentificacaoObraInspecao identificacaoObraInspecao, CaracteristicasFuncionaisCaracteristicas caracteristicasFuncionaisCaracteristicas, 
            CaracteristicasFuncionaisDimensoes caracteristicasFuncionaisDimensoes, RotasAlternativas rotasAlternativas, 
            ArrayList<DeficienciaFuncional> deficienciasFuncionais, ArrayList<CadastroAspectoEspecial> aspectosEspeciais, 
            ArrayList<ElementoComponente> elementosComponentes, Observacao observacao, Substituicao substituicao, Date dataUltimaInspecao) {
        this.id = id;
        this.indicePerformanceRelativo = indicePerformanceRelativo;
        this.identificacaoObraDadosBasicos = identificacaoObraDadosBasicos;
        this.identificacaoObraLocalizacao = identificacaoObraLocalizacao;
        this.identificacaoObraResponsaveis = identificacaoObraResponsaveis;
        this.identificacaoObraInspecao = identificacaoObraInspecao;
        this.caracteristicasFuncionaisCaracteristicas = caracteristicasFuncionaisCaracteristicas;
        this.caracteristicasFuncionaisDimensoes = caracteristicasFuncionaisDimensoes;
        this.rotasAlternativas = rotasAlternativas;
        this.deficienciasFuncionais = deficienciasFuncionais;
        this.aspectosEspeciais = aspectosEspeciais;
        this.elementosComponentes = elementosComponentes;
        this.observacao = observacao;
        this.substituicao = substituicao;
        this.dataUltimaInspecao = dataUltimaInspecao;
    }

    public Ponte(String indicePerformanceRelativo, IdentificacaoObraDadosBasicos identificacaoObraDadosBasicos, IdentificacaoObraLocalizacao identificacaoObraLocalizacao, IdentificacaoObraResponsaveis identificacaoObraResponsaveis, IdentificacaoObraInspecao identificacaoObraInspecao, CaracteristicasFuncionaisCaracteristicas caracteristicasFuncionaisCaracteristicas, CaracteristicasFuncionaisDimensoes caracteristicasFuncionaisDimensoes, RotasAlternativas rotasAlternativas, ArrayList<DeficienciaFuncional> deficienciasFuncionais, ArrayList<CadastroAspectoEspecial> aspectosEspeciais, ArrayList<ElementoComponente> elementosComponentes, Observacao observacao, Substituicao substituicao, Date dataUltimaInspecao) {
        this.indicePerformanceRelativo = indicePerformanceRelativo;
        this.identificacaoObraDadosBasicos = identificacaoObraDadosBasicos;
        this.identificacaoObraLocalizacao = identificacaoObraLocalizacao;
        this.identificacaoObraResponsaveis = identificacaoObraResponsaveis;
        this.identificacaoObraInspecao = identificacaoObraInspecao;
        this.caracteristicasFuncionaisCaracteristicas = caracteristicasFuncionaisCaracteristicas;
        this.caracteristicasFuncionaisDimensoes = caracteristicasFuncionaisDimensoes;
        this.rotasAlternativas = rotasAlternativas;
        this.deficienciasFuncionais = deficienciasFuncionais;
        this.aspectosEspeciais = aspectosEspeciais;
        this.elementosComponentes = elementosComponentes;
        this.observacao = observacao;
        this.substituicao = substituicao;
        this.dataUltimaInspecao = dataUltimaInspecao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IdentificacaoObraDadosBasicos getIdentificacaoObraDadosBasicos() {
        return identificacaoObraDadosBasicos;
    }

    public void setIdentificacaoObraDadosBasicos(IdentificacaoObraDadosBasicos identificacaoObraDadosBasicos) {
        this.identificacaoObraDadosBasicos = identificacaoObraDadosBasicos;
    }

    public IdentificacaoObraLocalizacao getIdentificacaoObraLocalizacao() {
        return identificacaoObraLocalizacao;
    }

    public void setIdentificacaoObraLocalizacao(IdentificacaoObraLocalizacao identificacaoObraLocalizacao) {
        this.identificacaoObraLocalizacao = identificacaoObraLocalizacao;
    }

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

//    public ArrayList<ArquivoAnexo> getArquivosAnexos() {
//        return arquivosAnexos;
//    }
//
//    public void setArquivosAnexos(ArrayList<ArquivoAnexo> arquivosAnexos) {
//        this.arquivosAnexos = arquivosAnexos;
//    }

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
}