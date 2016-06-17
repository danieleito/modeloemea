/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Ponte;
import com.model.Ranking;
import com.model.Simulacao;
import com.model.Uf;
import com.model.Usuario;
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

    public ArrayList<Simulacao> buscar() throws SQLException {
        String query = "SELECT S.ID_SIMULACAO, S.DT_DATA, S.ID_USUARIO, "
                + "S.NM_SIMULACAO, U.NM_NOME, U.DS_USUARIO "
                + "FROM SIMULACAO S, USUARIO U " 
                + "WHERE S.ID_USUARIO = U.ID_USUARIO;";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Simulacao> simulacoes = new ArrayList<>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("ID_USUARIO"));
            usuario.setNome(rs.getString("NM_NOME"));
            usuario.setUsuario(rs.getString("DS_USUARIO"));
            
            ArrayList<Ranking> rankings = buscarRankings(rs.getInt("ID_SIMULACAO"));
            Simulacao simulacao = new Simulacao(rs.getInt("ID_SIMULACAO"), 
                    rs.getDate("DT_DATA"), usuario, rs.getString("NM_SIMULACAO"), rankings);
            simulacoes.add(simulacao);
//            simulacoes.add(new Simulacao(rs.getInt("ID_SIMULACAO"), 
//                    rs.getDate("DT_DATA"), usuario, rs.getString("NM_SIMULACAO"), rankings));
        }

        conexao.closeConnection();
        return simulacoes;
    }
    public Simulacao buscar(int id) throws SQLException {
        String query = "SELECT S.ID_SIMULACAO, S.DT_DATA, S.ID_USUARIO, "
                + "S.NM_SIMULACAO, "
                + "U.ID_USUARIO, U.NM_NOME, U.DS_USUARIO "
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
            usuario.setNome(rs.getString("NM_NOME"));
            usuario.setUsuario(rs.getString("DS_USUARIO"));
            
            ArrayList<Ranking> rankings = buscarRankings(rs.getInt("ID_SIMULACAO"));
            simulacao = new Simulacao(rs.getInt("ID_SIMULACAO"), rs.getDate("DT_DATA"), 
                    usuario, rs.getString("NM_SIMULACAO"), rankings);
        }

        conexao.closeConnection();
        return simulacao;
    }

    private ArrayList<Ranking> buscarRankings(int idSimulacao) throws SQLException {
        String query = "SELECT R.ID_RANKING, R.CD_CODIGO, "
                + "(select max(DT_DATA) from inspecao where ID_PONTE = P.ID_PONTE) as DATA, "
                + "R.ID_SIMULACAO, S.DT_DATA, R.CS_CLASSIFICACAO, R.DS_INDICE_PERFORMANCE_RELATIVO, "
                
                + "DB.ID_IDENTIFICACAO_OBRA_LOCALIZACAO, DB.DS_IDENTIFICACAO, L.ID_VIA, "
                + "V.DS_VIA, L.ID_UF, U.DS_UF, L.DS_LOCAL_VIA "
                
                + "FROM RANKING R, SIMULACAO S, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, "
                + "IDENTIFICACAO_OBRA_LOCALIZACAO L, UF U, VIA V "
                + "WHERE R.ID_SIMULACAO = S.ID_SIMULACAO "
                + "AND L.ID_UF = U.ID_UF "
//                + "AND P.ID_PONTE = R.ID_PONTE "
                + "AND R.ID_SIMULACAO = S.ID_SIMULACAO "
                + "AND S.ID_SIMULACAO = " + idSimulacao + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Ranking> rankings = new ArrayList<Ranking>();

        Ponte ponte;
        while (rs.next()) {
            ponte = new Ponte();
//            ponte.setId(rs.getInt("ID_PONTE"));
            ponte.
            ponte.setCodigo(rs.getString("CD_PONTE"));
            ponte.setIdentificacaoObra(rs.getString("DS_IDENTIFICACAO_OBRA"));
            ponte.setIdVia(rs.getInt("ID_VIA"));
            ponte.setUf(new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF")));
            ponte.setLocalVia(rs.getString("DS_LOCAL_VIA"));

            Ranking ranking = new Ranking(rs.getInt("ID_RANKING"), 
                    rs.getDate("DATA"), ponte, 
                    rs.getInt("CS_CLASSIFICACAO"), 
                    rs.getString("DS_INDICE_PERFORMANCE_RELATIVO"));
            rankings.add(ranking);
//            rankings.add(new Ranking(rs.getInt("ID_RANKING"), ponte, rs.getInt("CS_CLASSIFICACAO"), rs.getString("DS_INDICE_PERFORMANCE_RELATIVO")));
        }

        conexao.closeConnection();
        return rankings;
    }
}