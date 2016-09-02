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
import com.dao.ManifestacaoUfprDAO;
import com.dao.NaturezaTransposicaoDAO;
import com.dao.NumeroDAO;
import com.dao.PonteDAO;
import com.dao.RankingDAO;
import com.dao.SistemaConstrutivoDAO;
import com.dao.SuperintendenciaRegionalDAO;
import com.dao.TipoEstruturaDAO;
import com.dao.TipoRegiaoDAO;
import com.dao.TipoTracadoDAO;
import com.dao.TremTipoDAO;
import com.dao.UfDAO;
import com.dao.UnidadeLocalDAO;
import com.dao.ViaDAO;
import com.model.AspectoEspecial;
import com.model.DeficienciaFuncional;
import com.model.ElementoUfpr;
import com.model.ExtensaoRelativa;
import com.model.Foto;
import com.model.Inspecao;
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
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

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
    
    //mapa
    private MapModel draggableModel;
    private Marker marker;
    private String titulo;
    
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
        redirecionar("/View/Compartilhado/Simulacao/ranking.jsf");
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
        try {
            int qtde = 0;
            RankingDAO db = new RankingDAO();
            for (int i = 0; i < pontesSelecionadas.size(); i++) {
//                se ponte ainda nao esta na simulacao
//                int esta = buscarPonteEmSimulacao(idSimulacao, pontesSelecionadas.get(i).getId());
//
                if (!database.ponteEstaSimulacao(pontesSelecionadas.get(i).getId(), idSimulacao)) {
                    db.inserir(pontesSelecionadas.get(i).getId(), idSimulacao);
                    qtde++;
                }
            }
            adicionarMensagemInfo(qtde + " pontes adicionadas das "+pontesSelecionadas.size()+" selecionadas");
        } catch (SQLException ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar ponte no ranking. " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/OAE/Simulacao/ranking.jsf");
    }
    
    public void consultarGet() {
        try {
            pontesSelecionadas = new ArrayList<>();
            limparFiltros();
            pontes = database.buscar();
            carregarMapa();
//            carregarDetalhesPin();
        } catch (SQLException ex) {
            pontes = new ArrayList<>();
            adicionarMensagemErro("Erro ao carregar pontess. " + ex.getMessage());
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
//            carregarDetalhesPin();
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
    }
    
    public void exibir(int idPonte) {
        try {
            model = database.buscar(idPonte);
        } catch (Exception ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar ponte. " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/OAE/exibir.jsf");
    }
    
    public void cadastrar() {
        try {
            redirecionar("/View/Compartilhado/OAE/cadastrar.jsf");
        } catch (Exception ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar. " + ex.getMessage());
        }
    }
    
    public void visualizarInspecao(int id) {
        try {
            inspecao = model.getInspecoes().stream().filter(i -> i.getId() == id).findFirst().orElse(new Inspecao());
        } catch (Exception ex) {
            Logger.getLogger(PonteBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagemErro("Erro ao carregar inspeção. " + ex.getMessage());
        }
        redirecionar("/View/Compartilhado/visualizarInspecao.jsf");
    }
    
    
    
    //    início métodos para mapa
    public void carregarMapa() {
        draggableModel = new DefaultMapModel();

        if (pontes != null) {
            int t = pontes.size();

            for (int i= 0; i < t; i++) {
                //Shared coordinates
                Double grau = Double.parseDouble(pontes.get(i).getIdentificacaoObraLocalizacao().getLatitudeGrau());
                Double minuto = Double.parseDouble(pontes.get(i).getIdentificacaoObraLocalizacao().getLatitudeMinuto());
                Double latitude = minuto/60 + grau;
                grau = Double.parseDouble(pontes.get(i).getIdentificacaoObraLocalizacao().getLongitudeGrau());
                minuto = Double.parseDouble(pontes.get(i).getIdentificacaoObraLocalizacao().getLongitudeMinuto());
                Double longitude = minuto/60 + grau;
                if (latitude > 0) {
                    latitude *= -1;
                }
                if (longitude > 0) {
                    longitude *= -1;
                }
                LatLng coord = new LatLng(latitude, longitude);

                //Draggable
                String nome = pontes.get(i).getIdentificacaoObraDadosBasicos().getIdentificacao();
                String codigo = pontes.get(i).getIdentificacaoObraDadosBasicos().getCodigo();
                String via = pontes.get(i).getIdentificacaoObraLocalizacao().getVia().getDescricao();
                String uf = pontes.get(i).getIdentificacaoObraLocalizacao().getUf().getUf();
                DecimalFormat df = new DecimalFormat("#.00"); 
                String localVia = String.format("%.2f", pontes.get(i).getIdentificacaoObraLocalizacao().getLocalVia());
                draggableModel.addOverlay(new Marker(coord, null, new String [] {nome, codigo, via, uf, localVia}));
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
    
    
    
    
    private MapModel advancedModel;
  
//    public void carregarDetalhesPin() {
//        advancedModel = new DefaultMapModel();
//          
//        //Shared coordinates
//        LatLng coord1 = new LatLng(36.879466, 30.667648);
//        LatLng coord2 = new LatLng(36.883707, 30.689216);
//        LatLng coord3 = new LatLng(36.879703, 30.706707);
//        LatLng coord4 = new LatLng(36.885233, 30.702323);
//          
//        //Icons and Data
//        advancedModel.addOverlay(new Marker(coord1, "Konyaalti", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
//        advancedModel.addOverlay(new Marker(coord2, "Ataturk Parki", "ataturkparki.png"));
//        advancedModel.addOverlay(new Marker(coord4, "Kaleici", "kaleici.png", "http://maps.google.com/mapfiles/ms/micons/pink-dot.png"));
//        advancedModel.addOverlay(new Marker(coord3, "Karaalioglu Parki", "karaalioglu.png", "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));
//    }
  
    public MapModel getAdvancedModel() {
        return advancedModel;
    }
      
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }
      
    public Marker getMarker() {
        return marker;
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
    // </editor-fold>

    
}
