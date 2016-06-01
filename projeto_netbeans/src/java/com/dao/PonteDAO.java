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
                    rs.getString("DS_UF"), rs.getString("DS_LOCAL_VIA")));
        }

        conexao.closeConnection();
        return pontes;
    }
    
    public Ponte buscar(int id) throws SQLException {
        String query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA "
                + "from PONTE P "
                + "and P.ID_PONTE = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Ponte ponte = null;
        if (rs.next()) {
            ponte = new Ponte(rs.getInt("ID_PONTE"), rs.getString("CD_PONTE"),
                    rs.getString("DS_IDENTIFICACAO_OBRA"), rs.getString("DS_VIA"), 
                    rs.getString("DS_UF"), rs.getString("DS_LOCAL_VIA"));
        }
        conexao.closeConnection();
        return ponte;
    }

    public Ponte buscar(String str) throws SQLException {
        String query = "select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, "
                + "P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA "
                + "from PONTE P "
                + "and P.CD_PONTE = " + str + ";";
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Ponte ponte = null;
        if (rs.next()) {
            ponte = new Ponte(rs.getInt("ID_PONTE"), rs.getString("CD_PONTE"),
                    rs.getString("DS_IDENTIFICACAO_OBRA"), rs.getString("DS_VIA"), 
                    rs.getString("DS_UF"), rs.getString("DS_LOCAL_VIA"));
        }
        conexao.closeConnection();
        return ponte;
    }
    
    public void carregar() {
        
    }
}
