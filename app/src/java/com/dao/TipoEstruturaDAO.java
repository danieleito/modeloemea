/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.TipoEstrutura;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class TipoEstruturaDAO {
    public ArrayList<TipoEstrutura> buscar() throws SQLException {
        String query = "select ID_TIPO_ESTRUTURA, DS_TIPO_ESTRUTURA from TIPO_ESTRUTURA; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<TipoEstrutura> tipoEstrutura = new ArrayList<>();

        while (rs.next()) {
            tipoEstrutura.add(new TipoEstrutura(rs.getInt("ID_TIPO_ESTRUTURA"), 
                    rs.getString("DS_TIPO_ESTRUTURA")));
        }

        conexao.closeConnection();
        return tipoEstrutura;
    }
}
