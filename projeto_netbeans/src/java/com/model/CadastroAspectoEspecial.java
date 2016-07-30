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
public class CadastroAspectoEspecial implements Serializable {
    private int id;
    private AspectoEspecial aspectoEspecial;

    public CadastroAspectoEspecial() {
    }

    public CadastroAspectoEspecial(int id, AspectoEspecial aspectoEspecial) {
        this.id = id;
        this.aspectoEspecial = aspectoEspecial;
    }

    public CadastroAspectoEspecial(AspectoEspecial aspectoEspecial) {
        this.aspectoEspecial = aspectoEspecial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AspectoEspecial getAspectoEspecial() {
        return aspectoEspecial;
    }

    public void setAspectoEspecial(AspectoEspecial aspectoEspecial) {
        this.aspectoEspecial = aspectoEspecial;
    }
}