/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.ArquivoAnexoDAO;
import com.model.ArquivoAnexoCadastro;
import com.model.ArquivoAnexoInspecao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Daniele Harumi Ito
 */
@ManagedBean(name = "arquivoAnexo")
@SessionScoped
public class ArquivoAnexoBean extends ComumBean {
    private ArquivoAnexoDAO databaseC;
    private ArquivoAnexoDAO databaseI;
    private ArrayList<ArquivoAnexoCadastro> arquivosCadastro;
    private ArrayList<ArquivoAnexoInspecao> arquivosInspecao;

    public ArquivoAnexoDAO getDatabaseC() {
        return databaseC;
    }

    public void setDatabaseC(ArquivoAnexoDAO databaseC) {
        this.databaseC = databaseC;
    }

    public ArquivoAnexoDAO getDatabaseI() {
        return databaseI;
    }

    public void setDatabaseI(ArquivoAnexoDAO databaseI) {
        this.databaseI = databaseI;
    }


    public ArrayList<ArquivoAnexoCadastro> getArquivosCadastro() {
        return arquivosCadastro;
    }

    public void setArquivosCadastro(ArrayList<ArquivoAnexoCadastro> arquivosCadastro) {
        this.arquivosCadastro = arquivosCadastro;
    }

    public ArrayList<ArquivoAnexoInspecao> getArquivosInspecao() {
        return arquivosInspecao;
    }

    public void setArquivosInspecao(ArrayList<ArquivoAnexoInspecao> arquivosInspecao) {
        this.arquivosInspecao = arquivosInspecao;
    }

    @PostConstruct
    public void init() {
        databaseC = new ArquivoAnexoDAO();
        databaseI = new ArquivoAnexoDAO();
        try {
            arquivosCadastro = databaseC.buscarCadastros(1);
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoAnexoBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar arquivos anexos de cadastro. " + ex.getMessage());
        }
        
        try {
            arquivosInspecao = databaseI.buscarInspecoes(1);
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoAnexoBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar arquivos anexos de inspeção. " + ex.getMessage());
        }
    }
    
    public void baixar() {
        
    }
}
