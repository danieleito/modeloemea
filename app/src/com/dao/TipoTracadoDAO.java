/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.TipoTracado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class TipoTracadoDAO {
    public ArrayList<TipoTracado> buscar() throws SQLException {
        String query = "select ID_TIPO_TRACADO, DS_TIPO_TRACADO from TIPO_TRACADO; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<TipoTracado> tipoTracado = new ArrayList<>();

        while (rs.next()) {
            tipoTracado.add(new TipoTracado(rs.getInt("ID_TIPO_TRACADO"), rs.getString("DS_TIPO_TRACADO")));
        }

        conexao.closeConnection();
        return tipoTracado;
    }
}
