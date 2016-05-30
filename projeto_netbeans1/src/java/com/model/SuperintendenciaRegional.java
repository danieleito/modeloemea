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
public class SuperintendenciaRegional {
    private int id;
    private String superintendenciaRegional;

    public SuperintendenciaRegional() {
    }

    public SuperintendenciaRegional(int id, String superintendenciaRegional) {
        this.id = id;
        this.superintendenciaRegional = superintendenciaRegional;
    }

    public SuperintendenciaRegional(String superintendenciaRegional) {
        this.superintendenciaRegional = superintendenciaRegional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuperintendenciaRegional() {
        return superintendenciaRegional;
    }

    public void setSuperintendenciaRegional(String superintendenciaRegional) {
        this.superintendenciaRegional = superintendenciaRegional;
    }
}
