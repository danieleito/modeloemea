/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Ponte;
import com.model.Uf;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class PonteDAO {

    public ArrayList<Ponte> buscar() throws SQLException {
        String query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                + "P.ID_VIA, P.ID_UF, P.DS_LOCAL_VIA, P.ID_SUPERINTENDENCIA_REGIONAL, "
                + "P.ID_UNIDADE_LOCAL, U.ID_UF, U.DS_UF "
                + "from PONTE P, UF U "
                + "where P.ID_UF = U.ID_UF;";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Ponte> pontes = new ArrayList<>();

        while (rs.next()) {
            pontes.add(new Ponte(rs.getInt("ID_PONTE"), rs.getString("CD_PONTE"), 
                    rs.getString("DS_IDENTIFICACAO_OBRA"), rs.getInt("ID_VIA"), 
                    new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF")), rs.getString("DS_LOCAL_VIA"), 
                    rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), rs.getInt("ID_UNIDADE_LOCAL")));
        }

        conexao.closeConnection();
        return pontes;
    }

    public Ponte buscar(int id) throws SQLException {
        String query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                + "P.ID_VIA, P.ID_UF, P.DS_LOCAL_VIA "
                + "from PONTE P "
                + "where P.ID_PONTE = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Ponte ponte = null;
        if (rs.next()) {
            ponte = new Ponte(rs.getInt("ID_PONTE"), rs.getString("CD_PONTE"),
                    rs.getString("DS_IDENTIFICACAO_OBRA"), rs.getInt("ID_VIA"),
                    new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF")), rs.getString("DS_LOCAL_VIA"), 
                    rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), rs.getInt("ID_UNIDADE_LOCAL"));
        }
        conexao.closeConnection();
        return ponte;
    }
    
    public ArrayList<Ponte> buscar2(String codigo, String identificacao, int uf, int via, 
            String localVia, int superintendenciaRegional, int unidadeLocal) throws SQLException {
        
        String query;

        query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, P.ID_VIA, "
                + "P.DS_LOCAL_VIA, P.ID_SUPERINTENDENCIA_REGIONAL, P.ID_UNIDADE_LOCAL, "
                + "U.ID_UNIDADE_LOCAL, U.DS_UNIDADE_LOCAL, U.ID_SUPERINTENDENCIA_REGIONAL, "
                + "S.ID_SUPERINTENDENCIA_REGIONAL, S.DS_SUPERINTENDENCIA_REGIONAL, "
                + "UF.ID_UF, UF.DS_UF "
                + "from PONTE P, UNIDADE_LOCAL U, SUPERINTENDENCIA_REGIONAL S, UF  "
                + "where P.ID_UNIDADE_LOCAL = U.ID_UNIDADE_LOCAL "
                + "and P.ID_SUPERINTENDENCIA_REGIONAL = S.ID_SUPERINTENDENCIA_REGIONAL "
                + "and P.ID_UF = UF.ID_UF";

        if (codigo != null && !codigo.isEmpty()) {
            query += " and P.CD_PONTE like '%" + codigo + "%'";
        } 
        if (identificacao != null && !identificacao.isEmpty()) {
            query += " and P.DS_IDENTIFICACAO_OBRA like '%" + identificacao + "%'";
        }
        if (uf != 0) {
            query += " and P.ID_UF = " + uf
                    + " and S.ID_UF = P.ID_UF";
        }
        if (via != 0) {
            query += " and P.ID_VIA = " + via;
//                    + " and P.ID_UF = V.ID_UF";
        }
        if (localVia != null && !localVia.isEmpty()) {
            query += " and P.DS_LOCAL_VIA like '%" + localVia + "%'";
        }
        if (superintendenciaRegional != 0) {
            query += " and P.ID_SUPERINTENDENCIA_REGIONAL = " + superintendenciaRegional
                    + " and P.ID_UF = S.ID_UF";
        }
        if (unidadeLocal != 0) {
            query += " and P.ID_UNIDADE_LOCAL = " + unidadeLocal
                    + " and S.ID_UF = P.ID_UF";
        }

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<Ponte> pontes = new ArrayList<>();
        while (rs.next()) {
            pontes.add(new Ponte(rs.getInt("ID_PONTE"), rs.getString("CD_PONTE"), 
                    rs.getString("DS_IDENTIFICACAO_OBRA"), rs.getInt("ID_VIA"), 
                    new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF")), rs.getString("DS_LOCAL_VIA"), 
                    rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), rs.getInt("ID_UNIDADE_LOCAL")));
        }
        conexao.closeConnection();
        return pontes;
    }

    public void carregar() {

    }
}