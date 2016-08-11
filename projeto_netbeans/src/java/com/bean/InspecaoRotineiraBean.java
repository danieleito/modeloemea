/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.InspecaoRotineiraDAO;
import com.model.InspecaoRotineira;
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
@ManagedBean(name = "inspecaorotineirabean")
@SessionScoped
public class InspecaoRotineiraBean extends ComumBean {
    private InspecaoRotineira model;
    private InspecaoRotineiraDAO database;
    private ArrayList<InspecaoRotineira> inspecoesRotineiras;

    @PostConstruct
    public void init() {
        database = new InspecaoRotineiraDAO();
    }

//    metodos
    public void visualizar(int id) {
        try {
            model = database.buscar(id);
            redirecionar("/View/Compartilhado/visualizarInspecao.jsf");
        } catch (SQLException ex) {
            Logger.getLogger(InspecaoBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar inspeção.");
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Métodos getter e setter. ">
    public InspecaoRotineira getModel() {
        return model;
    }

    public void setModel(InspecaoRotineira model) {
        this.model = model;
    }

    public ArrayList<InspecaoRotineira> getInspecoesRotineiras() {
        return inspecoesRotineiras;
    }

    public void setInspecoesRotineiras(ArrayList<InspecaoRotineira> inspecoesRotineiras) {
        this.inspecoesRotineiras = inspecoesRotineiras;
    }
    // </editor-fold>
}
