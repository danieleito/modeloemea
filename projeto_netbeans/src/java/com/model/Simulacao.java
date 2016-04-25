/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.Date;


/**
 *
 * @author Daniele Harumi Ito
 */
public class Simulacao {
    private int id;
    private Date data;
    private Usuario usuario;
    private String simulacao;

    public Simulacao() {
    }

     //apagar depois que o tipo Date estiver correto
    public Simulacao(Usuario usuario, String simulacao) {
        this.usuario = usuario;
        this.simulacao = simulacao;
    }
    //apagar depois que o tipo Date estiver correto
    public Simulacao(int id, Usuario usuario, String simulacao) {
        this.id = id;
        this.usuario = usuario;
        this.simulacao = simulacao;
    }

    public Simulacao(int id, Date data, Usuario usuario, String simulacao) {
        this.id = id;
        this.data = data;
        this.usuario = usuario;
        this.simulacao = simulacao;
    }

    public Simulacao(Date data, Usuario usuario, String simulacao) {
        this.data = data;
        this.usuario = usuario;
        this.simulacao = simulacao;
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

    public String getSimulacao() {
        return simulacao;
    }

    public void setSimulacao(String simulacao) {
        this.simulacao = simulacao;
    }
}