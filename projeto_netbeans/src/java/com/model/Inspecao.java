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
public class Inspecao {
    private int id;
    private Date data;
    private Usuario usuario;
    private Ponte ponte;
    private Modelo modelo;
//    private String condicaoEstabilidade;
//    private String condicaoConservacao;
    

    public Inspecao() {
    }

    public Inspecao(int id, Date data, Usuario usuario, Ponte ponte, Modelo modelo) {
        this.id = id;
        this.data = data;
        this.usuario = usuario;
        this.ponte = ponte;
        this.modelo = modelo;
    }

    public Inspecao(Date data, Usuario usuario, Ponte ponte, Modelo modelo) {
        this.data = data;
        this.usuario = usuario;
        this.ponte = ponte;
        this.modelo = modelo;
    
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

    public Ponte getPonte() {
        return ponte;
    }

    public void setPonte(Ponte ponte) {
        this.ponte = ponte;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}
