/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.ExtensaoRelativa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class ExtensaoRelativaDAO {
    public ArrayList<ExtensaoRelativa> buscar() throws SQLException {
        String query = "select ID_EXTENSAO_RELATIVA, DS_EXTENSAO_RELATIVA from EXTENSAO_RELATIVA; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<ExtensaoRelativa> extensaoRelativa = new ArrayList<>();

        while (rs.next()) {
            extensaoRelativa.add(new ExtensaoRelativa(rs.getInt("ID_EXTENSAO_RELATIVA"), rs.getString("DS_EXTENSAO_RELATIVA")));
        }

        conexao.closeConnection();
        return extensaoRelativa;
    }
}
