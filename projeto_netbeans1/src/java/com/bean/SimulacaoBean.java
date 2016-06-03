 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.RankingDAO;
import com.dao.SimulacaoDAO;
import com.model.Ranking;
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
    private RankingDAO databaseR;
    private ArrayList<Simulacao> simulacoes;
    private ArrayList<Ranking> rankings;

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

    public ArrayList<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(ArrayList<Ranking> rankings) {
        this.rankings = rankings;
    }

    public SimulacaoDAO getDatabase() {
        return database;
    }

    public void setDatabase(SimulacaoDAO database) {
        this.database = database;
    }

    public RankingDAO getDatabaseR() {
        return databaseR;
    }

    public void setDatabaseR(RankingDAO databaseR) {
        this.databaseR = databaseR;
    }
    
    public SimulacaoBean() {
        novaSimulacao = new Simulacao();
        novaSimulacao.setUsuario(usuarioLogado);
        novaSimulacao.setData(new Date());
        
        database = new SimulacaoDAO();
        databaseR = new RankingDAO();
        try {
            simulacoes = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
            simulacoes = new ArrayList<>();
            System.out.println(ex.getMessage());
            adicionarMensagemErro("Erro ao carregar simulações.");
        }
        
        try {
            rankings = databaseR.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
            simulacoes = new ArrayList<>();
            adicionarMensagemErro("Erro ao carregar Ranking.");
        }
    }
    
    public void salvar() {
        try {
            if (novaSimulacao.getNomeSimulacao() == null || novaSimulacao.getNomeSimulacao().isEmpty()) {
                adicionarMensagemErro("Campo 'Nome da simulação' é obrigatório.");
                return;
            } 
            //verificar se ja existe uma simulacao com esse nome
            for (int i = 0; i < simulacoes.size(); i++) {
                if (novaSimulacao.getNomeSimulacao().equals(simulacoes.get(i).getNomeSimulacao())) {
                    adicionarMensagemErro("Nome de simulação já existe.");
                    return;
                }
            }
//            else {
                database.inserir(novaSimulacao);
                simulacoes = database.buscar();
                adicionarMensagemInfo("Simulação cadastrada com sucesso.");
                novaSimulacao.setNomeSimulacao("");//
//            }
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
        novaSimulacao.setNomeSimulacao("");//
        redirecionar("/View/Compartilhado/Ranking/visualizar.jsf?id=sim.id");
    }
    
    public void ranking(int id) {
        Simulacao simulacao;
        try {
            //depois é bom mudar o nome disso, mas a ideia é essa:
            novaSimulacao = database.buscar(id);
            //tem que usar essa simulação que buscou, e mostrar a lista de rankings
            novaSimulacao.setNomeSimulacao("");//
            redirecionar("/View/Compartilhado/Ranking/editar.jsf?id=sim.id");
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void visualizarRanking(int id){
        redirecionar("/View/Compartilhado/exibir.jsf?id=sim.id");
    }

    //retira ponte da simulação
    public void retirar(int id) {
        try {
            database.excluir(id);
            adicionarMensagemInfo("Ponte removida da simulação com sucesso.");
            simulacoes = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao remover ponte da simulação: " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/Ranking/editar.jsf");
    }

    public Simulacao nomeSimulacao() {
        Simulacao simulacao = new Simulacao();
        simulacao.getNomeSimulacao();
        return simulacao;
    }
    
    public void consultar() {
        redirecionar("View/Compartilhado/buscarOAE.jsf");
    }
}