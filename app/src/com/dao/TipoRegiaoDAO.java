/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.TipoRegiao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class TipoRegiaoDAO {
    public ArrayList<TipoRegiao> buscar() throws SQLException {
        String query = "select ID_TIPO_REGIAO, DS_TIPO_REGIAO from TIPO_REGIAO; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<TipoRegiao> tipoRegiao = new ArrayList<>();

        while (rs.next()) {
            tipoRegiao.add(new TipoRegiao(rs.getInt("ID_TIPO_REGIAO"), rs.getString("DS_TIPO_REGIAO")));
        }

        conexao.closeConnection();
        return tipoRegiao;
    }
}
