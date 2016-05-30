/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;

/**
 * Classe representa um tipo de usuario so sistema
 * @author Daniele Harumi Ito
 */
public class TipoUsuario implements Serializable {
    /**
     * Identificador do Engenheiro no Banco de Dados
     */
    private int id;

    /**
     * tipo do engenheiro
     */
    private String tipoUsuario;

    /**
     * Constructor padrao
     */
    public TipoUsuario() {
    }

    /**
     * Constructor com id
     * @param id {@link #id}
     * @param tipoUsuario {@link #tipoUsuario}
     */
    public TipoUsuario(int id, String tipoUsuario) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Constructor sem id
     * @param tipoUsuario {@link #tipoUsuario} 
     */
    public TipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Retorna {@link #id}
     * @return {@link  #id}
     */
    public int getId() {
        return id;
    }

    /**
     * retorna {@link #tipoUsuario}
     * @return {@link #tipoUsuario}
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    @Override
    public String toString() {
        return this.tipoUsuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
