/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

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
public class UfDAO {
    public ArrayList<Uf> buscar() throws SQLException {
        String query = "select ID_UF, DS_UF from UF; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Uf> uf = new ArrayList<>();

        while (rs.next()) {
            uf.add(new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF")));
        }

        conexao.closeConnection();
        return uf;
    }
}
