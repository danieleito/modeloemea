 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.SimulacaoDAO;
import com.model.Simulacao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Daniele Harumi Ito
 */
@ManagedBean(name = "simulacaoBean")
@SessionScoped
public class SimulacaoBean extends ComumBean implements Serializable {

    private Simulacao simulacao;
    private SimulacaoDAO database;
    private ArrayList<Simulacao> simulacoes;
    
    private BarChartModel barModel;

    @PostConstruct
    public void init() {
        database = new SimulacaoDAO();

        createBarModels();
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();

        ChartSeries pontes = new ChartSeries();
        pontes.setLabel("");
//        for (int i = 0; i < model.) {
            
//        }
        pontes.set("2004", 120);
        pontes.set("2005", 100);
        pontes.set("2006", 44);
        pontes.set("2007", 150);
        pontes.set("2008", 25);

        model.addSeries(pontes);

        return model;
    }

    private void createBarModels() {
        createBarModel();
    }

    private void createBarModel() {
        barModel = initBarModel();

        barModel.setTitle("Ranqueamento");
        barModel.setLegendPosition("ne");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Pontes");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Índice de performance relativo");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }




    public void listarGet() {
        try {
            simulacao = new Simulacao();
            simulacoes = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
            simulacoes = new ArrayList<>();
            System.out.println(ex.getMessage());
            adicionarMensagemErro("Erro ao carregar simulações. " + ex.getMessage());
        }

        redirecionar("/View/Compartilhado/Simulacao/listar.jsf");
    }

    public void salvar() {
        try {
            if (simulacao.getNomeSimulacao() == null || simulacao.getNomeSimulacao().isEmpty()) {
                adicionarMensagemErro("Campo 'Nome da simulação' é obrigatório.");
                return;
            } 
            //verificar se ja existe uma simulacao com esse nome
            for (int i = 0; i < simulacoes.size(); i++) {
                if (simulacao.getNomeSimulacao().equals(simulacoes.get(i).getNomeSimulacao())) {
                    adicionarMensagemErro("Nome de simulação já existe.");
                    return;
                }
            }

            simulacao.setUsuario(usuarioLogado);
            simulacao.setData(new Date());
//            else {
                database.inserir(simulacao);
                simulacoes = database.buscar();
                adicionarMensagemInfo("Simulação cadastrada com sucesso.");
                simulacao.setNomeSimulacao("");//
//            }
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao cadastrar simulação: " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/Simulacao/listar.jsf");
    }

    public void visualizar(int idSimulacao) {
        try {
            simulacao = database.buscar(idSimulacao);
        } catch (Exception ex) {
            adicionarMensagemErro("Erro ao carregar simulação. " + ex.getMessage());
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        redirecionar("/View/Compartilhado/Simulacao/visualizar.jsf");
    }

    public void rankingGet(int idSimulacao) {
        try {
            simulacao = database.buscar(idSimulacao);
        } catch (SQLException ex) {
            adicionarMensagemErro("Erro ao listar rankings: " + ex.getMessage());
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        redirecionar("/View/Compartilhado/Simulacao/ranking.jsf");
    }

    //método executar ao carregar a view ranking
    public void recarregarSimulacao() {
        try {
            if (simulacao != null) {
                simulacao = database.buscar(simulacao.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //remove a ponte da simulação
    public void excluirRanking(int idRanking) {
        try {
            database.excluirRanking(idRanking);
            adicionarMensagemInfo("Ponte removida da simulação com sucesso.");
            //simulacoes = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao remover ponte da simulação: " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/Simulacao/ranking.jsf");
    }

    //excluir simulação do banco
    public void excluir(int id) {
        try {
            database.excluir(id);
            adicionarMensagemInfo("Simulação removida com sucesso.");
            simulacoes = database.buscar();
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao remover simulação: " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/Simulacao/listar.jsf");
    }

    // <editor-fold defaultstate="collapsed" desc=" Métodos getter e setter. ">
    public Simulacao getSimulacao() {
        return simulacao;
    }

    public void setSimulacao(Simulacao simulacao) {
        this.simulacao = simulacao;
    }

    public ArrayList<Simulacao> getSimulacoes() {
        return simulacoes;
    }

    public void setSimulacoes(ArrayList<Simulacao> simulacoes) {
        this.simulacoes = simulacoes;
    }
    
    
    
    
    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
    // </editor-fold>

    
}