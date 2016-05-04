/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;
import com.dao.RankingDAO;
import com.model.Ranking;
import com.model.Simulacao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniele Harumi Ito
 */
@ManagedBean(name = "ranking")
@SessionScoped
public class RankingBean extends ComumBean {
    private RankingDAO database;
    private ArrayList<Ranking> rankings;

    public RankingDAO getDatabase() {
        return database;
    }

    public void setDatabase(RankingDAO database) {
        this.database = database;
    }

    public ArrayList<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(ArrayList<Ranking> rankings) {
        this.rankings = rankings;
    }
    
    public RankingBean() {
        database = new RankingDAO();
        try {
            rankings = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(RankingBean.class.getName()).log(Level.SEVERE, null, ex);
            rankings = new ArrayList<>();
            adicionarMensagemErro("Erro ao carregar ranking.");
        }
    }
    
    public void visualizar(int id){
        
    }
    
    //retira ponte da simulação
    public void retirar(int id) {
        try {
            database.excluir(id);
            adicionarMensagemInfo("Ponte removida da simulação com sucesso.");
            rankings = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(RankingBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao remover ponte da simulação: " + ex.getMessage());
        }
        redirecionar("/View/Compatilhado/Ranking/editar.jsf?id=sim.id");
    }
    
    public Simulacao nomeSimulacao() {
        Simulacao simulacao = new Simulacao();
        simulacao.getNomeSimulacao();
        return simulacao;
    }
}
