/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.TremTipo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class TremTipoDAO {
    public ArrayList<TremTipo> buscar() throws SQLException {
        String query = "select ID_TREM_TIPO, DS_TREM_TIPO from TREM_TIPO; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<TremTipo> tremTipo = new ArrayList<>();

        while (rs.next()) {
            tremTipo.add(new TremTipo(rs.getInt("ID_TREM_TIPO"), rs.getString("DS_TREM_TIPO")));
        }

        conexao.closeConnection();
        return tremTipo;
    }
}
