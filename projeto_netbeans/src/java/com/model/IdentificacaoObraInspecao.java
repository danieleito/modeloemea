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
public class IdentificacaoObraInspecao {
    private int id;
    private String periodo;
    private String equipamentoNecessario;
    private String melhorEpoca;

    public IdentificacaoObraInspecao() {
    }

    public IdentificacaoObraInspecao(int id, String periodo, String equipamentoNecessario, String melhorEpoca) {
        this.id = id;
        this.periodo = periodo;
        this.equipamentoNecessario = equipamentoNecessario;
        this.melhorEpoca = melhorEpoca;
    }

    public IdentificacaoObraInspecao(String periodo, String equipamentoNecessario, String melhorEpoca) {
        this.periodo = periodo;
        this.equipamentoNecessario = equipamentoNecessario;
        this.melhorEpoca = melhorEpoca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getEquipamentoNecessario() {
        return equipamentoNecessario;
    }

    public void setEquipamentoNecessario(String equipamentoNecessario) {
        this.equipamentoNecessario = equipamentoNecessario;
    }

    public String getMelhorEpoca() {
        return melhorEpoca;
    }

    public void setMelhorEpoca(String melhorEpoca) {
        this.melhorEpoca = melhorEpoca;
    }
}
