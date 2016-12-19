/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.CondicaoSgo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniele Harumi Ito
 */
public class CondicaoSgoDAO {
    public CondicaoSgo buscar(int id) throws SQLException {
        String query = "select ID_CONDICOES_SGO, DS_CONDICAO_ESTABILIDADE, DS_CONDICAO_CONSERVACAO, DS_OBSERVACOES, DS_NOTA_TECNICA "
                + "from CONDICOES_SGO "
                + "where ID_CONDICOES_SGO = " + id + ";";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        CondicaoSgo condicaoSgo = null;
        if (rs.next()) {
            condicaoSgo = new CondicaoSgo(rs.getInt("ID_CONDICOES_SGO"), rs.getString("DS_CONDICAO_ESTABILIDADE"), 
                    rs.getString("DS_CONDICAO_CONSERVACAO"), rs.getString("DS_OBSERVACOES"), rs.getString("DS_NOTA_TECNICA"));
        }

        conexao.closeConnection();
        return condicaoSgo;
    }
}
