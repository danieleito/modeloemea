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
import com.session.SessionContext;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniele Harumi Ito
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginBean extends ComumBean implements Serializable {
    
    private Usuario model;
    private String novaSenha;
    private String confirmarSenha;
    private final UsuarioDAO database;

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
                if (novaSenha != null && !novaSenha.isEmpty()) {
//                    if (novaSenha.equals(confirmarSenha)) {
                        u.setSenha(novaSenha);
                        database.editar(u);
                        adicionarMensagemInfo("Senha alterada com sucesso.");
//                    }
                }
                usuarioLogado = u;
                SessionContext.getInstance().setAttribute("usuarioLogado", u);
                verificarNovosElementosManifestacoes();
                redirecionar("/View/Compartilhado/inicio.jsf");
                return;
            }
        } catch (SQLException ex) {
            adicionarMensagemFatal(ex.getMessage());
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        redirecionar("/View/Compartilhado/login.jsf");
    }
    
    public void sair() {
        SessionContext.getInstance().encerrarSessao();
        usuarioLogado = null;
        adicionarMensagemInfo("Usuário deslogado com sucesso.");
        redirecionar("/View/Compartilhado/login.jsf");
    }

    private void verificarNovosElementosManifestacoes() {
        if (usuarioLogado.getTipoUsuario().getId() == 1) {
            //int novosElementos = new ElementosDAO().buscarQuantidadeNovos();
            //int novasManifestacoes = new ManifestacoesDAO().buscarQuantidadeNovas();
//            if (novosElementos > 0 || novasManifestacoes > 0) {
//                adicionarMensagemInfo("Existem novos elementos e/ou manifestações cadastrados.");
//            }
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Métodos getter e setter. ">
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
    // </editor-fold>
}
