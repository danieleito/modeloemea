/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.LaudoEspecializadoSgo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniele Harumi Ito
 */
public class LaudoEspecializadoSgoDAO {
    public LaudoEspecializadoSgo buscar(int id) throws SQLException {
        String query = "select ID_LAUDO_ESPECIALIZADO_SGO, DT_DATA_LAUDO, DS_CONSULTOR, DS_OBSERVACOES "
                + "from LAUDO_ESPECIALIZADO_SGO "
                + "where ID_LAUDO_ESPECIALIZADO_SGO = " + id + ";";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        LaudoEspecializadoSgo laudoEspecializadoSgo = null;
        if (rs.next()) {
            laudoEspecializadoSgo = new LaudoEspecializadoSgo(rs.getInt("ID_LAUDO_ESPECIALIZADO_SGO"), rs.getDate("DT_DATA_LAUDO"), 
                    rs.getString("DS_CONSULTOR"), rs.getString("DS_OBSERVACOES"));
        }

        conexao.closeConnection();
        return laudoEspecializadoSgo;
    }
}
