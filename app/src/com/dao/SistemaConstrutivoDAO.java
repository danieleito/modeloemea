/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.SistemaConstrutivo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class SistemaConstrutivoDAO {
    public ArrayList<SistemaConstrutivo> buscar() throws SQLException {
        String query = "select ID_SISTEMA_CONSTRUTIVO, DS_SISTEMA_CONSTRUTIVO "
                + "from SISTEMA_CONSTRUTIVO; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<SistemaConstrutivo> sistemaConstrutivo = new ArrayList<>();

        while (rs.next()) {
            sistemaConstrutivo.add(new SistemaConstrutivo(rs.getInt("ID_SISTEMA_CONSTRUTIVO"), 
                    rs.getString("DS_SISTEMA_CONSTRUTIVO")));
        }

        conexao.closeConnection();
        return sistemaConstrutivo;
    }
}
