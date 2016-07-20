/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Numero;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class NumeroDAO {
    public ArrayList<Numero> buscar() throws SQLException {
        String query = "select ID_NUMERO, DS_NUMERO from NUMERO; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Numero> numero = new ArrayList<>();

        while (rs.next()) {
            numero.add(new Numero(rs.getInt("ID_NUMERO"), rs.getString("DS_NUMERO")));
        }

        conexao.closeConnection();
        return numero;
    }
}
