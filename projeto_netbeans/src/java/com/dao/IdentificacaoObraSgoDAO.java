/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.IdentificacaoObraSgo;
import com.model.Ponte;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniele Harumi Ito
 */
public class IdentificacaoObraSgoDAO {
    public IdentificacaoObraSgo buscar(int id) throws SQLException {
        String query = "select ID_IDENTIFICACAO_OBRA_SGO, DT_DATA_INSPECAO, NM_INSPETOR "
                + "from IDENTIFICACAO_OBRA_SGO "
                + "where ID_IDENTIFICACAO_OBRA_SGO = " + id + ";";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        IdentificacaoObraSgo identificacaoObraSgo = null;
        if (rs.next()) {
            identificacaoObraSgo = new IdentificacaoObraSgo(rs.getInt("ID_IDENTIFICACAO_OBRA_SGO"), rs.getDate("DT_DATA_INSPECAO"), rs.getString("NM_INSPETOR"));
        }

        conexao.closeConnection();
        return identificacaoObraSgo;
    }
}
