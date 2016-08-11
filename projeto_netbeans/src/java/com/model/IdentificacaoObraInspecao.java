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
public class IdentificacaoObraInspecao implements Serializable {
    /**
     * identificador do IdentificacaoObraInspecao no Banco de Dados
     */
    private int id;
    /**
     * periodo
     */
    private String periodo;
    /**
     * equipamento necessário para inspeção
     */
    private String equipamentoNecessario;
    /**
     * melhor época para inspeção da ponte
     */
    private String melhorEpoca;


    /**
     * Constructor padrão.
     */
    public IdentificacaoObraInspecao() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param periodo {@link #periodo}
     * @param equipamentoNecessario {@link #equipamentoNecessario}
     * @param melhorEpoca {@link #melhorEpoca}
     */
    public IdentificacaoObraInspecao(int id, String periodo, String equipamentoNecessario, String melhorEpoca) {
        this.id = id;
        this.periodo = periodo;
        this.equipamentoNecessario = equipamentoNecessario;
        this.melhorEpoca = melhorEpoca;
    }

    /**
     * Constructor sem id
     * @param periodo {@link #periodo}
     * @param equipamentoNecessario {@link #equipamentoNecessario}
     * @param melhorEpoca {@link #melhorEpoca}
     */
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
