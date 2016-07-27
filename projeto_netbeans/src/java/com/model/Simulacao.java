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
public class Simulacao {
    private int id;
    private Date data;
    private Usuario usuario;
    private String nomeSimulacao;
    private ArrayList<Ranking> rankings;

    public Simulacao() {
    }

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