/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.ElementoUfpr;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class ElementoUfprDAO {
    public ArrayList<ElementoUfpr> buscar() throws SQLException {
        String query = "select ID_ELEMENTO_UFPR, CD_ELEMENTO, DS_ELEMENTO, NR_CAPA1 from ELEMENTO_UFPR; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<ElementoUfpr> elementoUfpr = new ArrayList<>();

        while (rs.next()) {
            elementoUfpr.add(new ElementoUfpr(rs.getInt("ID_ELEMENTO_UFPR"), rs.getString("CD_ELEMENTO"), 
                    rs.getString("DS_ELEMENTO"), rs.getDouble("NR_CAPA1")));
        }

        conexao.closeConnection();
        return elementoUfpr;
    }
}
