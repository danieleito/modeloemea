/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.ElementosDAO;
import com.model.Elemento;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniele Harumi Ito
 */
@ManagedBean(name = "capaElementos")
@SessionScoped
public class CapaElementosBean extends ComumBean {
    
    private ElementosDAO database;
    private ArrayList<Elemento> elementos;

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    public CapaElementosBean() {
        database = new ElementosDAO();
        //elementos = database.buscar();
    }
    
    public void salvar() {
        for (int i = 0; i < elementos.size(); i++) {
            //database.editar(elementos.get(i));
        }
    }
}