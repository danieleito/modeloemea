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
public class Simulacao implements Serializable {
    /**
     * identificador do Simulacao no Banco de Dados
     */
    private int id;
    /**
     * data que foi criada a simulação
     */
    private Date data;
    /**
     * identificador do usuário
     */
    private Usuario usuario;
    /**
     * nome da simulação
     */
    private String nomeSimulacao;
    /**
     * lista de rankings
     */
    private ArrayList<Ranking> rankings;


    /**
     * Constructor padrão
     */
    public Simulacao() {
    }

    /**
     * Constructor completo
     * @param id
     * @param data
     * @param usuario
     * @param nomeSimulacao
     * @param rankings 
     */
    public Simulacao(int id, Date data, Usuario usuario, String nomeSimulacao, ArrayList<Ranking> rankings) {
        this.id = id;
        this.data = data;
        this.usuario = usuario;
        this.nomeSimulacao = nomeSimulacao;
        this.rankings = rankings;
    }

    public Simulacao(Date data, Usuario usuario, String nomeSimulacao, ArrayList<Ranking> rankings) {
        this.data = data;
        this.usuario = usuario;
        this.nomeSimulacao = nomeSimulacao;
        this.rankings = rankings;
    }

    public Simulacao(int id, ArrayList<Ranking> rankings) {
        this.id = id;
        this.rankings = rankings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNomeSimulacao() {
        return nomeSimulacao;
    }

    public void setNomeSimulacao(String nomeSimulacao) {
        this.nomeSimulacao = nomeSimulacao;
    }

    public ArrayList<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(ArrayList<Ranking> rankings) {
        this.rankings = rankings;
    }
}