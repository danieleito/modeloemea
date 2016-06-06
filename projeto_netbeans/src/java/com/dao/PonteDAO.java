/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Ponte;
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
//        ArrayList<Ponte> ponte = null;
//        return ponte;

        String query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA "
                + "from PONTE P;";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Ponte> pontes = new ArrayList<>();

        while (rs.next()) {
            pontes.add(new Ponte(rs.getInt("ID_PONTE"), rs.getString("CD_PONTE"),
                    rs.getString("DS_IDENTIFICACAO_OBRA"), rs.getString("DS_VIA"),
                    rs.getString("DS_UF"), rs.getString("DS_LOCAL_VIA"), 
                    rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), rs.getInt("ID_UNIDADE_LOCAL")));
        }

        conexao.closeConnection();
        return pontes;
    }

    public Ponte buscar(int id) throws SQLException {
        String query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA "
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
                    rs.getString("DS_IDENTIFICACAO_OBRA"), rs.getString("DS_VIA"),
                    rs.getString("DS_UF"), rs.getString("DS_LOCAL_VIA"), 
                    rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), rs.getInt("ID_UNIDADE_LOCAL"));
        }
        conexao.closeConnection();
        return ponte;
    }

    public ArrayList<Ponte> buscar(String str) throws SQLException {
        String query;
        if (str.equals("codigo")) {
            query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                    + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA, ID_SUPERINTENDENCIA_REGIONAL, "
                    + "ID_UNIDADE_LOCAL "
                    + "from PONTE P "
                    + "where P.CD_PONTE = " + str + ";";
        } else if (str.equals("identificacao")) {
            query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                    + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA, ID_SUPERINTENDENCIA_REGIONAL, "
                    + "ID_UNIDADE_LOCAL "
                    + "from PONTE P "
                    + "where P.DS_IDENTIFICACAO_OBRA = " + str + ";";
        } else if (str.equals("uf")) {
            query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                    + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA, ID_SUPERINTENDENCIA_REGIONAL, "
                    + "ID_UNIDADE_LOCAL "
                    + "from PONTE P "
                    + "where P.DS_UF = " + str + ";";
        } else if (str.equals("via")) {
            query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                    + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA, ID_SUPERINTENDENCIA_REGIONAL, "
                    + "ID_UNIDADE_LOCAL "
                    + "from PONTE P "
                    + "where P.DS_LOCAL_VIA = " + str + ";";
        } else if (str.equals("localVia")) {
            query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                    + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA, ID_SUPERINTENDENCIA_REGIONAL, "
                    + "ID_UNIDADE_LOCAL "
                    + "from PONTE P "
                    + "where P.DS_LOCAL_VIA = " + str + ";";
        } else if (str.equals("superintendenciaRegional")) {
            query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                    + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA, P.ID_SUPERINTENDENCIA_REGIONAL, "
                    + "P.ID_UNIDADE_LOCAL, S.ID_SUPERINTENDENCIA_REGIONAL "
                    + "from PONTE P, SUPERINTENDENCIA_REGIONAL S "
                    + "where P.ID_SUPERINTENDENCIA_REGIONAL = S.ID_SUPERINTENDENCIA_REGIONAL "
                    + "and P.ID_SUPERINTENDENCIA_REGIONAL = " + str + ";";
        } else if (str.equals("unidadeLocal")) {
            query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                    + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA, P.ID_SUPERINTENDENCIA_REGIONAL, "
                    + "P.ID_UNIDADE_LOCAL, U.ID_UNIDADE_LOCAL, U.DS_UNIDADE_LOCAL, "
                    + "U.ID_SUPERINTENDENCIA_REGIONAL "
                    + "from PONTE P, UNIDADE_LOCAL U "
                    + "where P.ID_UNIDADE_LOCAL = U.ID_UNIDADE_LOCAL "
                    + "and P.ID_UNIDADE_LOCAL = " + str + ";";
        } else {
            query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                    + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA, P.ID_SUPERINTENDENCIA_REGIONAL, "
                    + "P.ID_UNIDADE_LOCAL "
                    + "from PONTE P;";
        }

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<Ponte> pontes = new ArrayList<>();
        while (rs.next()) {
            pontes.add(new Ponte(rs.getInt("ID_PONTE"), rs.getString("CD_PONTE"),
                    rs.getString("DS_IDENTIFICACAO_OBRA"), rs.getString("DS_VIA"),
                    rs.getString("DS_UF"), rs.getString("DS_LOCAL_VIA"),
                    rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), rs.getInt("ID_UNIDADE_LOCAL")));
        }
        conexao.closeConnection();
        return pontes;
    }

    
    
    
    
    
    public ArrayList<Ponte> buscar2(String codigo, String identificacao, String uf, String via, String localVia, String superintendenciaRegional, String unidadeLocal) throws SQLException {
        String query;
        
        query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA, P.ID_SUPERINTENDENCIA_REGIONAL, "
                + "P.ID_UNIDADE_LOCAL, U.ID_UNIDADE_LOCAL, U.DS_UNIDADE_LOCAL, "
                + "U.ID_SUPERINTENDENCIA_REGIONAL "
                + "from PONTE P, UNIDADE_LOCAL U, SUPERINTENDENCIA_REGIONAL S "
                + "where P.ID_UNIDADE_LOCAL = U.ID_UNIDADE_LOCAL "
                + "and P.ID_SUPERINTENDENCIA_REGIONAL = S.ID_SUPERINTENDENCIA_REGIONAL";
        
        if (codigo != null && !codigo.isEmpty()) {
            query += " and P.CD_PONTE like '%" + codigo + "%'";
        } 
        if (identificacao != null && !identificacao.isEmpty()) {
            query += " and P.DS_IDENTIFICACAO_OBRA like '%" + identificacao + "%'";
        }
        if (uf != null && !uf.isEmpty()) {
            query += " and P.DS_UF like '%" + uf + "%' "
                    + "******************************";
        } else if (via != null && !via.isEmpty()) {
            query += " and P.DS_VIA like '%" + via + "%'";
        } else if (localVia != null && !localVia.isEmpty()) {
            query += " and P.DS_LOCAL_VIA like '%" + localVia + "%'";
        } else if (superintendenciaRegional != null && !superintendenciaRegional.isEmpty()) {
            query += " and P.ID_SUPERINTENDENCIA_REGIONAL like '%" + superintendenciaRegional + "%'";
        } else if (unidadeLocal != null && !unidadeLocal.isEmpty()) {
            query += " and P.ID_UNIDADE_LOCAL like '%" + unidadeLocal + "%'";
        }

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<Ponte> pontes = new ArrayList<>();
        while (rs.next()) {
            pontes.add(new Ponte(rs.getInt("ID_PONTE"), rs.getString("CD_PONTE"),
                    rs.getString("DS_IDENTIFICACAO_OBRA"), rs.getString("DS_VIA"),
                    rs.getString("DS_UF"), rs.getString("DS_LOCAL_VIA"), 
                    rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), rs.getInt("ID_UNIDADE_LOCAL")));
        }
        conexao.closeConnection();
        return pontes;
    }
    public void carregar() {

    }
}
