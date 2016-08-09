/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.InspecaoDAO;
import com.model.Inspecao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniele Harumi Ito
 */
@ManagedBean(name = "inspecaobean")
@SessionScoped
public class InspecaoBean extends ComumBean {
    private Inspecao model;
    private InspecaoDAO database;
    private ArrayList<Inspecao> inspecoes;

    @PostConstruct
    public void init() {
        database = new InspecaoDAO();
    }
    
    public void visualizar(int id) {
        try {
            model = database.buscar(id);
            redirecionar("/View/Compartilhado/visualizarInspecao.jsf");
        } catch (SQLException ex) {
            Logger.getLogger(InspecaoBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar inspeçõess.");
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Métodos getter e setter. ">
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
    // </editor-fold>
}
