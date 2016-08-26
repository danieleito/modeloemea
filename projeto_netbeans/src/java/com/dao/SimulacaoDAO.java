/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.GraficoManifestacao;
import com.model.GraficoSistemaConstrutivo;
import com.model.GraficoTipoElemento;
import com.model.IdentificacaoObraDadosBasicos;
import com.model.IdentificacaoObraLocalizacao;
import com.model.Ponte;
import com.model.Ranking;
import com.model.Simulacao;
import com.model.Uf;
import com.model.Usuario;
import com.model.Via;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class SimulacaoDAO {
    public void excluir(int id) throws SQLException {
        String query = "delete from SIMULACAO where ID_SIMULACAO = " + id;

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute(query);
    }

    public void inserir(Simulacao simulacao) throws SQLException {
        String query = "insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) "
                        + "values (?, ?, ?); ";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        PreparedStatement stmt;
        stmt = conn.prepareStatement(query);
        stmt.setDate(1, new java.sql.Date(simulacao.getData().getTime()));
        stmt.setInt(2, simulacao.getUsuario().getId());
        stmt.setString(3, simulacao.getNomeSimulacao());
        stmt.execute();
    }

    public void editar(Simulacao simulacao) throws SQLException {
        String query = "update SIMULACAO ";
        //query += "set DT_DATA = '" + simulacao.getData()+ "', ";
        query += "set NM_SIMULACAO = '" + simulacao.getNomeSimulacao() + "'";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    //BUSCAR APENAS PARA A GRID SIMULACAO;
    public ArrayList<Simulacao> buscar() throws SQLException {
        String query = "select S.ID_SIMULACAO, S.DT_DATA, S.ID_USUARIO, "
                + "U.DS_USUARIO, S.NM_SIMULACAO "
                + "from SIMULACAO S, USUARIO U "
                + "where S.ID_USUARIO = U.ID_USUARIO;";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Simulacao> simulacoes = new ArrayList<>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("ID_USUARIO"));
            usuario.setUsuario(rs.getString("DS_USUARIO"));

            Simulacao simulacao = new Simulacao(rs.getInt("ID_SIMULACAO"), 
                    rs.getDate("DT_DATA"), usuario, rs.getString("NM_SIMULACAO"), null);
            simulacoes.add(simulacao);
        }

        conexao.closeConnection();
        return simulacoes;
    }
    
    public Simulacao buscar(int id) throws SQLException {
        String query = "SELECT S.ID_SIMULACAO, S.DT_DATA, S.NM_SIMULACAO, U.ID_USUARIO "
                + "FROM SIMULACAO S, USUARIO U "
                + "WHERE S.ID_USUARIO = U.ID_USUARIO "
                + "AND S.ID_SIMULACAO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Simulacao simulacao = null;
        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("ID_USUARIO"));
            
            ArrayList<Ranking> rankings = buscarRankings(rs.getInt("ID_SIMULACAO"));
            simulacao = new Simulacao(rs.getInt("ID_SIMULACAO"), rs.getDate("DT_DATA"), 
                    usuario, rs.getString("NM_SIMULACAO"), rankings);
        }

        conexao.closeConnection();
        return simulacao;
    }

    private ArrayList<Ranking> buscarRankings(int idSimulacao) throws SQLException {
        String query = "select R.ID_RANKING, R.ID_PONTE, P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, "
                + "DB.CD_CODIGO, DB.DS_IDENTIFICACAO, P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO, "
                + "L.ID_UF, U.SG_UF, L.ID_VIA, V.DS_VIA, L.DS_LOCAL_VIA, L.DS_LATITUDE_GRAU, "
                + "L.DS_LATITUDE_MINUTO, L.DS_LONGITUDE_GRAU, L.DS_LONGITUDE_MINUTO, "
                + "P.DS_INDICE_PERFORMANCE_RELATIVO, "
                + "(select max(DT_DATA) from INSPECAO, PONTE P2 where P2.ID_PONTE = INSPECAO.ID_PONTE and P2.ID_PONTE = P.ID_PONTE) as DATA "
                + "from RANKING R, PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, "
                + "IDENTIFICACAO_OBRA_LOCALIZACAO L, VIA V, UF U "
                + "where R.ID_SIMULACAO = " + idSimulacao + " "
                + "and R.ID_PONTE = P.ID_PONTE "
                + "and P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS "
                + "and P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO = L.ID_IDENTIFICACAO_OBRA_LOCALIZACAO "
                + "and L.ID_UF = U.ID_UF "
                + "and L.ID_VIA = V.ID_VIA "
                + "ORDER BY P.DS_INDICE_PERFORMANCE_RELATIVO DESC; ";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Ranking> rankings = new ArrayList<>();

        Ponte ponte;
        IdentificacaoObraDadosBasicos dadosBasicos;
        IdentificacaoObraLocalizacao localizacao;
        while (rs.next()) {
            dadosBasicos = new IdentificacaoObraDadosBasicos();
            localizacao = new IdentificacaoObraLocalizacao();
            dadosBasicos.setCodigo(rs.getString("CD_CODIGO"));
            dadosBasicos.setIdentificacao(rs.getString("DS_IDENTIFICACAO"));
            localizacao.setUf(new Uf(rs.getInt("ID_UF"), null, rs.getString("SG_UF")));
            localizacao.setVia(new Via(rs.getInt("ID_VIA"), rs.getString("DS_VIA")));
            localizacao.setLocalVia(rs.getDouble("DS_LOCAL_VIA"));
            localizacao.setLatitudeGrau(rs.getString("DS_LATITUDE_GRAU"));
            localizacao.setLatitudeMinuto(rs.getString("DS_LATITUDE_MINUTO"));
            localizacao.setLongitudeGrau(rs.getString("DS_LONGITUDE_GRAU"));
            localizacao.setLongitudeMinuto(rs.getString("DS_LONGITUDE_MINUTO"));
            
            ponte = new Ponte();
            ponte.setId(rs.getInt("ID_PONTE"));
            ponte.setIdentificacaoObraDadosBasicos(dadosBasicos);
            ponte.setIdentificacaoObraLocalizacao(localizacao);
            ponte.setIndicePerformanceRelativo(rs.getString("DS_INDICE_PERFORMANCE_RELATIVO"));
            ponte.setDataUltimaInspecao(rs.getDate("DATA"));

            Ranking ranking = new Ranking(rs.getInt("ID_RANKING"), ponte);
            rankings.add(ranking);
        }

        conexao.closeConnection();
        return rankings;
    }
    
    public void excluirRanking(int id) throws SQLException {
        String query = "delete from RANKING where ID_RANKING = " + id;

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute(query);
    }
    
    public int buscarIndicePerformanceRelativo(int idSimulacao) throws SQLException {
        String query = "select P.ID_PONTE, P.DS_INDICE_PERFORMANCE_RELATIVO, "
                + "R.ID_RANKING, R.ID_SIMULACAO "
                + "from PONTE P, RANKING R, SIMULACAO S "
                + "where P.ID_PONTE = R.ID_PONTE "
                + "and R.ID_SIMULACAO = S.ID_SIMULACAO "
                + "and S.ID_SIMULACAO = " + idSimulacao;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Simulacao simulacao = null;
        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("ID_USUARIO"));
            
            ArrayList<Ranking> rankings = buscarRankings(rs.getInt("ID_SIMULACAO"));
            simulacao = new Simulacao(rs.getInt("ID_SIMULACAO"), rs.getDate("DT_DATA"), 
                    usuario, rs.getString("NM_SIMULACAO"), rankings);
            
            
        }

        conexao.closeConnection();
        return 100;
    }
    
    public ArrayList<GraficoManifestacao> buscarGraficoManifestacoes(int idSimulacao) throws SQLException {
        String query = "select TOP(10) COUNT(MUF.DS_MANIFESTACAO_UFPR) as QTDE, "
                + "MUF.DS_MANIFESTACAO_UFPR "
                + "from SIMULACAO SIM, RANKING RAN, PONTE PON, "
                + "INSPECAO INS, INSPECAO_MANIFESTACAO_ELEMENTO IME, "
                + "ELEMENTO_UFPR_MANIFESTACAO_UFPR EUM, "
                + "MANIFESTACAO_UFPR MUF "
                + "where SIM.ID_SIMULACAO = " + idSimulacao + " "
                + "and RAN.ID_SIMULACAO = SIM.ID_SIMULACAO "
                + "and RAN.ID_PONTE = PON.ID_PONTE "
                + "and PON.ID_PONTE = INS.ID_PONTE "
                + "and INS.ID_INSPECAO = IME.ID_INSPECAO "
                + "and IME.ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR = EUM.ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR "
                + "and EUM.ID_MANIFESTACAO_UFPR = MUF.ID_MANIFESTACAO_UFPR "
                + "group by MUF.DS_MANIFESTACAO_UFPR "
                + "order by QTDE DESC; ";
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        ArrayList<GraficoManifestacao> graficoManifestacoes = new ArrayList<>();
        GraficoManifestacao g;
        while (rs.next()) {
            g = new GraficoManifestacao(rs.getInt("QTDE"), rs.getString("DS_MANIFESTACAO_UFPR"));
            graficoManifestacoes.add(g);
        }
        return graficoManifestacoes;
    }
    
    public ArrayList<GraficoTipoElemento> buscarGraficoTipoElemento(int idSimulacao) throws SQLException {
        String query = "select TOP(10) COUNT(TE.DS_TIPO_ESTRUTURA) as QTDE, TE.DS_TIPO_ESTRUTURA "
                + "from SIMULACAO S, RANKING R, PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, TIPO_ESTRUTURA TE "
                + "where S.ID_SIMULACAO = " + idSimulacao + " "
                + "and S.ID_SIMULACAO = R.ID_SIMULACAO "
                + "and R.ID_PONTE = P.ID_PONTE "
                + "and P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS "
                + "and DB.ID_TIPO_ESTRUTURA = TE.ID_TIPO_ESTRUTURA "
                + "group by TE.DS_TIPO_ESTRUTURA "
                + "order by QTDE DESC;";
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        ArrayList<GraficoTipoElemento> graficoTipoElementos = new ArrayList<>();
        GraficoTipoElemento g;
        while (rs.next()) {
            g = new GraficoTipoElemento(rs.getInt("QTDE"), rs.getString("DS_TIPO_ESTRUTURA"));
            graficoTipoElementos.add(g);
        }
        return graficoTipoElementos;
    }
    
    public ArrayList<GraficoSistemaConstrutivo> buscarGraficoSistemaConstrutivo(int idSimulacao) throws SQLException {
        String query = "select TOP(10) COUNT(SC.DS_SISTEMA_CONSTRUTIVO) as QTDE, SC.DS_SISTEMA_CONSTRUTIVO "
                + "from SIMULACAO S, RANKING R, PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, SISTEMA_CONSTRUTIVO SC "
                + "where S.ID_SIMULACAO = " + idSimulacao + " "
                + "and S.ID_SIMULACAO = R.ID_SIMULACAO "
                + "and R.ID_PONTE = P.ID_PONTE "
                + "and P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS "
                + "and DB.ID_SISTEMA_CONSTRUTIVO = SC.ID_SISTEMA_CONSTRUTIVO "
                + "group by SC.DS_SISTEMA_CONSTRUTIVO "
                + "order by QTDE DESC;";
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        ArrayList<GraficoSistemaConstrutivo> graficoSistemaConstrutivos = new ArrayList<>();
        GraficoSistemaConstrutivo g;
        while (rs.next()) {
            g = new GraficoSistemaConstrutivo(rs.getInt("QTDE"), rs.getString("DS_SISTEMA_CONSTRUTIVO"));
            graficoSistemaConstrutivos.add(g);
        }
        return graficoSistemaConstrutivos;
    }
}