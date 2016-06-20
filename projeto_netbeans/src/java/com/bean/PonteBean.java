/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.PonteDAO;
import com.dao.RankingDAO;
import com.dao.UfDAO;
import com.model.Ponte;
import com.model.Ranking;
import com.model.Uf;
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
@ManagedBean(name="ponteBean")
@SessionScoped
public class PonteBean extends ComumBean implements Serializable {

    private Ponte model;
    private PonteDAO database;
    private ArrayList<Ponte> pontes;
    private ArrayList<Uf> ufs;
    
    // <editor-fold defaultstate="collapsed" desc=" Campos utilizados como filtro na busca por pontes. ">
    private String filtroCodigo;
    private String filtroIdentificacao;
    private int filtroIdUf;
    private int filtroIdVia;
    private String filtroKmInicial;
    private String filtroKmFinal;
    private int filtroIdSuperintendencia;
    private int filtroIdUnidadeLocal;
    // </editor-fold>
    
    /**
     * Constructor
     */
    public PonteBean() {
        database = new PonteDAO();
        model = new Ponte();
        try {
            ufs = new UfDAO().buscar();
        } catch (SQLException ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cancelar() {
        redirecionar("/View/Compartilhado/Simulacao/ranking.jsf");
    }
    
    public void visualizar(int id) {
        //visualiza ponte do 'id'
    }
    
    public void carregar(int idPonte, int idSimulacao) {
        try {            
            RankingDAO db = new RankingDAO();
            db.inserir(idPonte, idSimulacao);
            //SimulacaoBean.carregarRanking(idSimulacao);
            adicionarMensagemInfo("Ponte adicionada com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar ponte no ranking." + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/Simulacao/ranking.jsf");
    }
    
    public void consultarGet() {
        try {
            limparFiltros();
            pontes = database.buscar();
        } catch (SQLException ex) {
            pontes = new ArrayList<>();
            adicionarMensagemErro("Erro ao carregar pontes. " + ex.getMessage());
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        redirecionar("/View/Compartilhado/buscarOAE.jsf");
    }
    
    public void consultarPost() throws SQLException {
        try {
            pontes = database.buscar2(filtroCodigo, filtroIdentificacao,
                    filtroIdUf, filtroIdVia, 
                    filtroKmInicial.isEmpty() ? 0 :Integer.parseInt(filtroKmInicial), 
                    filtroKmFinal.isEmpty() ? 0 : Integer.parseInt(filtroKmFinal), 
                    filtroIdSuperintendencia, filtroIdUnidadeLocal);
        } catch(Exception ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar pontes." + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/buscarOAE.jsf");
    }
    
    public void limparFiltros() {
        filtroCodigo = "";
        filtroIdentificacao = "";
        filtroIdUf = 0;
        filtroIdVia = 0;
        filtroKmInicial = "";
        filtroKmFinal = "";
        filtroIdSuperintendencia = 0;
        filtroIdUnidadeLocal = 0;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Métodos getter e setter. ">    
    public String getFiltroCodigo() {
        return filtroCodigo;
    }

    public void setFiltroCodigo(String filtroCodigo) {
        this.filtroCodigo = filtroCodigo;
    }

    public String getFiltroIdentificacao() {
        return filtroIdentificacao;
    }

    public void setFiltroIdentificacao(String filtroIdentificacao) {
        this.filtroIdentificacao = filtroIdentificacao;
    }

    public int getFiltroIdUf() {
        return filtroIdUf;
    }

    public void setFiltroIdUf(int filtroIdUf) {
        this.filtroIdUf = filtroIdUf;
    }

    public int getFiltroIdVia() {
        return filtroIdVia;
    }

    public void setFiltroIdVia(int filtroIdVia) {
        this.filtroIdVia = filtroIdVia;
    }

    public String getFiltroKmInicial() {
        return filtroKmInicial;
    }

    public void setFiltroKmInicial(String filtroKmInicial) {
        this.filtroKmInicial = filtroKmInicial;
    }

    public String getFiltroKmFinal() {
        return filtroKmFinal;
    }

    public void setFiltroKmFinal(String filtroKmFinal) {
        this.filtroKmFinal = filtroKmFinal;
    }

    public int getFiltroIdSuperintendencia() {
        return filtroIdSuperintendencia;
    }

    public void setFiltroIdSuperintendencia(int filtroIdSuperintendencia) {
        this.filtroIdSuperintendencia = filtroIdSuperintendencia;
    }

    public Ponte getModel() {
        return model;
    }

    public void setModel(Ponte model) {
        this.model = model;
    }

    public ArrayList<Ponte> getPontes() {
        return pontes;
    }

    public void setPontes(ArrayList<Ponte> pontes) {
        this.pontes = pontes;
    }

    public ArrayList<Uf> getUfs() {
        return ufs;
    }

    public void setUfs(ArrayList<Uf> ufs) {
        this.ufs = ufs;
    }
    public int getFiltroIdUnidadeLocal() {
        return filtroIdUnidadeLocal;
    }

    public void setFiltroIdUnidadeLocal(int filtroIdUnidadeLocal) {
        this.filtroIdUnidadeLocal = filtroIdUnidadeLocal;
    }
    // </editor-fold>
}