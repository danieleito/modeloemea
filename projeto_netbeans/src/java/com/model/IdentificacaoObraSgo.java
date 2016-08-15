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
public class IdentificacaoObraSgo implements Serializable {
    /**
     * identificador do IdentificacaoObraSgo no Banco de Dados
     */
    private int id;
    /**
     * identifidor da ponte
     */
    //private Ponte ponte;
    /**
     * data da inspeção
     */
    private Date dataInspecao;
    /**
     * nome do inspetor da ponte
     */
    private String nomeInspetor;


    /**
     * Constructor padrão.
     */
    public IdentificacaoObraSgo() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param dataInspecao {@link #dataInspecao}
     * @param nomeInspetor {@link #nomeInspetor}
     */
    public IdentificacaoObraSgo(int id, Date dataInspecao, String nomeInspetor) {
        this.id = id;
        this.dataInspecao = dataInspecao;
        this.nomeInspetor = nomeInspetor;
    }

    /**
     * Constructor sem id
     * @param dataInspecao {@link #dataInspecao}
     * @param nomeInspetor {@link #nomeInspetor}
     */
    public IdentificacaoObraSgo(Date dataInspecao, String nomeInspetor) {
        this.dataInspecao = dataInspecao;
        this.nomeInspetor = nomeInspetor;
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
     * retorna {@link #dataInspecao}
     * @return {@link #dataInspecao}
     */
    public Date getDataInspecao() {
        return dataInspecao;
    }

    public void setDataInspecao(Date dataInspecao) {
        this.dataInspecao = dataInspecao;
    }

    /**
     * retorna {@link #nomeInspetor}
     * @return {@link #nomeInspetor}
     */
    public String getNomeInspetor() {
        return nomeInspetor;
    }

    public void setNomeInspetor(String nomeInspetor) {
        this.nomeInspetor = nomeInspetor;
    }
}
