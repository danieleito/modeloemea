/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relatorio;

import com.dao.PonteDAO;
import com.model.Ponte;
import com.relatorio.ponte.RelatorioPonteGenerator;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Usuario
 */
//TODO: Change scope
@Named(value = "relatorioBean")
@ApplicationScoped
public class RelatorioBean {

    /**
     * Creates a new instance of RelatorioBean
     */
    private Ponte ponte;
    private PonteDAO ponteDao;
   
    private String teste;
      
   
    public RelatorioBean() {
        teste = " ISSO É UM TESTE";
    }

    @PostConstruct
    public void init(){
        this.ponteDao = new PonteDAO();
        try {
            this.ponte = ponteDao.buscar(1);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            RelatorioPonteGenerator.generatePdf(ponte);
        } catch (IOException ex) {
            Logger.getLogger(RelatorioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }
    
    
    
}
