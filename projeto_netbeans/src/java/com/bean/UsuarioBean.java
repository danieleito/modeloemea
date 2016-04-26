/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.UsuarioDAO;
import com.model.Usuario;
import java.io.Serializable;
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
public class UsuarioBean extends ComumBean {
    private Usuario model;
    private UsuarioDAO database;
    private ArrayList<Usuario> usuarios;

    public Usuario getModel() {
        return model;
    }

    public void setModel(Usuario model) {
        this.model = model;
    }

//    public UsuarioDAO getDatabase() {
//        return database;
//    }
//
//    public void setDatabase(UsuarioDAO database) {
//        this.database = database;
//    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public UsuarioBean() {
        database = new UsuarioDAO();
        model = new Usuario();
        try {
            usuarios = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            usuarios = new ArrayList<>();
            adicionarMensagemErro("Erro ao carregar usuários.");
        }
    }
    
    public void salvar(Usuario usuario) {
        try {
//            if (model.getUsuario() == null || model.getUsuario().isEmpty()) {
//                adicionarMensagemErro("Campo 'Nome' é obrigatório.");
//            }
//            else {
                adicionarMensagemInfo(model.toString());
                database.inserir(model);
                usuarios = database.buscar();
                adicionarMensagemInfo("Usuario cadastrado com sucesso.");
//            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao cadastrar usuário." + ex.getMessage());
        }
        redirecionar("/View/Administrador/Usuario/listar.jsf");        
    }
    
    public void editar(int id) {
        
    }
    
    public void deletar(int id) {
        try {
            database.excluir(id);
            adicionarMensagemInfo("Usuário removido com sucesso.");
        usuarios = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao remover usuário: " + ex.getMessage());
        }
        redirecionar("/View/Administrador/Usuario/listar.jsf");
    }
}
