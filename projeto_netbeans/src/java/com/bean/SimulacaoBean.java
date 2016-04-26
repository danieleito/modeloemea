 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.SimulacaoDAO;
import com.model.Simulacao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniele Harumi Ito
 */
@ManagedBean(name = "simulacao")
@SessionScoped
public class SimulacaoBean extends ComumBean {
    
    private Simulacao novaSimulacao;
    private SimulacaoDAO database;
    private ArrayList<Simulacao> simulacoes;

    public Simulacao getNovaSimulacao() {
        return novaSimulacao;
    }

    public void setNovaSimulacao(Simulacao novaSimulacao) {
        this.novaSimulacao = novaSimulacao;
    }

    public ArrayList<Simulacao> getSimulacoes() {
        return simulacoes;
    }

    public void setSimulacoes(ArrayList<Simulacao> simulacoes) {
        this.simulacoes = simulacoes;
    }
    
    public SimulacaoBean() {
        novaSimulacao = new Simulacao();
        novaSimulacao.setUsuario(usuarioLogado);
        novaSimulacao.setData(new Date());
        
        database = new SimulacaoDAO();
        try {
            simulacoes = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
            simulacoes = new ArrayList<>();
            adicionarMensagemErro("Erro ao carregar simulações.");
        }
    }
    
    public void salvar() {
        try {
            if (novaSimulacao.getSimulacao() == null || novaSimulacao.getSimulacao().isEmpty()) {
                adicionarMensagemErro("Campo 'Nome da simulação' é obrigatório.");
            } 
            //verificar se ja existe uma simulacao com esse nome
            else {
                database.inserir(novaSimulacao);
                simulacoes = database.buscar();
                adicionarMensagemInfo("Simulação cadastrada com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao cadastrar simulação: " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/simulacao.jsf");
    }
    
    public void visualizar(int id) {
        String x = String.valueOf(id);
        int i = id;
        x = "";
    }
    
    public void ranking(int id) {
        
    }
    
    public void deletar(int id) {
        try {
            database.excluir(id);
            adicionarMensagemInfo("Simulação removida com sucesso.");
            simulacoes = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao remover simulação: " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/simulacao.jsf");
    }
    
}
