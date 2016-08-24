 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.PonteDAO;
import com.dao.SimulacaoDAO;
import com.model.GraficoManifestacao;
import com.model.Inspecao;
import com.model.InspecaoManifestacaoElemento;
import com.model.Ponte;
import com.model.Simulacao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
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
    private Marker marker;
    private MapModel draggableModel;
    private int lat;
    private int lgt;

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

    private PieChartModel pieModel1;
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    private void createPieModels() {
        createPieModel1();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();

        try {
            ArrayList<GraficoManifestacao> dados = database.buscarGraficoManifestacoes(simulacao.getId());
            int total = 0;
            total = dados.stream().map((d) -> d.getQtde()).reduce(total, Integer::sum);
            for (GraficoManifestacao d : dados) {
                pieModel1.set(d.getNome(), d.getQtde()/total);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        pieModel1.setTitle("Manifestações");
    }

//    fim métodos para gráficos
    
//    início métodos para mapa
    public void carregarMapa() {
        draggableModel = new DefaultMapModel();

        if (simulacao != null) {
            if (simulacao.getRankings() != null) {
                int t = simulacao.getRankings().size();
                
//                maiorLatitudeLongitude();
                for (int i= 0; i < t; i++) {
                    //Shared coordinates
                    Double grau = Double.parseDouble(simulacao.getRankings().get(i).getPonte().getIdentificacaoObraLocalizacao().getLatitudeGrau());
                    Double minuto = Double.parseDouble(simulacao.getRankings().get(i).getPonte().getIdentificacaoObraLocalizacao().getLatitudeMinuto());
                    Double latitude = minuto/60 + grau;
                    grau = Double.parseDouble(simulacao.getRankings().get(i).getPonte().getIdentificacaoObraLocalizacao().getLongitudeGrau());
                    minuto = Double.parseDouble(simulacao.getRankings().get(i).getPonte().getIdentificacaoObraLocalizacao().getLongitudeMinuto());
                    Double longitude = minuto/60 + grau;
                    if (latitude > 0) {
                        latitude *= -1;
                    }
                    if (longitude > 0) {
                        longitude *= -1;
                    }
                    LatLng coord = new LatLng(latitude, longitude);

                    //Draggable
                    String nome = simulacao.getRankings().get(i).getPonte().getIdentificacaoObraDadosBasicos().getIdentificacao();
                    draggableModel.addOverlay(new Marker(coord, nome));
                }
            }
        }

        for(Marker premarker : draggableModel.getMarkers()) {
            premarker.setDraggable(true);
        }
    }

    public MapModel getDraggableModel() {
        return draggableModel;
    }

    public void onMarkerDrag(MarkerDragEvent event) {
        marker = event.getMarker();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Dragged", "Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng()));
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

        redirecionar("/View/Compartilhado/OAE/Simulacao/listar.jsf");
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
        redirecionar("/View/Compartilhado/OAE/Simulacao/listar.jsf");
    }

    public void visualizar(int idSimulacao) {
        try {
            simulacao = database.buscar(idSimulacao);
        } catch (Exception ex) {
            adicionarMensagemErro("Erro ao carregar simulação. " + ex.getMessage());
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        redirecionar("/View/Compartilhado/OAE/Simulacao/visualizar.jsf");
    }

    public void rankingGet(int idSimulacao) {
        try {
            simulacao = database.buscar(idSimulacao);
            createBarModel();
            createPieModels();
            carregarMapa();
        } catch (SQLException ex) {
            adicionarMensagemErro("Erro ao listar rankings: " + ex.getMessage());
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        redirecionar("/View/Compartilhado/OAE/Simulacao/ranking.jsf");
    }

    //método executar ao carregar a view ranking
    public void recarregarSimulacao() {
        try {
            if (simulacao != null) {
                simulacao = database.buscar(simulacao.getId());
                createBarModel();
                createPieModels();
                carregarMapa();
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
        redirecionar("/View/Compartilhado/OAE/Simulacao/ranking.jsf");
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
        redirecionar("/View/Compartilhado/OAE/Simulacao/listar.jsf");
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

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLgt() {
        return lgt;
    }

    public void setLgt(int lgt) {
        this.lgt = lgt;
    }
    // </editor-fold>

    private void maiorLatitudeLongitude() {
//        int t = simulacao.getRankings().size();
//        int maiorLatitude = 0;
//        int maiorLongitude = 0;
//        int menorLatitude = 34;
//        int menorLongitude = 8;
//        for (int i = 0; i < t; i++) {
//            lat = Integer.parseInt(simulacao.getRankings().get(i).getPonte().getIdentificacaoObraLocalizacao().getLatitudeGrau());
//            if (maiorLatitude < lat) {
//                maiorLatitude = lat;
//            }
//            if (menorLatitude > latitude) {
//                latitude
//            }
//            lgt = Integer.parseInt(simulacao.getRankings().get(i).getPonte().getIdentificacaoObraLocalizacao().getLongitudeGrau());
//            if (maiorLongitude < lgt) {
//                maiorLongitude = lgt;
//            }
//        }
    }

    
}