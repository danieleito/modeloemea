/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.AspectoEspecial;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class AspectoEspecialDAO {
    public ArrayList<AspectoEspecial> buscar() throws SQLException {
        String query = "select ID_ASPECTOS_ESPECIAIS, DS_ASPECTOS_ESPECIAIS from ASPECTOS_ESPECIAIS; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<AspectoEspecial> aspectoEspecial = new ArrayList<>();

        while (rs.next()) {
            aspectoEspecial.add(new AspectoEspecial(rs.getInt("ID_ASPECTOS_ESPECIAIS"), rs.getString("DS_ASPECTOS_ESPECIAIS")));
        }

        conexao.closeConnection();
        return aspectoEspecial;
    }
}
