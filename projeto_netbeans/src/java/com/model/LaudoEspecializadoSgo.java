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
public class LaudoEspecializadoSgo implements Serializable {
    /**
     * identificador do LaudoEspecializadoSgo no Banco de Dados
     */
    private int id;
    /**
     * data do laudo
     */
    private Date dataLaudo;
    /**
     * consultor
     */
    private String consultor;
    /**
     * observações sobre laudo
     */
    private String observacoes;


    /**
     * Constructor padrão.
     */
    public LaudoEspecializadoSgo() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param dataLaudo {@link #dataLaudo}
     * @param consultor {@link #consultor}
     * @param observacoes {@link #observacoes}
     */
    public LaudoEspecializadoSgo(int id, Date dataLaudo, String consultor, String observacoes) {
        this.id = id;
        this.dataLaudo = dataLaudo;
        this.consultor = consultor;
        this.observacoes = observacoes;
    }

    /**
     * Constructor sem id
     * @param dataLaudo {@link #dataLaudo}
     * @param consultor {@link #consultor}
     * @param observacoes {@link #observacoes}
     */
    public LaudoEspecializadoSgo(Date dataLaudo, String consultor, String observacoes) {
        this.dataLaudo = dataLaudo;
        this.consultor = consultor;
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataLaudo() {
        return dataLaudo;
    }

    public void setDataLaudo(Date dataLaudo) {
        this.dataLaudo = dataLaudo;
    }

    public String getConsultor() {
        return consultor;
    }

    public void setConsultor(String consultor) {
        this.consultor = consultor;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
