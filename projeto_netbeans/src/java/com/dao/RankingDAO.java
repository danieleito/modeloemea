/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Ponte;
import com.model.Ranking;
import com.model.Simulacao;
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
public class RankingDAO {
    public ArrayList<Ranking> buscar() throws SQLException {
        String query = "SELECT R.ID_RANKING, R.ID_PONTE, R.ID_SIMULACAO, "
                + ""+ "R.CS_CLASSIFICACAO, R.DS_INDICE_PERFORMANCE_RELATIVO, "
                + "S.ID_SIMULACAO, S.DT_DATA, S.ID_USUARIO, S.NM_SIMULACAO, "
                + "P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA "
                + "FROM RANKING R, SIMULACAO S, PONTE P "
                + "WHERE R.ID_SIMULACAO = S.ID_SIMULACAO "
                + "AND R.ID_PONTE = P.ID_PONTE;";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Ranking> ranking = new ArrayList<>();

//        Simulacao simulacao;
        Ponte ponte;
        while (rs.next()) {
//            simulacao = new Simulacao();
//            simulacao.setId(rs.getInt("ID_SIMULACAO"));
//            simulacao.setData(rs.getDate("DT_DATA"));
//            simulacao.setUsuario(rs.getObject("ID_USUARIO", Usuario));
//            simulacao.setNomeSimulacao(rs.getString("NM_SIMULACAO"));
            ponte = new Ponte();
            ponte.setId(rs.getInt("ID_PONTE"));
            ponte.setCodigo(rs.getString("CD_PONTE"));;
            ponte.setIdentificaoObra(rs.getString("DS_IDENTIFICACAO_OBRA"));
            ponte.setVia(rs.getString("DS_VIA"));
            ponte.setUf(rs.getString("DS_UF"));
            ponte.setLocalVia(rs.getString("DS_LOCAL_VIA"));

            ranking.add(new Ranking(rs.getInt("ID_RANKING"), ponte, rs.getInt("CS_CLASSIFICACAO"), rs.getString("DS_INDICE_PERFORMANCE_RELATIVO")));
        }

        conexao.closeConnection();
        return ranking;
    }

    public void excluir(int id) throws SQLException {
        String query = "delete from RANKING where ID_RANKING = " + id;

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute(query);
    }

    public void inserir(Ranking ranking) throws SQLException {
        String query = "insert into RANKING (ID_PONTE, ID_SIMULACAO, CS_CLASSIFICACAO, "
                + "DS_INDICE_PERFORMANCE_RELATIVO) values(?, ?, ?, ?); ";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        
        PreparedStatement stmt;
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, ranking.getPonte().getId());
        stmt.setInt(2, ranking.getClassificacao());
        stmt.setString(3, ranking.getIndicePerformanceRelativo());
        stmt.execute();
    }
    
    public void editar(Ranking ranking) throws SQLException {
        String query = "update RANKING ";
        query += "set ID_PONTE = '" + ranking.getPonte()+ "', ";
        query += "CS_CLASSIFICACAO = '" + ranking.getClassificacao()+ "', ";
        query += "DS_INDICE_PERFORMANCE_RELATIVO = '" + ranking.getIndicePerformanceRelativo() + "'";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public Ranking buscar(int id) throws SQLException {
        String query = "SELECT R.ID_RANKING, R.ID_PONTE, R.ID_SIMULACAO, "
                + "R.CS_CLASSIFICACAO, R.DS_INDICE_PERFORMANCE_RELATIVO, "
                + "S.ID_SIMULACAO, S.DT_DATA, S.ID_USUARIO, S.NM_SIMULACAO, "
                + "P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA "
                + "FROM RANKING R, SIMULACAO S, PONTE P "
                + "WHERE R.ID_SIMULACAO = S.ID_SIMULACAO "
                + "AND R.ID_PONTE = P.ID_PONTE "
                + "AND R.ID_RANKING = '" + id + "';";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Ranking ranking = null;
        if (rs.next()) {
//            Simulacao simulacao = new Simulacao();
//            simulacao.setId(rs.getInt("ID_SIMULACAO"));
//            simulacao.setData(rs.getDate("DT_DATA"));
//            simulacao.setUsuario(rs.getObject("ID_USUARIO", Usuario));
//            simulacao.setNomeSimulacao(rs.getString("NM_SIMULACAO"));
            Ponte ponte = new Ponte();
            ponte.setId(rs.getInt("ID_PONTE"));
            ponte.setCodigo(rs.getString("CD_PONTE"));;
            ponte.setIdentificaoObra(rs.getString("DS_IDENTIFICACAO_OBRA"));
            ponte.setVia(rs.getString("DS_VIA"));
            ponte.setUf(rs.getString("DS_UF"));
            ponte.setLocalVia(rs.getString("DS_LOCAL_VIA"));
             
            ranking = new Ranking(ponte, rs.getInt("CS_CLASSIFICACAO"), 
                    rs.getString("DS_INDICE_PERFORMANCE_RELATIVO"));           
        }

        conexao.closeConnection();
        return ranking;
    }
}
