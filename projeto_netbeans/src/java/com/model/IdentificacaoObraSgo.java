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
    private Ponte ponte;
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
     * @param id
     * @param ponte
     * @param dataInspecao
     * @param nomeInspetor 
     */
    public IdentificacaoObraSgo(int id, Ponte ponte, Date dataInspecao, String nomeInspetor) {
        this.id = id;
        this.ponte = ponte;
        this.dataInspecao = dataInspecao;
        this.nomeInspetor = nomeInspetor;
    }

    public IdentificacaoObraSgo(Ponte ponte, Date dataInspecao, String nomeInspetor) {
        this.ponte = ponte;
        this.dataInspecao = dataInspecao;
        this.nomeInspetor = nomeInspetor;
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

    public Date getDataInspecao() {
        return dataInspecao;
    }

    public void setDataInspecao(Date dataInspecao) {
        this.dataInspecao = dataInspecao;
    }

    public String getNomeInspetor() {
        return nomeInspetor;
    }

    public void setNomeInspetor(String nomeInspetor) {
        this.nomeInspetor = nomeInspetor;
    }
}
