/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Via;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class ViaDAO {
    public ArrayList<Via> buscar() throws SQLException {
        String query = "select ID_VIA, DS_VIA from VIA; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Via> tipos = new ArrayList<>();

        while (rs.next()) {
            tipos.add(new Via(rs.getInt("ID_VIA"), rs.getString("DS_VIA")));
        }

        conexao.closeConnection();
        return tipos;
    }
}
