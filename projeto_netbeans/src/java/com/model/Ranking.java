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
public class Ranking implements Serializable {
    /**
     * identificador do Ranking no Banco de Dados
     */
    private int id;
    /**
     * identificador da ponte
     */
    private Ponte ponte;


    /**
     * Constructor padrão
     */
    public Ranking() {
    }

    /**
     * Constructor completo
     * @param id
     * @param ponte 
     */
    public Ranking(int id, Ponte ponte) {
        this.id = id;
        this.ponte = ponte;
    }

    public Ranking(Ponte ponte) {
        this.ponte = ponte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ponte getPonte() {
        return ponte;
    }

    public void setPonte(Ponte ponte) {
        this.ponte = ponte;
    }
}
