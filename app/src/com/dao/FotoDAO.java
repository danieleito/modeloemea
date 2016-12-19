/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Foto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class FotoDAO {
    public ArrayList<Foto> buscar() throws SQLException {
        String query = "select ID_FOTO, DS_FOTO from FOTO; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Foto> foto = new ArrayList<>();

        while (rs.next()) {
            foto.add(new Foto(rs.getInt("ID_FOTO"), rs.getString("DS_FOTO")));
        }

        conexao.closeConnection();
        return foto;
    }
}
