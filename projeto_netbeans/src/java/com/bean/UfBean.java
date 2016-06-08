/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.UfDAO;
import com.model.Uf;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author Daniele Harumi Ito
 */
@SessionScoped
@Named("ufBean")
public class UfBean extends ComumBean implements Serializable {
    private Uf model;
    private UfDAO database;
    private ArrayList<Uf> listaUfs;

    public UfBean() {
        database = new UfDAO();
        model = new Uf();
        try {
            listaUfs = new UfDAO().buscar();
        } catch (SQLException ex) {
            Logger.getLogger(UfBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cadastrar() {
        model = new Uf();
        redirecionar("/View/Compartilhado/buscarOAE.jsf");
    }
    
}
