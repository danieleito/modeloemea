/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.model.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Daniele Harumi Ito
 */
@ManagedBean(name = "comumbean")
@SessionScoped
public class ComumBean {

    public static Usuario usuarioLogado;

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

    public StreamedContent getImage() throws FileNotFoundException {
       FacesContext context = FacesContext.getCurrentInstance();

       if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
           // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
           return new DefaultStreamedContent();
       }
       else {
           // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
           String filename = context.getExternalContext().getRequestParameterMap().get("filename");
           String tipoImagem = context.getExternalContext().getRequestParameterMap().get("tipoimagem");

           File imagens_dir = new File(System.getProperty("jboss.server.data.dir")+File.separatorChar+ "imagens");
           StreamedContent sc = new DefaultStreamedContent(new FileInputStream(new File(imagens_dir, filename)), tipoImagem, filename);

           return sc;
       }
    }

    public StreamedContent getImage(String filename, String tipoImagem) throws FileNotFoundException {
       FacesContext context = FacesContext.getCurrentInstance();

       if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
           // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
           return new DefaultStreamedContent();
       }
       else {
           // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
           File imagens_dir = new File(System.getProperty("jboss.server.data.dir") + File.separatorChar + "imagens");
           StreamedContent sc = new DefaultStreamedContent(new FileInputStream(new File(imagens_dir, filename)), tipoImagem, filename);
           return sc;
       }
    }

    public char getFileSeparator() {
        return File.separatorChar;
    }

    protected String getImagePath(String imageName) {
        return FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestContextPath() + "/resources/images/" + imageName;
    }

    public String dateToString(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        String strDate = df.format(date);
        return strDate;
    }

    public String getMensagemTabelaVazia() { 
        return "Nenhum registro cadastrado.";
    }
    
    public String getFileManager(String action, String nomeArquivo) {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        //return "/FileManager?action=getPdf&amp;nomePdf=" + nomePdf;
        if (action.equalsIgnoreCase("getPdf")) {
            return context.getRequestContextPath() + "/FileManager?action=getPdf&nomePdf=" + nomeArquivo;
        } else {
            return context.getRequestContextPath() + "/FileManager?action=getImage&nomeImagem=" + nomeArquivo;
        }
    }
    
    public String getValorFormatado(double valor) {
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(valor);
    }

    // <editor-fold defaultstate="collapsed" desc=" Métodos getter e setter. ">
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        ComumBean.usuarioLogado = usuarioLogado;
    }
    // </editor-fold>
}
