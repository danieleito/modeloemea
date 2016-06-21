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
public class RotasAlternativas {
    private int id;
    private String identificacao;
    private String descricao;
    private String acrescimoKm;

    public RotasAlternativas() {
    }

    public RotasAlternativas(int id, String identificacao, String descricao, String acrescimoKm) {
        this.id = id;
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.acrescimoKm = acrescimoKm;
    }

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