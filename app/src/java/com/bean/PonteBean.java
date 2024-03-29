/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.AspectoEspecialDAO;
import com.dao.DeficienciaFuncionalDAO;
import com.dao.ElementoUfprDAO;
import com.dao.FotoDAO;
import com.dao.InspecaoManifestacaoElementoDAO;
import com.dao.ManifestacaoUfprDAO;
import com.dao.NaturezaTransposicaoDAO;
import com.dao.NumeroDAO;
import com.dao.PonteDAO;
import com.dao.RankingDAO;
import com.dao.SimulacaoDAO;
import com.dao.SistemaConstrutivoDAO;
import com.dao.SuperintendenciaRegionalDAO;
import com.dao.TipoEstruturaDAO;
import com.dao.TipoRegiaoDAO;
import com.dao.TipoTracadoDAO;
import com.dao.TremTipoDAO;
import com.dao.UfDAO;
import com.dao.UnidadeLocalDAO;
import com.dao.ViaDAO;
import com.model.ArquivoAnexoCadastro;
import com.model.AspectoEspecial;
import com.model.DeficienciaFuncional;
import com.model.ElementoComponente;
import com.model.ElementoUfpr;
import com.model.ExtensaoRelativa;
import com.model.Foto;
import com.model.Inspecao;
import com.model.InspecaoManifestacaoElemento;
import com.model.ManifestacaoUfpr;
import com.model.NaturezaTransposicao;
import com.model.Numero;
import com.model.Ponte;
import com.model.Reparo;
import com.model.Simulacao;
import com.model.SistemaConstrutivo;
import com.model.SuperintendenciaRegional;
import com.model.TipoAdministracao;
import com.model.TipoEstrutura;
import com.model.TipoRegiao;
import com.model.TipoTracado;
import com.model.TremTipo;
import com.model.Uf;
import com.model.UnidadeLocal;
import com.model.Via;
import java.io.File;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.LatLngBounds;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Rectangle;

/**
 *
 * @author Daniele Harumi Ito
 */
@ManagedBean(name="ponteBean")
@SessionScoped
public class PonteBean extends ComumBean implements Serializable {

    private Ponte model;
    private PonteDAO database;
    private ArrayList<Ponte> pontes;
    private ArrayList<Uf> ufs;
    private ArrayList<Via> vias;
    private ArrayList<SuperintendenciaRegional> superintendenciasRegionais;
    private ArrayList<UnidadeLocal> unidadesLocais;
    private ArrayList<Ponte> pontesSelecionadas;
    private ArrayList<Simulacao> simulacoes;
    private Simulacao modelSimulacao;

    //aba identificacao obra
    private ArrayList<NaturezaTransposicao> naturezasTransposicoes;
    private ArrayList<TipoEstrutura> tiposEstruturas;
    private ArrayList<SistemaConstrutivo> sistemasConstrutivos;
    private ArrayList<TremTipo> tremTipos;
//    private ArrayList<> cidadeMaisProxima;
//    private ArrayList<> ano;
//    private ArrayList<> versao;
//    private ArrayList<> codigo;
    private ArrayList<TipoAdministracao> tipoAdministracao;
//    private ArrayList<> localizacaoProjeto;
//    private ArrayList<> localizacaoDocumentosConstrucao;
//    private ArrayList<> localizacaoDocumentos;

    //aba caracteristicas funcionais
    private ArrayList<TipoRegiao> tiposRegioes;
    private ArrayList<TipoTracado> tiposTracados;
//    private ArrayList<> numeroFaixas;
//    private ArrayList<> larguraFaixas;
    // <editor-fold defaultstate="collapsed" desc=" Campos utilizados como filtro na busca por pontes. ">
    private String filtroCodigo;
    private String filtroIdentificacao;
    private int filtroIdUf;
    private int filtroIdVia;
    private String filtroKmInicial;
    private String filtroKmFinal;
    private int filtroIdSuperintendencia;
    private int filtroIdUnidadeLocal;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Campos utilizados como filtro na busca avançada por pontes. ">
    private int filtroIdNaturezaTransposicao;
    private int filtroIdTipoEstrutura;
    private int filtroIdSistemaConstrutivo;
    private String filtroComprimentoInicial;
    private String filtroComprimentoFinal;
    private String filtroLarguraInicial;
    private String filtroLarguraFinal;
    private int filtroIdAspectosEspeciais;
    private int filtroIdDeficienciasFuncionais;
    private int filtroIdMorfologia;
    private int filtroIdElementoUfpr;
    private int filtroIdManifestacaoUfpr;
    // </editor-fold>

    private ArrayList<ElementoUfpr> morfologias; 
    private ArrayList<ElementoUfpr> elementos;
    private ArrayList<ManifestacaoUfpr> manifestacoes;
//    private Tuple tupla;
//    tupla = new Tuple() {
//        @Override
//        public <X> X get(TupleElement<X> tupleElement) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public <X> X get(String alias, Class<X> type) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public Object get(String alias) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public <X> X get(int i, Class<X> type) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public Object get(int i) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public Object[] toArray() {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public List<TupleElement<?>> getElements() {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//    };

    //aba elementos componente
    private ArrayList<ElementoUfpr> elementosUfpr;

    //aba aspectos especiais
    private ArrayList<AspectoEspecial> aspectosEspeciais;

    //aba deficiencias funcionais
    private ArrayList<DeficienciaFuncional> deficienciasFuncionais;

    //inspecao  
    //aba Manifestacoes
    private ArrayList<ManifestacaoUfpr> manifestacoesUfpr;

    //combo numero
    private ArrayList<Numero> numeros;    

    //combo foto
    private ArrayList<Foto> fotos;

    //extensao relativa
    private ArrayList<ExtensaoRelativa> extensoesRelativa;

    //reparo
    private ArrayList<Reparo> reparos;

    private Inspecao inspecao;
    private ArrayList<Inspecao> inspecoes;

    //mapa
//    private MapModel draggableModel;
    private Marker marker;
    private String titulo;
    private MapModel rectangleModel;
    private MapModel advancedModel;
    
//    para mudar a aba da busca
    private int tab = 0;

    @PostConstruct
    public void init() {
        database = new PonteDAO();
        model = new Ponte();
        modelSimulacao = new Simulacao();
        try {
            ufs = new UfDAO().buscar();
            vias = new ViaDAO().buscar();
            superintendenciasRegionais = new SuperintendenciaRegionalDAO().buscar();
            unidadesLocais = new UnidadeLocalDAO().buscar();

            //aba identificacao obra
            naturezasTransposicoes = new NaturezaTransposicaoDAO().buscar();
            tiposEstruturas = new TipoEstruturaDAO().buscar();
            sistemasConstrutivos = new SistemaConstrutivoDAO().buscar();
            tremTipos = new TremTipoDAO().buscar();
//            cidadeMaisProxima;
//            ano;
//            versao;
//            codigo;
//            tipoAdministracao = new TipoAdministracaoDAO().buscar();
//            localizacaoProjeto;
//            localizacaoDocumentosConstrucao;
//            localizacaoDocumentos;

            //aba caracteristicas funcionais
            tiposRegioes = new TipoRegiaoDAO().buscar();
            tiposTracados = new TipoTracadoDAO().buscar();
//            numeroFaixas;
//            LarguraFaixas;
//
//            morfologias = new ElementoUfprDAO().buscar();

            //aba elementos componentes
            elementosUfpr = new ElementoUfprDAO().buscar();

            //aba aspectos especiais
            aspectosEspeciais = new AspectoEspecialDAO().buscar();

            //aba deficiencias funcionais
            deficienciasFuncionais = new DeficienciaFuncionalDAO().buscar();

            //inspecao
            //aba Manifestacoes
            manifestacoesUfpr = new ManifestacaoUfprDAO().buscar();

            //combo numero
            numeros = new NumeroDAO().buscar();

            //combo foto
            fotos = new FotoDAO().buscar();

//            //extensao relativa
//            extensoesRelativa = new ExtensaoRelativaDAO().buscar();
//            
//            //reparo
//            reparos = new ReparoDAO().buscar();

            //mapa
            database = new PonteDAO();
            model = null;

        } catch (SQLException ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar campos da tela Consultar. " + ex);
        }
    }

    public void cancelar() {
        redirecionar("/View/Compartilhado/OAE/Simulacao/ranking.jsf");
    }

    public void visualizar(int id) {
        //visualiza ponte do 'id'
        try {
            model = database.buscar(id);
            redirecionar("/View/Compartilhado/visualizarInspecao.jsf");
        } catch (SQLException ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar inspeções.");
        }
    }

    public void carregar(int idSimulacao) {
        if (pontesSelecionadas.size() > 0) {
            try {
                int qtde = 0;
                RankingDAO db = new RankingDAO();
                for (int i = 0; i < pontesSelecionadas.size(); i++) {
    //                se ponte ainda nao esta na simulacao
    //                int esta = buscarPonteEmSimulacao(idSimulacao, pontesSelecionadas.get(i).getId());

                    if (!database.ponteEstaSimulacao(pontesSelecionadas.get(i).getId(), idSimulacao)) {
                        try{
                            db.inserir(pontesSelecionadas.get(i).getId(), idSimulacao);
                        } catch(SQLException ex){
                            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        qtde++;
                    }
                }
                if (qtde > 0) {
                    SimulacaoDAO dbSimulacao = new SimulacaoDAO();
                    dbSimulacao.atualizaDataSimulacao(idSimulacao);                    
                }
                adicionarMensagemInfo(qtde + " pontes adicionadas das "+pontesSelecionadas.size()+" selecionadas");

            } catch (SQLException ex) {
                Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
                adicionarMensagemErro("Erro ao carregar ponte no ranking. " + ex.getMessage());
            }
            redirecionar("/View/Compartilhado/OAE/Simulacao/ranking.jsf");
        } else {
            adicionarMensagemWarning("Nenhuma OAE foi selecionada.");
            redirecionar("/View/Compartilhado/OAE/buscarOAE.jsf");
        }
    }

    public void consultarGet(int idSimulacao) {
        try {
            SimulacaoDAO dbSimulacao = new SimulacaoDAO();
            modelSimulacao = dbSimulacao.buscar(idSimulacao);
            pontesSelecionadas = new ArrayList<>();

            limparFiltros();
            pontes = database.buscar();
            carregarMapa();
            retangulo();
//            carregarDetalhesPin();
            tab = 0;
        } catch (SQLException ex) {
            pontes = new ArrayList<>();
            adicionarMensagemErro("Erro ao carregar pontes. " + ex.getMessage());
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        redirecionar("/View/Compartilhado/OAE/buscarOAE.jsf");
    }

    public void consultarCadastroGet() {
        try {
            limparFiltros();
            pontes = database.buscar();
        } catch (SQLException ex) {
            pontes = new ArrayList<>();
            adicionarMensagemErro("Erro ao carregar pontes. " + ex.getMessage());
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        redirecionar("/View/Compartilhado/OAE/buscarOAECadastro.jsf");
    }

    public void consultarInspecaoGet() {
        try {
            limparFiltros();
            pontes = database.buscar();
        } catch (SQLException ex) {
            pontes = new ArrayList<>();
            adicionarMensagemErro("Erro ao carregar pontes. " + ex.getMessage());
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        redirecionar("/View/Compartilhado/OAE/buscarOAEInspecao.jsf");
    }

    public void consultarPost() throws SQLException {
        try {
            pontes = database.buscar2(filtroCodigo, filtroIdentificacao,
                    filtroIdUf, filtroIdVia, 
                    filtroKmInicial.isEmpty() ? 0 :Double.parseDouble(filtroKmInicial.replace(",", ".")), 
                    filtroKmFinal.isEmpty() ? 0 : Double.parseDouble(filtroKmFinal.replace(",", ".")), 
                    filtroIdSuperintendencia, filtroIdUnidadeLocal);
            carregarMapa();
            retangulo();
//            carregarDetalhesPin();
            tab = 0;
        } catch(Exception ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar pontes. " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/OAE/buscarOAE.jsf");
    }

    public void consultarCadastroPost() throws SQLException {
        try {
            pontes = database.buscar2(filtroCodigo, filtroIdentificacao,
                    filtroIdUf, filtroIdVia, 
                    filtroKmInicial.isEmpty() ? 0 :Double.parseDouble(filtroKmInicial.replace(",", ".")),
                    filtroKmFinal.isEmpty() ? 0 : Double.parseDouble(filtroKmFinal.replace(",", ".")), 
                    filtroIdSuperintendencia, filtroIdUnidadeLocal);
        } catch(Exception ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar pontes. " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/OAE/buscarOAECadastro.jsf");
    }

    public void consultarInspecaoPost() throws SQLException {
        try {
            pontes = database.buscar2(filtroCodigo, filtroIdentificacao,
                    filtroIdUf, filtroIdVia, 
                    filtroKmInicial.isEmpty() ? 0 :Double.parseDouble(filtroKmInicial.replace(",", ".")), 
                    filtroKmFinal.isEmpty() ? 0 : Double.parseDouble(filtroKmFinal.replace(",", ".")), 
                    filtroIdSuperintendencia, filtroIdUnidadeLocal);
        } catch(Exception ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar pontes. " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/OAE/buscarOAEInspecao.jsf");
    }

    public void consultarAvancadaPost() throws SQLException {
        try {
            pontes = database.buscaAvancada(filtroIdNaturezaTransposicao, filtroIdTipoEstrutura, filtroIdSistemaConstrutivo, 
                    filtroComprimentoInicial.isEmpty() ? 0 :Double.parseDouble(filtroComprimentoInicial.replace(",", ".")), 
                    filtroComprimentoFinal.isEmpty() ? 0 : Double.parseDouble(filtroComprimentoFinal.replace(",", ".")), 
                    filtroLarguraInicial.isEmpty() ? 0 :Double.parseDouble(filtroLarguraInicial.replace(",", ".")), 
                    filtroLarguraFinal.isEmpty() ? 0 : Double.parseDouble(filtroLarguraFinal.replace(",", ".")),
                    filtroIdAspectosEspeciais, filtroIdDeficienciasFuncionais, filtroIdMorfologia, filtroIdElementoUfpr, 
                    filtroIdManifestacaoUfpr, morfologias);
            
            carregarMapa();
//            retangulo();
//            carregarDetalhesPin();
            tab = 1;
            
        } catch(Exception ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar pontes. " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/OAE/buscarOAE.jsf");
    }

    public void novoRegistro() {
        try {
            redirecionar("/View/Compartilhado/OAE/Inspecao/inspecao.jsf");
        } catch (Exception ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro. " + ex.getMessage());
        }
    }

    public void limparFiltros() {
        filtroCodigo = "";
        filtroIdentificacao = "";
        filtroIdUf = 0;
        filtroIdVia = 0;
        filtroKmInicial = "";
        filtroKmFinal = "";
        filtroIdSuperintendencia = 0;
        filtroIdUnidadeLocal = 0;
        filtroIdNaturezaTransposicao = 0;
        filtroIdTipoEstrutura = 0;
        filtroIdSistemaConstrutivo = 0;
        filtroComprimentoInicial = "";
        filtroComprimentoFinal = "";
        filtroLarguraInicial = "";
        filtroLarguraFinal = "";
        filtroIdAspectosEspeciais = 0;
        filtroIdDeficienciasFuncionais = 0;
        filtroIdMorfologia = 0;
        filtroIdElementoUfpr = 0;
        filtroIdManifestacaoUfpr = 0;
        morfologias = new ArrayList<>();
    }

    public void exibir(int idPonte) {
        try {
            model = database.buscar(idPonte);
        } catch (Exception ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar ponte: " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/OAE/exibir.jsf");
    }

    public void cadastrar() {
        try {
            model = new Ponte();
            redirecionar("/View/Compartilhado/OAE/cadastrar.jsf");
        } catch (Exception ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar. " + ex.getMessage());
        }
    }

    public void visualizarInspecao(int id) {
        try {
            inspecao = model.getInspecoes().stream().filter(i -> i.getId() == id).findFirst().orElse(new Inspecao());
            calculaModeloEmea();
        } catch (Exception ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar inspeção. " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/visualizarInspecao.jsf");
    }



    //    início métodos para mapa
    public void carregarMapa() {
        advancedModel = new DefaultMapModel();
        double maiorLongitude = 0;
        double maiorLatitude = 0;
        if (pontes != null) {
            int t = pontes.size();

            for (int i= 0; i < t; i++) {
                //Shared coordinates
                double grau = Double.parseDouble(pontes.get(i).getIdentificacaoObraLocalizacao().getLatitudeGrau());
                double minuto = Double.parseDouble(pontes.get(i).getIdentificacaoObraLocalizacao().getLatitudeMinuto());
                double latitude;
                if (grau < 0) {
                    latitude = minuto/60 - grau;
                } else {
                    latitude = minuto/60 + grau;
                }
                
                grau = Double.parseDouble(pontes.get(i).getIdentificacaoObraLocalizacao().getLongitudeGrau());
                minuto = Double.parseDouble(pontes.get(i).getIdentificacaoObraLocalizacao().getLongitudeMinuto());
                double longitude;
                if (grau < 0) {
                    longitude = minuto/60 - grau;
                } else {
                    longitude = minuto/60 + grau;
                }

//                latitude e logitude transformado em valor negativo
                if (latitude > 0) {
                    latitude *= -1;
                }
                if (longitude > 0) {
                    longitude *= -1;
                }
                LatLng coord = new LatLng(latitude, longitude);

                //pega maior latitude e longitude
                if (longitude < maiorLongitude) {
                    maiorLongitude = longitude;
                }
                if (latitude < maiorLatitude) {
                    maiorLatitude = latitude;
                }

                //Draggable
                String nome = pontes.get(i).getIdentificacaoObraDadosBasicos().getIdentificacao();
                String codigo = pontes.get(i).getIdentificacaoObraDadosBasicos().getCodigo();
                String via = pontes.get(i).getIdentificacaoObraLocalizacao().getVia().getDescricao();
                String uf = pontes.get(i).getIdentificacaoObraLocalizacao().getUf().getUf();
                String imagem = "";
                if (pontes.get(i).getArquivosAnexosCadastro() != null && 
                        pontes.get(i).getArquivosAnexosCadastro().size() > 0) {
                    Optional<ArquivoAnexoCadastro> arq = pontes.get(i).getArquivosAnexosCadastro().stream()
                            .filter(p -> p.getImagem().getNome().contains("geral")).findFirst();
                    imagem = pontes.get(i).getIdentificacaoObraDadosBasicos().getCodigo();
                    imagem += File.separatorChar;
                    if (!arq.isPresent()) {
                        imagem += pontes.get(i).getArquivosAnexosCadastro().get(0).getImagem().getNome();
                    } else {
                        imagem += arq.get().getImagem().getNome();
                    }
                }
                DecimalFormat df = new DecimalFormat("#.00");
                String localVia = String.format("%.2f", pontes.get(i).getIdentificacaoObraLocalizacao().getLocalVia());

                String path = "";
                int idPonte = pontes.get(i).getId();
                if (modelSimulacao.getRankings().stream()
                        .filter(p -> p.getPonte().getId() == idPonte)
                        .findFirst()
                        .isPresent()) {
                    path = getImagePath("pin_sgo_hardblue.png");
                } else {
                    path = getImagePath("pin_sgo_hardred.png");
                }
                advancedModel.addOverlay(new Marker(coord, nome, new String [] {nome, codigo, via, uf, localVia, imagem}, path)); //pode ser o quarto de ultimo parametro, serve para mudar a cor do pin, "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"
            }
        }
//        for(Marker premarker : draggableModel.getMarkers()) {
//            premarker.setDraggable(true);
//        } 
    }

    public int exibirCheckBox(int idPonte) {
        int r = modelSimulacao.getRankings().stream()
                        .filter(p -> p.getPonte().getId() == idPonte)
                        .findFirst()
                        .isPresent() 
                ? 0 
                : 1;
        return r;
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

//   parametros         double latitude, double longitude
    public void retangulo() {
        double latitude = -23.49975;
        double longitude = -50.108916667;
        rectangleModel = new DefaultMapModel();

        //Shared coordinates
        LatLng ne = new LatLng(latitude, longitude);
        LatLng sw = new LatLng(36.885233, 30.702323);

        //Rectangle
        Rectangle rect = new Rectangle(new LatLngBounds(sw, ne));
        rect.setStrokeColor("#d93c3c");
        rect.setFillColor("#d93c3c");
        rect.setFillOpacity(0.5);
        rectangleModel.addOverlay(rect);
    }

    public MapModel getRectangleModel() {
        return rectangleModel;
    }

    public void onRectangleSelect(OverlaySelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Rectangle Selected", null));
    }

//    fim métodos para mapa


//    busca o numero de pontes que foi pesquisado na tela BuscarPonte
    public int numeroPontesBuscados(ArrayList pontes) {
        int numero = pontes.size();
        return numero;
    }

    public void visualizarFoto() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 340);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");

        RequestContext.getCurrentInstance().openDialog("viewCars", options, null);
    }

//    retorna o nome da pasta da inspecao
    public String nomePastaInspecao(int idPasta) {   
        String pasta = Integer.toString(idPasta);
        return pasta;
    }

    public double calculaValorDano(double beta, double capa1, double capa2, double capa3, double capa4) {
        double valorDano = beta * capa1 * capa2 * capa3 * capa4;

//        formata valorDano #.##
//        DecimalFormat formato = new DecimalFormat("#.##");      
//        valorDano = Double.valueOf(formato.format(valorDano));
        return valorDano;
    }

    public double calculaCapa3(String manifestacao, String elemento, ArrayList elementoComponentes, Inspecao inspecao) throws SQLException {
        ArrayList<InspecaoManifestacaoElemento> inspManiEle = new InspecaoManifestacaoElementoDAO().buscar(inspecao.getId()); 
        int count = 0;
        String quantidade = null;
        double capa3 = 0.0;
        for (int i = 0; i < inspManiEle.size(); i++) {
            InspecaoManifestacaoElemento ime = inspManiEle.get(i);
            String m = ime.getElementoUfprManifestacaoUfpr().getManifestacaoUfpr().getDescricao();
            String e = ime.getElementoUfprManifestacaoUfpr().getElementoUfpr().getDescricao();
            if (manifestacao.equals(m) && elemento.equals(e)) {
                count ++;
            }
        }
        for (int i = 0; i < elementoComponentes.size(); i++) {
            ElementoComponente eleComp = (ElementoComponente) elementoComponentes.get(i);
            if (eleComp.getElementoUfpr().getDescricao().equals(elemento)) {
                quantidade = eleComp.getQuantidade();
            }
        }
        double qtd = Integer.parseInt(quantidade);
        double limiteSuperior = count/qtd;

        if (limiteSuperior >= 0 && limiteSuperior <= 0.1) {
            capa3 = 0.5;
        } else if (limiteSuperior > 0.1 && limiteSuperior <= 0.25) {
            capa3 = 1.0;
        } else if (limiteSuperior > 0.25 && limiteSuperior <= 0.75) {
            capa3 = 1.5;
        } else if (limiteSuperior > 0.75 && limiteSuperior <= 1) {
            capa3 = 2.0;
        }
        return capa3;
    }

    public double somatorioValorDano() { 
        ArrayList<InspecaoManifestacaoElemento> distintos = new ArrayList<>();
        for (InspecaoManifestacaoElemento ime : inspecao.getInspecaoManifestacaoElemento()) {
            if (!estaNaLista(ime, distintos)) {
                distintos.add(ime);
            }
        }

        double somatorio = 0;
        for (InspecaoManifestacaoElemento ime : distintos) {
            somatorio += buscaMaiorValorDano(ime, inspecao.getInspecaoManifestacaoElemento());
        }
        return somatorio;
    }

    private void calculaModeloEmea() throws SQLException {
        for (int i = 0; i < inspecao.getInspecaoManifestacaoElemento().size(); i++) {
            InspecaoManifestacaoElemento ime = inspecao.getInspecaoManifestacaoElemento().get(i);

            double beta = ime.getElementoUfprManifestacaoUfpr().getManifestacaoUfpr().getBeta();
            double capa1 = ime.getElementoUfprManifestacaoUfpr().getElementoUfpr().getCapa1();
            double capa2 = ime.getDadosManifestacao().getManifestacaoExtensao().getCapa2();

            String manifestacao = ime.getElementoUfprManifestacaoUfpr().getManifestacaoUfpr().getDescricao();
            String elemento = ime.getElementoUfprManifestacaoUfpr().getElementoUfpr().getDescricao();
            ArrayList<ElementoComponente> elementosComponentes = model.getElementosComponentes();
            double capa3 = calculaCapa3(manifestacao, elemento, elementosComponentes, inspecao);
            ime.setCapa3(capa3);
            double capa4 = ime.getDadosManifestacao().getManifestacaoUrgencia().getCapa4();
            double valorDano = calculaValorDano(beta, capa1, capa2, ime.getCapa3(), capa4);
            ime.setValorDano(valorDano);
        }
        
        inspecao.setSomatorioValorDano(somatorioValorDano());
    }

    private boolean estaNaLista(InspecaoManifestacaoElemento ime, ArrayList<InspecaoManifestacaoElemento> lista) {
        for (InspecaoManifestacaoElemento i : lista) {
            String mI = i.getElementoUfprManifestacaoUfpr().getManifestacaoUfpr().getDescricao();
            String mIme = ime.getElementoUfprManifestacaoUfpr().getManifestacaoUfpr().getDescricao();
            String eI = i.getElementoUfprManifestacaoUfpr().getElementoUfpr().getDescricao();
            String eIme = ime.getElementoUfprManifestacaoUfpr().getElementoUfpr().getDescricao();
            if (mI.equals(mIme) && eI.equals(eIme)) {
                return true;
            }
        }
        return false;
    }

    private double buscaMaiorValorDano(InspecaoManifestacaoElemento ime, ArrayList<InspecaoManifestacaoElemento> lista) {
        double maior = -1;
        InspecaoManifestacaoElemento m = null;
        for (InspecaoManifestacaoElemento i : lista) {
            String mI = i.getElementoUfprManifestacaoUfpr().getManifestacaoUfpr().getDescricao();
            String mIme = ime.getElementoUfprManifestacaoUfpr().getManifestacaoUfpr().getDescricao();
            String eI = i.getElementoUfprManifestacaoUfpr().getElementoUfpr().getDescricao();
            String eIme = ime.getElementoUfprManifestacaoUfpr().getElementoUfpr().getDescricao();
            if (mI.equals(mIme) && eI.equals(eIme)) {
                if (i.getValorDano() > maior) {
                    maior = i.getValorDano();
                    m = i;
                }
            }
        }
        if (m != null) {
            m.setSomou(true);
        }
        return maior;
    }

    public void adicionarMorfologiaBusca() {
        // se nao foi selecionado nenhum item, nao faz nada
        if (filtroIdMorfologia == 0) {
            return;
        }
        // se item ja esta na lista, nao add
        if (morfologias.stream().filter(p -> p.getId() == filtroIdMorfologia).findFirst().isPresent()) {
            return;
        }
        
        Optional<ElementoUfpr> o = elementosUfpr.stream().filter(p -> p.getId() == filtroIdMorfologia).findFirst();
        if (o.isPresent()) {
            morfologias.add(o.get());
        }
        tab = 1;
        redirecionar("/View/Compartilhado/OAE/buscarOAE.jsf");
    }
    
    public void excluirMorfologiaBusca() {
        
    }
    
    public void adicionarElementoMorfologiaBusca() {
//        // se nao foi selecionado nenhum item em elementoUfpr e nenhum item em manifestacaoUfpr, nao faz nada
//        if (filtroIdElementoUfpr == 0 && filtroIdManifestacaoUfpr == 0) {
//            return;
//        }
//        // se os itens de elementoUfpr e manifestacaoUfpr ja estao na lista, nao add
//        if (elementosUfpr.stream().filter(p -> p.getId() == filtroIdElementoUfpr).findFirst().isPresent() && 
//                manifestacoesUfpr.stream().filter(p -> p.getId() == filtroIdManifestacaoUfpr).findFirst().isPresent()) {
//            return;
//        }
//        
//        Optional<ElementoUfpr> e = elementosUfpr.stream().filter(p -> p.getId() == filtroIdElementoUfpr).findFirst();
//        Optional<ManifestacaoUfpr> m = manifestacoesUfpr.stream().filter(p -> p.getId() == filtroIdManifestacaoUfpr).findFirst();
//        if (e.isPresent() && m.isPresent()) {
//            
//        }
        
    }
    
    
    // <editor-fold defaultstate="collapsed" desc=" Métodos getter e setter. ">    
    public String getFiltroCodigo() {
        return filtroCodigo;
    }

    public void setFiltroCodigo(String filtroCodigo) {
        this.filtroCodigo = filtroCodigo;
    }

    public String getFiltroIdentificacao() {
        return filtroIdentificacao;
    }

    public void setFiltroIdentificacao(String filtroIdentificacao) {
        this.filtroIdentificacao = filtroIdentificacao;
    }

    public int getFiltroIdUf() {
        return filtroIdUf;
    }

    public void setFiltroIdUf(int filtroIdUf) {
        this.filtroIdUf = filtroIdUf;
    }

    public int getFiltroIdVia() {
        return filtroIdVia;
    }

    public void setFiltroIdVia(int filtroIdVia) {
        this.filtroIdVia = filtroIdVia;
    }

    public String getFiltroKmInicial() {
        return filtroKmInicial;
    }

    public void setFiltroKmInicial(String filtroKmInicial) {
        this.filtroKmInicial = filtroKmInicial;
    }

    public String getFiltroKmFinal() {
        return filtroKmFinal;
    }

    public void setFiltroKmFinal(String filtroKmFinal) {
        this.filtroKmFinal = filtroKmFinal;
    }

    public int getFiltroIdSuperintendencia() {
        return filtroIdSuperintendencia;
    }

    public void setFiltroIdSuperintendencia(int filtroIdSuperintendencia) {
        this.filtroIdSuperintendencia = filtroIdSuperintendencia;
    }

    public Ponte getModel() {
        return model;
    }

    public void setModel(Ponte model) {
        this.model = model;
    }

    public ArrayList<Ponte> getPontes() {
        return pontes;
    }

    public void setPontes(ArrayList<Ponte> pontes) {
        this.pontes = pontes;
    }

    public ArrayList<Uf> getUfs() {
        return ufs;
    }

    public void setUfs(ArrayList<Uf> ufs) {
        this.ufs = ufs;
    }

    public ArrayList<Via> getVias() {
        return vias;
    }

    public void setVias(ArrayList<Via> vias) {
        this.vias = vias;
    }

    public ArrayList<SuperintendenciaRegional> getSuperintendenciasRegionais() {
        return superintendenciasRegionais;
    }

    public void setSuperintendenciasRegionais(ArrayList<SuperintendenciaRegional> superintendenciasRegionais) {
        this.superintendenciasRegionais = superintendenciasRegionais;
    }

    public ArrayList<UnidadeLocal> getUnidadesLocais() {
        return unidadesLocais;
    }

    public void setUnidadesLocais(ArrayList<UnidadeLocal> unidadesLocais) {
        this.unidadesLocais = unidadesLocais;
    }
        
    public int getFiltroIdUnidadeLocal() {
        return filtroIdUnidadeLocal;
    }

    public void setFiltroIdUnidadeLocal(int filtroIdUnidadeLocal) {
        this.filtroIdUnidadeLocal = filtroIdUnidadeLocal;
    }

    public ArrayList<NaturezaTransposicao> getNaturezasTransposicoes() {
        return naturezasTransposicoes;
    }

    public void setNaturezasTransposicoes(ArrayList<NaturezaTransposicao> naturezasTransposicoes) {
        this.naturezasTransposicoes = naturezasTransposicoes;
    }

    public ArrayList<TipoEstrutura> getTiposEstruturas() {
        return tiposEstruturas;
    }

    public void setTiposEstruturas(ArrayList<TipoEstrutura> tiposEstruturas) {
        this.tiposEstruturas = tiposEstruturas;
    }

    public ArrayList<SistemaConstrutivo> getSistemasConstrutivos() {
        return sistemasConstrutivos;
    }

    public void setSistemasConstrutivos(ArrayList<SistemaConstrutivo> sistemasConstrutivos) {
        this.sistemasConstrutivos = sistemasConstrutivos;
    }

    public ArrayList<TremTipo> getTremTipos() {
        return tremTipos;
    }

    public void setTremTipos(ArrayList<TremTipo> tremTipos) {
        this.tremTipos = tremTipos;
    }

    public ArrayList<TipoAdministracao> getTipoAdministracao() {
        return tipoAdministracao;
    }

    public void setTipoAdministracao(ArrayList<TipoAdministracao> tipoAdministracao) {
        this.tipoAdministracao = tipoAdministracao;
    }
    
    public ArrayList<TipoRegiao> getTiposRegioes() {
        return tiposRegioes;
    }

    public void setTiposRegioes(ArrayList<TipoRegiao> tiposRegioes) {
        this.tiposRegioes = tiposRegioes;
    }

    public ArrayList<TipoTracado> getTiposTracados() {
        return tiposTracados;
    }

    public void setTiposTracados(ArrayList<TipoTracado> tiposTracados) {
        this.tiposTracados = tiposTracados;
    }

    public ArrayList<ElementoUfpr> getMorfologias() {
        return morfologias;
    }

    public void setMorfologias(ArrayList<ElementoUfpr> morfologias) {
        this.morfologias = morfologias;
    }

    public ArrayList<ElementoUfpr> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<ElementoUfpr> elementos) {
        this.elementos = elementos;
    }

    public ArrayList<ManifestacaoUfpr> getManifestacoes() {
        return manifestacoes;
    }

    public void setManifestacoes(ArrayList<ManifestacaoUfpr> manifestacoes) {
        this.manifestacoes = manifestacoes;
    }

    public ArrayList<ElementoUfpr> getElementosUfpr() {
        return elementosUfpr;
    }

    public void setElementosUfpr(ArrayList<ElementoUfpr> elementosUfpr) {
        this.elementosUfpr = elementosUfpr;
    }

    public ArrayList<AspectoEspecial> getAspectosEspeciais() {
        return aspectosEspeciais;
    }

    public void setAspectosEspeciais(ArrayList<AspectoEspecial> aspectosEspeciais) {
        this.aspectosEspeciais = aspectosEspeciais;
    }
    
    public ArrayList<DeficienciaFuncional> getDeficienciasFuncionais() {
        return deficienciasFuncionais;
    }

    public void setDeficienciasFuncionais(ArrayList<DeficienciaFuncional> deficienciasFuncionais) {
        this.deficienciasFuncionais = deficienciasFuncionais;
    }
    
    public ArrayList<ManifestacaoUfpr> getManifestacoesUfpr() {
        return manifestacoesUfpr;
    }

    public void setManifestacoesUfpr(ArrayList<ManifestacaoUfpr> manifestacoesUfpr) {
        this.manifestacoesUfpr = manifestacoesUfpr;
    }

    public ArrayList<ExtensaoRelativa> getExtensoesRelativa() {
        return extensoesRelativa;
    }

    public void setExtensoesRelativa(ArrayList<ExtensaoRelativa> extensoesRelativa) {
        this.extensoesRelativa = extensoesRelativa;
    }

    public ArrayList<Reparo> getReparos() {
        return reparos;
    }

    public void setReparos(ArrayList<Reparo> reparos) {
        this.reparos = reparos;
    }
    
    public ArrayList<Numero> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Numero> numeros) {
        this.numeros = numeros;
    }

    public ArrayList<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<Foto> fotos) {
        this.fotos = fotos;
    }

    public ArrayList<Ponte> getPontesSelecionadas() {
        return pontesSelecionadas;
    }

    public void setPontesSelecionadas(ArrayList<Ponte> pontesSelecionadas) {
        this.pontesSelecionadas = pontesSelecionadas;
    }
    
    public ArrayList<Simulacao> getSimulacoes() {
        return simulacoes;
    }

    public void setSimulacoes(ArrayList<Simulacao> simulacoes) {
        this.simulacoes = simulacoes;
    }
    
    public Inspecao getInspecao() {
        return inspecao;
    }

    public void setInspecao(Inspecao inspecao) {
        this.inspecao = inspecao;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public ArrayList<Inspecao> getInspecoes() {
        return inspecoes;
    }

    public void setInspecoes(ArrayList<Inspecao> inspecoes) {
        this.inspecoes = inspecoes;
    }

    public int getFiltroIdNaturezaTransposicao() {
        return filtroIdNaturezaTransposicao;
    }

    public void setFiltroIdNaturezaTransposicao(int filtroIdNaturezaTransposicao) {
        this.filtroIdNaturezaTransposicao = filtroIdNaturezaTransposicao;
    }

    public int getFiltroIdTipoEstrutura() {
        return filtroIdTipoEstrutura;
    }

    public void setFiltroIdTipoEstrutura(int filtroIdTipoEstrutura) {
        this.filtroIdTipoEstrutura = filtroIdTipoEstrutura;
    }

    public int getFiltroIdSistemaConstrutivo() {
        return filtroIdSistemaConstrutivo;
    }

    public void setFiltroIdSistemaConstrutivo(int filtroIdSistemaConstrutivo) {
        this.filtroIdSistemaConstrutivo = filtroIdSistemaConstrutivo;
    }

    public String getFiltroComprimentoInicial() {
        return filtroComprimentoInicial;
    }

    public void setFiltroComprimentoInicial(String filtroComprimentoInicial) {
        this.filtroComprimentoInicial = filtroComprimentoInicial;
    }

    public String getFiltroComprimentoFinal() {
        return filtroComprimentoFinal;
    }

    public void setFiltroComprimentoFinal(String filtroComprimentoFinal) {
        this.filtroComprimentoFinal = filtroComprimentoFinal;
    }

    public String getFiltroLarguraInicial() {
        return filtroLarguraInicial;
    }

    public void setFiltroLarguraInicial(String filtroLarguraInicial) {
        this.filtroLarguraInicial = filtroLarguraInicial;
    }

    public String getFiltroLarguraFinal() {
        return filtroLarguraFinal;
    }

    public void setFiltroLarguraFinal(String filtroLarguraFinal) {
        this.filtroLarguraFinal = filtroLarguraFinal;
    }

    public int getFiltroIdAspectosEspeciais() {
        return filtroIdAspectosEspeciais;
    }

    public void setFiltroIdAspectosEspeciais(int filtroIdAspectosEspeciais) {
        this.filtroIdAspectosEspeciais = filtroIdAspectosEspeciais;
    }

    public int getFiltroIdDeficienciasFuncionais() {
        return filtroIdDeficienciasFuncionais;
    }

    public void setFiltroIdDeficienciasFuncionais(int filtroIdDeficienciasFuncionais) {
        this.filtroIdDeficienciasFuncionais = filtroIdDeficienciasFuncionais;
    }

    public int getFiltroIdMorfologia() {
        return filtroIdMorfologia;
    }

    public void setFiltroIdMorfologia(int filtroIdMorfologia) {
        this.filtroIdMorfologia = filtroIdMorfologia;
    }

    public int getFiltroIdElementoUfpr() {
        return filtroIdElementoUfpr;
    }

    public void setFiltroIdElementoUfpr(int filtroIdElementoUfpr) {
        this.filtroIdElementoUfpr = filtroIdElementoUfpr;
    }

    public int getFiltroIdManifestacaoUfpr() {
        return filtroIdManifestacaoUfpr;
    }

    public void setFiltroIdManifestacaoUfpr(int filtroIdManifestacaoUfpr) {
        this.filtroIdManifestacaoUfpr = filtroIdManifestacaoUfpr;
    }

    public int getTab() {
        return tab;
    }

    public void setTab(int tab) {
        this.tab = tab;
    }
    // </editor-fold>
}
