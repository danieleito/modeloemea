/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.MonitoramentoSgo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniele Harumi Ito
 */
public class MonitoramentoSgoDAO {
    public MonitoramentoSgo buscar(int id) throws SQLException {
        String query = "select ID_MONITORAMENTO_SGO, DS_PERIODO, "
                + "DS_TIPO_MONITORAMENTO, DS_EXECUTOR, DS_CUSTO, DS_OBJETO, DS_TECNICAS "
                + "from MONITORAMENTO_SGO "
                + "where ID_MONITORAMENTO_SGO = " + id + ";";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        MonitoramentoSgo monitoramentoSgo = null;
        if (rs.next()) {
            monitoramentoSgo = new MonitoramentoSgo(rs.getInt("ID_MONITORAMENTO_SGO"), rs.getString("DS_PERIODO"), 
                    rs.getString("DS_TIPO_MONITORAMENTO"), rs.getString("DS_EXECUTOR"), rs.getString("DS_CUSTO"), rs.getString("DS_OBJETO"), rs.getString("DS_TECNICAS"));
        }

        conexao.closeConnection();
        return monitoramentoSgo;
    }
}
