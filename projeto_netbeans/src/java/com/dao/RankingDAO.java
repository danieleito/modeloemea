/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Ponte;
import com.model.Ranking;
import com.model.Uf;
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
public class RankingDAO {
    public ArrayList<Ranking> buscar() throws SQLException {
        String query = "SELECT R.ID_RANKING, R.ID_PONTE, P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, "
                + "DB.CD_CODIGO, P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO, "
                + "L.ID_VIA, V.DS_VIA, L.ID_UF, U.DS_UF, L.DS_LOCAL_VIA, "
                + "(select max(DT_DATA) from INSPECAO I, PONTE P where I.ID_PONTE = P.ID_PONTE) as DATA, "
                + "R.ID_SIMULACAO, S.DT_DATA, S.ID_USUARIO, S.NM_SIMULACAO, P.DS_INDICE_PERFORMANCE_RELATIVO "
                + "FROM RANKING R, PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, "
                + "IDENTIFICACAO_OBRA_LOCALIZACAO L, VIA V, UF U, SIMULACAO S "
                + "WHERE R.ID_PONTE = P.ID_PONTE "
                + "AND P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS "
                + "AND P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO = L.ID_IDENTIFICACAO_OBRA_LOCALIZACAO "
                + "AND L.ID_VIA = V.ID_VIA "
                + "AND L.ID_UF = U.ID_UF "                
                + "AND R.ID_SIMULACAO = S.ID_SIMULACAO "
                + "ORDER BY P.DS_INDICE_PERFORMANCE_RELATIVO DESC; ";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Ranking> ranking = new ArrayList<>();

        Ponte ponte;
        while (rs.next()) {
            ponte = new Ponte();
            ponte.setId(rs.getInt("ID_PONTE"));
            ponte.getIdentificacaoObraDadosBasicos().setCodigo(rs.getString("CD_CODIGO"));
            ponte.getIdentificacaoObraDadosBasicos().setIdentificacao(rs.getString("DS_IDENTIFICACAO_OBRA"));
            ponte.getIdentificacaoObraLocalizacao().setVia(new Via(rs.getInt("ID_VIA"), rs.getString("DS_VIA")));
            ponte.getIdentificacaoObraLocalizacao().setUf(new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF")));
            ponte.getIdentificacaoObraLocalizacao().setLocalVia(rs.getDouble("DS_LOCAL_VIA"));
            ranking.add(new Ranking(rs.getInt("ID_RANKING"), ponte));
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

    public void inserir(int idPonte, int idSimulacao) throws SQLException {
        String query = "insert into RANKING (ID_PONTE, ID_SIMULACAO) values(?, ?); ";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        
        PreparedStatement stmt;
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, idPonte);
        stmt.setInt(2, idSimulacao);
        stmt.execute();
    }
    
    public void editar(Ranking ranking) throws SQLException {
        String query = "update RANKING ";
        query += "set ID_PONTE = '" + ranking.getPonte()+ "' ";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public Ranking buscar(int id) throws SQLException {
        String query = "SELECT R.ID_RANKING, R.ID_PONTE, P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, "
                + "DB.CD_CODIGO, DB.DS_IDENTIFICACAO_OBRA, P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO, "
                + "L.ID_VIA, V.DS_VIA, L.ID_UF, U.DS_UF, L.DS_LOCAL_VIA, "
                + "(select max(DT_DATA) from INSPECAO I, PONTE P where I.ID_PONTE = P.ID_PONTE) as DATA, "
                + "R.ID_SIMULACAO, S.DT_DATA, S.ID_USUARIO, S.NM_SIMULACAO, "
                + "P.DS_INDICE_PERFORMANCE_RELATIVO "
                + "FROM RANKING R, PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, "
                + "IDENTIFICACAO_OBRA_LOCALIZACAO L, VIA V, UF U, SIMULACAO S "
                + "WHERE P.ID_PONTE = R.ID_PONTE "
                + "AND P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS "
                + "AND P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO = L.ID_IDENTIFICACAO_OBRA_LOCALIZACAO "
                + "AND L.ID_VIA = V.ID_VIA "
                + "AND L.ID_UF = U.ID_UF "                
                + "AND R.ID_SIMULACAO = S.ID_SIMULACAO "
                + "AND R.ID_RANKING = " + id + " " 
                + "ORDER BY P.DS_INDICE_PERFORMANCE_RELATIVO DESC; ";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Ranking ranking = null;
        if (rs.next()) {
            Ponte ponte = new Ponte();
            ponte.setId(rs.getInt("ID_PONTE"));
            ponte.setDataUltimaInspecao(rs.getDate("DATA"));
            ponte.setIndicePerformanceRelativo(rs.getString("DS_INDICE_PERFORMANCE_RELATIVO"));
            ponte.getIdentificacaoObraDadosBasicos().setCodigo(rs.getString("CD_PONTE"));
            ponte.getIdentificacaoObraDadosBasicos().setIdentificacao(rs.getString("DS_IDENTIFICACAO_OBRA"));
            ponte.getIdentificacaoObraLocalizacao().setVia(new Via(rs.getInt("ID_VIA"), null));
            ponte.getIdentificacaoObraLocalizacao().setUf(new Uf(rs.getInt("ID_UF"), null));
            ponte.getIdentificacaoObraLocalizacao().setLocalVia(rs.getDouble("DS_LOCAL_VIA"));
            ranking = new Ranking(rs.getInt("ID_RANKING"), ponte);
        }

        conexao.closeConnection();
        return ranking;
    }

}