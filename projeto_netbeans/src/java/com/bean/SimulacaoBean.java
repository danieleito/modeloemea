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
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

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
    private PieChartModel pieModel;
    private PieChartModel pieModel2;
    private MapModel advancedModel;
    private Marker marker;

    @PostConstruct
    public void init() {
        database = new SimulacaoDAO();
        simulacao = null;

    }

//    início dos métodos para os gráficos
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();

        ChartSeries pontes = new ChartSeries();
        
        if (simulacao != null) {
            if (simulacao.getRankings() != null) {
                int t = simulacao.getRankings().size();

                for (int i = 0; i < t; i++) {
                    String nomePonte = simulacao.getRankings().get(i).getPonte().getIdentificacaoObraDadosBasicos().getIdentificacao();
                    int indicePerformanceRelativo = Integer.parseInt(simulacao.getRankings().get(i).getPonte().getIndicePerformanceRelativo());
                    pontes.set(nomePonte, indicePerformanceRelativo);
                }
                model.addSeries(pontes);
            }
        }

        return model;
    }

    private void createBarModel() {
        barModel = initBarModel();

        barModel.setTitle("Ranqueamento");
//        barModel.setLegendPosition("w");
//        barModel.setLegendPlacement(LegendPlacement.OUTSIDE);

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("OAEs");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Índice de performance relativo");
        yAxis.setMin(0);
//        yAxis.setMax(10);
    }
///////////////////////////////////////
 
//    @PostConstruct
//    public void init() {
//        createPieModels();
//    }
     
    private void createPieModels() {
        createPieModel();
//        createPieModel2();
    }
 
    private void createPieModel() {
        pieModel = new PieChartModel();
         
        if ( 1 == 1) {
            int t = 0;
            for (int i = 0; i < t; i++) {
                for (int j = 0; j < t; j++) {
                    
                }
                String manifestacao = "";
                Double porcentagem = 0.0;
                pieModel.set(manifestacao, porcentagem);
            }
        }
        
        pieModel.set("Carro", 540);
        pieModel.set("Ônibus", 325);
        pieModel.set("Metrô", 702);
        pieModel.set("Trem", 421);
         
        pieModel.setTitle("Meio de transporte");
        pieModel.setLegendPosition("s");
        
        
        
        
               
//        if (simulacao != null) {
//            if (simulacao.getRankings() != null) {
//                int t = simulacao.getRankings().size();
//
//                for (int i = 0; i < t; i++) {
//                    String nomePonte = simulacao.getRankings().get(i).getPonte().getIdentificacaoObraDadosBasicos().getIdentificacao();
//                    int indicePerformanceRelativo = Integer.parseInt(simulacao.getRankings().get(i).getPonte().getIndicePerformanceRelativo());
//                    pontes.set(nomePonte, indicePerformanceRelativo);
//                }
//                model.addSeries(pontes);
//            }
//        }

    }
     
//    private void createPieModel2() {
//        pieModel2 = new PieChartModel();
//         
//        pieModel2.set("Brand 5", 540);
//        pieModel2.set("Brand 6", 325);
//        pieModel2.set("Brand 7", 702);
//        pieModel2.set("Brand 8", 421);
//         
//        pieModel2.setTitle("Custom Pie");
//        pieModel2.setLegendPosition("ne");
//        pieModel2.setFill(false);
//        pieModel2.setShowDataLabels(true);
//        pieModel2.setDiameter(150);
//    }

//    fim métodos para gráficos
    
//    início métodos para mapa
    public void carregarMapa() {
        advancedModel = new DefaultMapModel();
        //Shared coordinates
        LatLng coord1 = new LatLng(36.879466, 30.667648);
        LatLng coord2 = new LatLng(36.883707, 30.689216);
        LatLng coord3 = new LatLng(36.879703, 30.706707);
        LatLng coord4 = new LatLng(36.885233, 30.702323);
          
        //Icons and Data
        advancedModel.addOverlay(new Marker(coord1, "Konyaalti", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
        advancedModel.addOverlay(new Marker(coord2, "Ataturk Parki", "ataturkparki.png"));
        advancedModel.addOverlay(new Marker(coord4, "Kaleici", "kaleici.png", "http://maps.google.com/mapfiles/ms/micons/pink-dot.png"));
        advancedModel.addOverlay(new Marker(coord3, "Karaalioglu Parki", "karaalioglu.png", "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));
        
    }
    
    public MapModel getAdvancedModel() {
        return advancedModel;
    }
      
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }
      
    public Marker getMarker() {
        return marker;
    }
    
//    fim métodos para mapa

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
            createBarModel();
            createPieModel();
            carregarMapa();
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
    
    public PieChartModel getPieModel() {
        return pieModel;
    }
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
    // </editor-fold>

    
}