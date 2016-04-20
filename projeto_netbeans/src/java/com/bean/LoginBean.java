/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.model.Usuario;
import com.dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniele
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginBean extends ComumBean implements Serializable {
    
    private Usuario model;
    private String novaSenha;
    private final UsuarioDAO database;

    public Usuario getModel() {
        return model;
    }

    public void setModel(Usuario model) {
        this.model = model;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public LoginBean() {
        model = new Usuario();
        database = new UsuarioDAO();
    }
    
    public void entrar() {
        try {
            Usuario u = database.buscar(model.getUsuario());
            if (u == null) {
                adicionarMensagemErro("Usuário não existe");
            } else if(!u.getSenha().equals(model.getSenha())) {
                adicionarMensagemErro("Senha inválida.");
            } else {
                adicionarMensagemInfo("Usuário logado com sucesso.");
                redirecionar("View/Compartilhado/home.jsf");
            }
        } catch (SQLException ex) {
            adicionarMensagemFatal(ex.getMessage());
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        redirecionar("");
    }
}
