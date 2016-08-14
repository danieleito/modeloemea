/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

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
                + "L.ID_UF, U.SG_UF, L.ID_VIA, V.DS_VIA, L.DS_LOCAL_VIA, P.DS_INDICE_PERFORMANCE_RELATIVO, "
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
}