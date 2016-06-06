/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.PonteDAO;
import com.model.Ponte;
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
@ManagedBean(name = "ponte")
@SessionScoped
public class PonteBean extends ComumBean {
    private Ponte model;
    private PonteDAO database;
    private ArrayList<Ponte> pontes;

    public Ponte getModel() {
        return model;
    }

    public void setModel(Ponte model) {
        this.model = model;
    }

    public PonteDAO getDatabase() {
        return database;
    }

    public void setDatabase(PonteDAO database) {
        this.database = database;
    }

    public ArrayList<Ponte> getPontes() {
        return pontes;
    }

    public void setPontes(ArrayList<Ponte> pontes) {
        this.pontes = pontes;
    }
    
    public PonteBean() {
        database = new PonteDAO();
        model = new Ponte();
        try {
            pontes = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            pontes = new ArrayList<>();
            adicionarMensagemErro("Erro ao carregar pontes.");
        }
    }
    
    public void cancelar() {
        redirecionar("/View/Compartilhado/Ranking/editar.jsf");
    }
    
    public void visualizar(int id) {
        //visualiza ponte do 'id'
    }
    
    public void carregar(int id) {
        //carregar ponte na tabela ranking
    }

    
    public void consultar() throws SQLException {
        String codigo = model.getCodigo();
        String identificacao = model.getIdentificacaoObra();
        String localVia = model.getLocalVia();
        String uf = model.getUf();
        String via = model.getVia();
 
        //database.buscar(codigo);
        pontes = database.buscar2(model.getCodigo(), model.getIdentificacaoObra(), model.getUf(), model.getVia(), model.getLocalVia(), "", "");
        
        redirecionar("/View/Compartilhado/buscarOAE.jsf");
    }

    private void buscarCodigo(String codigo) {
        //busca se existe 'codigo' no bd, caso exista insere na grid
    }

    private void buscarIdentificacao(String identificacao) {
        //busca se existe 'identificacao' no bd, caso exista insere na grid
    }

    private void buscarLocalVia(String localVia) {
        //busca se existe 'localVia' no bd, caso exista insere na grid
    }

    private void buscarUf(String uf) {
        //busca se existe 'uf' no bd, caso exista insere na grid
    }

    private void buscarVia(String via) {
        //busca se existe 'via' no bd, caso exista insere na grid
    }
}