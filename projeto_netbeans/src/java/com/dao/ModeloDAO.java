/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class ModeloDAO {
    public Modelo buscar(int id) throws SQLException {
        String query = "select ID_MODELO, DS_INDICE_BASE, DS_INDICE_PERFORMANCE "
                + "from MODELO "
                + "where ID_MODELO = " + id + ";";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        Modelo modelo = null;
        if (rs.next()) {
            modelo = new Modelo(rs.getInt("ID_MODELO"), rs.getString("DS_INDICE_BASE"), 
                    rs.getString("DS_INDICE_PERFORMANCE"));
        }

        conexao.closeConnection();
        return modelo;
    }
}
