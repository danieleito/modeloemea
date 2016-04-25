/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.UsuarioDAO;
import com.model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniele Harumi Ito
 */
@ManagedBean(name = "usuario")
@SessionScoped
public class UsuarioBean {
    private UsuarioDAO database;
    private ArrayList<Usuario> usuarios;

    public UsuarioDAO getDatabase() {
        return database;
    }

    public void setDatabase(UsuarioDAO database) {
        this.database = database;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public UsuarioBean() {
        database = new UsuarioDAO();
        try {
            usuarios = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvar(Usuario usuario) {
        try {
            database.inserir(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
