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
import javax.inject.Named;

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
    private static int idSimulacao;

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

    public int getIdSimulacao() {
        return idSimulacao;
    }

    public void setIdSimulacao(int idSimulacao) {
        this.idSimulacao = idSimulacao;
    }
    
    /**
     * Constructor
     */
    public PonteBean() {
        database = new PonteDAO();
        model = new Ponte();
        try {
            ufs = new UfDAO().buscar();
            pontes = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            pontes = new ArrayList<>();
            adicionarMensagemErro("Erro ao carregar pontes. " + ex.getMessage());
        }
    }

    public void cancelar() {
        redirecionar("/View/Compartilhado/Ranking/editar.jsf");
    }
    
    public void visualizar(int id) {
        //visualiza ponte do 'id'
    }
    
    public void carregar(int idPonte, int idSimulacao) {
        try {            
            RankingDAO db = new RankingDAO();
            Ponte ponte = new Ponte();
            ponte.setId(idPonte);
            Ranking ranking = new Ranking();
            ranking.setPonte(ponte);
            ranking.setIdSimulacao(idSimulacao);
            db.inserir(ranking);
            //redirecionar("/View/Compartilhado/Ranking/editar.jsf");
            SimulacaoBean simulacao = new SimulacaoBean();
            simulacao.ranking(idSimulacao);
        } catch (SQLException ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar ponte no ranking." + ex.getMessage());
        }
    }
    
    public void consultar() throws SQLException {
        try {
            pontes = database.buscar2(model.getCodigo(), model.getIdentificacaoObra(), 
                    model.getUf().getId(), model.getIdVia(), model.getLocalVia(), 
                    model.getIdSuperintendenciaRegional(), model.getIdUnidadeLocal());

            redirecionar("/View/Compartilhado/buscarOAE.jsf");
        } catch(Exception ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar pontes." + ex.getMessage());
        }
    }
    
    public void consultarGet(int idSimulacao) {
        this.idSimulacao = idSimulacao;
        redirecionar("/View/Compartilhado/buscarOAE.jsf");
    }
}