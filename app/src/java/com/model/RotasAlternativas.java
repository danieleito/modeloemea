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
public class RotasAlternativas implements Serializable {
    /**
     * identificador do RotasAlternativas no Banco de Dados
     */
    private int id;
    /**
     * identificação
     */
    private String identificacao;
    /**
     * descrição das rotas alternativas
     */
    private String descricao;
    /**
     * acrescimo em km
     */
    private String acrescimoKm;


    /**
     * Constructor padrão
     */
    public RotasAlternativas() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param identificacao {@link #identificacao}
     * @param descricao {@link #descricao}
     * @param acrescimoKm {@link #acrescimoKm}
     */
    public RotasAlternativas(int id, String identificacao, String descricao, String acrescimoKm) {
        this.id = id;
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.acrescimoKm = acrescimoKm;
    }

    /**
     * Constructor sem id
     * @param identificacao {@link #identificacao}
     * @param descricao {@link #descricao}
     * @param acrescimoKm {@link #acrescimoKm}
     */
    public RotasAlternativas(String identificacao, String descricao, String acrescimoKm) {
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.acrescimoKm = acrescimoKm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAcrescimoKm() {
        return acrescimoKm;
    }

    public void setAcrescimoKm(String acrescimoKm) {
        this.acrescimoKm = acrescimoKm;
    }    
}
