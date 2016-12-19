/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relatorio;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.bean.ComumBean;
import com.dao.PonteDAO;
import com.model.Ponte;
import com.relatorio.ponte.RelatorioPonteGenerator;

/**
 *
 * @author Daniele Harumi Ito
//TODO: FAZER MODAL
//TODO: ARRUMAR ESCOPO
 */
@ManagedBean(name = "relatorioBean")
@ApplicationScoped
public class RelatorioBean extends ComumBean implements Serializable{
    
    private String relatorios_path;
    private Ponte ponte;
    private boolean cadastro;
    private boolean fotos_cadastrais;
    private String inspecao;
    private String fotos_inspecao;
    
    
            	
    public boolean getCadastro() {
		return cadastro;
	}


	public void setCadastro(boolean cadastro) {
		this.cadastro = cadastro;
	}


	public boolean getFotos_cadastrais() {
		return fotos_cadastrais;
	}


	public void setFotos_cadastrais(boolean fotos_cadastrais) {
		this.fotos_cadastrais = fotos_cadastrais;
	}


	public String getInspecao() {
		return inspecao;
	}


	public void setInspecao(String inspecao) {
		this.inspecao = inspecao;
	}


	public String getFotos_inspecao() {
		return fotos_inspecao;
	}


	public void setFotos_inspecao(String fotos_inspecao) {
		this.fotos_inspecao = fotos_inspecao;
	}


	public void setPonte(Ponte ponte) {
		this.ponte = ponte;
		System.out.println("I'm here!2");
	}


	public RelatorioBean() {
        relatorios_path = System.getProperty("jboss.server.data.dir") + File.separatorChar + "relatorios";
    }
    
    
    public void gerarCadastroInspecao(){
        try {
        	System.out.println("I'm here!");
        	try {
        		//TODO: Fazer a ponte já conter todos os dados necessário p/ não precisar fazer a busca novamente
        		this.ponte = new PonteDAO().buscar(ponte.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RelatorioPonteGenerator.generatePdf(ponte, relatorios_path + File.separatorChar + RelatorioPonteGenerator.getUniqueFileName()+ ".pdf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    /*private void imprimir(){
        try {
            RelatorioPonteGenerator.generatePdf(ponte, relatorios_path);
        } catch (IOException ex) {
            Logger.getLogger(RelatorioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    
}
