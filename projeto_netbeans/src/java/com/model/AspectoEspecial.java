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
public class AspectoEspecial {
    private int id;
    private String descricao;

    public AspectoEspecial() {
    }

    public AspectoEspecial(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public AspectoEspecial(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
