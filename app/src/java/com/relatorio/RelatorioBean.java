/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relatorio;

import com.bean.*;
import com.dao.ArquivoAnexoDAO;
import com.model.ArquivoAnexoCadastro;
import com.model.ArquivoAnexoInspecao;
import com.model.ArquivoAnexoManifestacao;
import com.model.Ponte;
import com.relatorio.ponte.RelatorioPonteGenerator;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Daniele Harumi Ito
 */
@ManagedBean(name = "relatorioBean")
@ViewScoped
public class RelatorioBean implements Serializable{
    
    private String relatorios_path;
    private Ponte ponte;
            
    public RelatorioBean() {
        relatorios_path = System.getProperty("jboss.server.data.dir") + File.separatorChar + "relatorios";
    }
    
    
    public void selecionarOpcoes(Ponte ponte){
        this.ponte = ponte;
        imprimir();
        
    }
    
    private void imprimir(){
        try {
            RelatorioPonteGenerator.generatePdf(ponte, relatorios_path);
        } catch (IOException ex) {
            Logger.getLogger(RelatorioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
