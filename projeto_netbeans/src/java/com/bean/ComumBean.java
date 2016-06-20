/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Daniele Harumi Ito
 */
public abstract class ComumBean {
    
    public static Usuario usuarioLogado;

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        ComumBean.usuarioLogado = usuarioLogado;
    }

    protected void redirecionar(String url) {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        try {
            context.getFlash().setKeepMessages(true);
            context.redirect(context.getRequestContextPath() + url + "?faces-redirect-true");
            //return url + "?faces-redirect-true";
        } catch (IOException ex) {
            Logger.getLogger(ComumBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void erro(String exception) {
        //montra o treco e coloca a mensagem dentro
        redirecionar("erro.jsf");
    }
    
    protected void adicionarMensagemInfo(String mensagem) {
        adicionarMensagem(FacesMessage.SEVERITY_INFO, "Aviso", mensagem);
    }
    
    protected void adicionarMensagemWarning(String mensagem) {
        adicionarMensagem(FacesMessage.SEVERITY_WARN, "Aviso", mensagem);
    }
    
    protected void adicionarMensagemErro(String mensagem) {
        adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Erro", mensagem);
    }
    
    protected void adicionarMensagemFatal(String mensagem) {
        adicionarMensagem(FacesMessage.SEVERITY_FATAL, "Erro", mensagem);
    }
    
    private void adicionarMensagem(FacesMessage.Severity severity, String titulo, String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, titulo, mensagem));
    }
}
