/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Reparo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class ReparoDAO {
    public ArrayList<Reparo> buscar() throws SQLException {
        String query = "select ID_REPARO, DS_REPARO from REPARO; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Reparo> reparo = new ArrayList<>();

        while (rs.next()) {
            reparo.add(new Reparo(rs.getInt("ID_REPARO"), rs.getString("DS_REPARO")));
        }

        conexao.closeConnection();
        return reparo;
    }
}
