 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.SimulacaoDAO;
import com.model.ArquivoAnexoCadastro;
import com.model.GraficoManifestacao;
import com.model.GraficoSistemaConstrutivo;
import com.model.GraficoTipoEstrutura;
import com.model.Simulacao;
import java.io.File;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
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
    private Marker marker;
    private MapModel advancedModel;
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
    private void createPieModels() {
        createPieModel1();
        createPieModel2();
        createPieModel3();

    }
//grafico para mostrar manifetacoes;
    private PieChartModel pieModel1;
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    private void createPieModel1() {
        pieModel1 = new PieChartModel();
        pieModel1.setTitle("Manifestações Patalógicas");
        pieModel1.setLegendPosition("e");
        pieModel1.setLegendCols(1);
        pieModel1.setLegendPlacement(LegendPlacement.INSIDE);

        try {
            ArrayList<GraficoManifestacao> dados = database.buscarGraficoManifestacoes(simulacao.getId());

            int i = 0;
            for (; i < 10 && i < dados.size(); i++) {
//                for (GraficoManifestacao d : dados) {
                    pieModel1.set(dados.get(i).getNome(), dados.get(i).getQtde());
//                }
            }
            int count = 0;
            for (; i < dados.size(); i++) {
                count+= dados.get(i).getQtde();
            }
            if (dados.size() > 10) {
                pieModel1.set("Outros", count);
            }

//            for (GraficoManifestacao d : dados) {
//                pieModel1.set(d.getNome(), d.getQtde());
//            }
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//grafico para mostrar tipo estruturas;
    private PieChartModel pieModel2;
 
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
 
    private void createPieModel2() {
        pieModel2 = new PieChartModel();

        try {
            ArrayList<GraficoTipoEstrutura> dados = database.buscarGraficoTipoEstrutura(simulacao.getId());
            int i = 0;
            for (; i < 10 && i < dados.size(); i++) {
                pieModel2.set(dados.get(i).getNome(), dados.get(i).getQtde());
            }
            int count = 0;
            for (; i < dados.size(); i++) {
                count += dados.get(i).getQtde();
            }
            if (dados.size() > 10) {
                pieModel2.set("Outros", count);
            }
//            for (GraficoTipoEstrutura d : dados) {
//                pieModel2.set(d.getNome(), d.getQtde());
//            }
        }catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        pieModel2.setTitle("Tipo de estrutura");
        pieModel2.setLegendPosition("e");
        pieModel2.setLegendCols(1);
        pieModel2.setLegendPlacement(LegendPlacement.INSIDE);
    }
    
///////////////////////////////////////
//grafico para mostrar sistema construtivo;
    private PieChartModel pieModel3;
 
    public PieChartModel getPieModel3() {
        return pieModel3;
    }
 
    private void createPieModel3() {
        pieModel3 = new PieChartModel();

        try {
            ArrayList<GraficoSistemaConstrutivo> dados = database.buscarGraficoSistemaConstrutivo(simulacao.getId());
            int i = 0;
            for (; i < 10 && i < dados.size(); i++) {
                pieModel3.set(dados.get(i).getNome(), dados.get(i).getQtde());
            }
            int count = 0;
            for (; i < dados.size(); i++) {
                count += dados.get(i).getQtde();
            }
            if (dados.size() > 10) {
                pieModel3.set("Outros", count);
            }
//            for (GraficoSistemaConstrutivo d : dados) {
//                pieModel3.set(d.getNome(), d.getQtde());
//            }
        }catch (SQLException ex) {
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pieModel3.setTitle("Sistema construtivo");
        pieModel3.setLegendPosition("e");
        pieModel3.setLegendCols(1);
        pieModel3.setLegendPlacement(LegendPlacement.INSIDE);
    
    }
//    fim métodos para gráficos


//    início métodos para mapa
    public void carregarMapa() {
        advancedModel = new DefaultMapModel();
//        if (simulacao != null) {
            if (simulacao.getRankings() != null) {
                int t = simulacao.getRankings().size();

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
                    String codigo = simulacao.getRankings().get(i).getPonte().getIdentificacaoObraDadosBasicos().getCodigo();
                    String via = simulacao.getRankings().get(i).getPonte().getIdentificacaoObraLocalizacao().getVia().getDescricao();
                    String uf = simulacao.getRankings().get(i).getPonte().getIdentificacaoObraLocalizacao().getUf().getUf();
                    String imagem = "";

                    //arrumar issooo
                    if (simulacao.getRankings().get(i).getPonte().getArquivosAnexosCadastro() != null && 
                            simulacao.getRankings().get(i).getPonte().getArquivosAnexosCadastro().size() > 0) {
                        Optional<ArquivoAnexoCadastro> arq = simulacao.getRankings().get(i).getPonte().getArquivosAnexosCadastro().stream()
                                .filter(p -> p.getImagem().getNome().contains("geral")).findFirst();

                        imagem = simulacao.getRankings().get(i).getPonte().getIdentificacaoObraDadosBasicos().getCodigo();
                        imagem += File.separatorChar;
                        if (!arq.isPresent()) {
                            imagem += simulacao.getRankings().get(i).getPonte().getArquivosAnexosCadastro().get(0).getImagem().getNome();
                        } else {
                            imagem += arq.get().getImagem().getNome();
                        }
                    }
                    DecimalFormat df = new DecimalFormat("#.00");
                    String localVia = String.format("%.2f", simulacao.getRankings().get(i).getPonte().getIdentificacaoObraLocalizacao().getLocalVia());
                    advancedModel.addOverlay(new Marker(coord, nome, new String [] {nome, codigo, via, uf, localVia, imagem}, "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
                }
//            }
        }

//        for(Marker premarker : draggableModel.getMarkers()) {
//            premarker.setDraggable(true);
//        }
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
        int i = 0;
        i ++;
        try {
            simulacao = database.buscar(idSimulacao);
        } catch (Exception ex) {
            adicionarMensagemErro("Erro ao carregar simulação. " + ex.getMessage());
            Logger.getLogger(SimulacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        redirecionar("/View/Compartilhado/OAE/Simulacao/visualizar.jsf");
    }

    public void rankingGet(int idSimulacao) {
//        if (usuarioLogado.getId() == simulacao.getUsuario().getId()) {
//            adicionarMensagemInfo("conferir se usuaáio logado é o mesmo usuário dono da simulação");
//        }
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
            recarregarSimulacao();
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