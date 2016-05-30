/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.ManifestacaoDAO;
import com.model.Manifestacao;
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
@ManagedBean(name = "betaManifestacoes")
@SessionScoped
public class BetaManifestacoesBean extends ComumBean {
    private ManifestacaoDAO database;
    private ArrayList<Manifestacao> manifestacoes;

    public ManifestacaoDAO getDatabase() {
        return database;
    }

    public void setDatabase(ManifestacaoDAO database) {
        this.database = database;
    }

    public ArrayList<Manifestacao> getManifestacoes() {
        return manifestacoes;
    }

    public void setManifestacoes(ArrayList<Manifestacao> manifestacoes) {
        this.manifestacoes = manifestacoes;
    }

    public BetaManifestacoesBean() {
        database = new ManifestacaoDAO();
        try {
            manifestacoes = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(BetaManifestacoesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvar() {
        for (int i = 0; i < manifestacoes.size(); i++) {
            try {
                database.editar(manifestacoes.get(i));
            } catch (SQLException ex) {
                Logger.getLogger(BetaManifestacoesBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}