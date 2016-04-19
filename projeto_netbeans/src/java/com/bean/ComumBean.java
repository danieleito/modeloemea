/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Daniele
 */
public abstract class ComumBean {

    protected String redirecionar(String url) {
        return url + "?faces-redirect-true";
    }
    
    protected String erro(String exception) {
        //montra o treco e coloca a mensagem dentro
        return redirecionar("erro.jsf");
    }
    
    protected void adicionarMensagemErro(String mensagem) {
        adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Erro", mensagem);
    }
    
    protected void adicionarMensagemInfo(String mensagem) {
        adicionarMensagem(FacesMessage.SEVERITY_INFO, "Aviso", mensagem);
    }
    
    private void adicionarMensagem(FacesMessage.Severity severity, String titulo, String mensagem) {
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, titulo, mensagem));
    }
}
