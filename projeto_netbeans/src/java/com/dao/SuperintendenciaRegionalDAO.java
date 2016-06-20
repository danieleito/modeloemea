/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.SuperintendenciaRegional;
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
public class SuperintendenciaRegionalDAO {
    public ArrayList<SuperintendenciaRegional> buscar() throws SQLException {
        String query = "select S.ID_SUPERINTENDENCIA_REGIONAL, S.DS_SUPERINTENDENCIA_REGIONAL, "
                + "S.ID_UF, U.DS_UF "
                + "from SUPERINTENDENCIA_REGIONAL S, UF U "
                + "where S.ID_UF = U.ID_UF; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<SuperintendenciaRegional> tipos = new ArrayList<>();

        while (rs.next()) {
            tipos.add(new SuperintendenciaRegional(rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), 
                    rs.getString("DS_SUPERINTENDENCIA_REGIONAL"), 
                    new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF"))));
        }

        conexao.closeConnection();
        return tipos;
    }
}
