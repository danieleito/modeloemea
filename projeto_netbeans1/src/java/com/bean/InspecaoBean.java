/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.InspecaoDAO;
import com.model.Inspecao;
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
@ManagedBean(name = "inspecao")
@SessionScoped
public class InspecaoBean extends ComumBean {
    private Inspecao model;
    private InspecaoDAO database;
    private ArrayList<Inspecao> inspecoes;

    public Inspecao getModel() {
        return model;
    }

    public void setModel(Inspecao model) {
        this.model = model;
    }

    public ArrayList<Inspecao> getInspecoes() {
        return inspecoes;
    }

    public void setInspecoes(ArrayList<Inspecao> inspecoes) {
        this.inspecoes = inspecoes;
    }
    
    public InspecaoBean() {
        database = new InspecaoDAO();
        model = new Inspecao();
        try {
            inspecoes = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(InspecaoBean.class.getName()).log(Level.SEVERE, null, ex);
            inspecoes = new ArrayList<>();
            adicionarMensagemErro("Erro ao carregar inspeções.");
        }
    }
    
    public void visualizar(int id) {
        Inspecao inspecao;
        try {
            inspecao = database.buscar(id);
            redirecionar("/View/Compartilhado/visualizarInspecao.jsf");
        } catch (SQLException ex) {
            Logger.getLogger(InspecaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
