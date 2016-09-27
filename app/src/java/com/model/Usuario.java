/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;

/**
 * Classe representa um Usuario do sistema
 * @author Daniele Harumi Ito
 */
public class Usuario implements Serializable {
    /**
     * identificador do Usuario no Banco de Dados
     */
    private int id;
    /**
     * Nome do usuario
     */
    private String nome;
    /**
     * Nome de usuário do usuario
     */
    private String usuario;
    /**
     * email do usuario
     */
    private String email;
    /**
     * senha do usuario
     */
    private String senha;
    /**
     * identificador do tipo usuário.
     */
    private TipoUsuario tipoUsuario;


    /**
     * Constructor padrão.
     */
    public Usuario() {
        tipoUsuario = new TipoUsuario();
    }

     /**
     * Constructor sem id
     * @param nome {@link #nome}
     * @param usuario {@link #usuario}
     * @param email {@link #email}
     * @param senha {@link #senha}
     * @param tipoUsuario {@link #tipoUsuario}
     */
    public Usuario(String nome, String usuario, String email, String senha, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Constructor.
     * @param id {@link #id}
     * @param nome {@link #nome}
     * @param usuario {@link #usuario}
     * @param email {@link #email}
     * @param senha {@link #senha}
     * @param tipoUsuario {@link #tipoUsuario}
     */
    public Usuario(int id, String nome, String usuario, String email, String senha, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }


    /**
     * retorna {@link #id}
     * @return {@link #id}
     */
    public int getId() {
        return id;
    }

    /**
     * retorna {@link #nome}
     * @return {@link #nome}
     */
    public String getNome() {
        return nome;
    }

    /**
     * retorna {@link #login}
     * @return {@link #login}
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * retorna {@link #email}
     * @return {@link #email}
     */
    public String getEmail() {
        return email;
    }

    /**
     * retorna {@link #senha}
     * @return {@link #senha}
     */
    public String getSenha() {
        return senha;
    }

    /**
     * retorna {@link #tipoUsuario}
     * @return @link #tipoUsuario}
     */
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}