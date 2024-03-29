/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.ElementoDAO;
import com.model.Elemento;
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
@ManagedBean(name = "capaElementos")
@SessionScoped
public class CapaElementosBean extends ComumBean {
    private ElementoDAO database;
    private ArrayList<Elemento> elementos;

    @PostConstruct
    public void init() {
        database = new ElementoDAO();
        try {
            elementos = database.buscar();
            for (int i = 0; i < elementos.size(); i++) {
                if (elementos.get(i).getCapa().equals("0")) {
                    adicionarMensagemInfo("elemento adicionado recentemente");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CapaElementosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvar() {
        for (int i = 0; i < elementos.size(); i++) {
            try {
                database.editar(elementos.get(i));
            } catch (SQLException ex) {
                Logger.getLogger(CapaElementosBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Métodos getter e setter. ">
    public ElementoDAO getDatabase() {
        return database;
    }

    public void setDatabase(ElementoDAO database) {
        this.database = database;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }
    // </editor-fold>
}