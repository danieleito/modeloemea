/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.DeficienciaFuncional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class DeficienciaFuncionalDAO {
    public ArrayList<DeficienciaFuncional> buscar() throws SQLException {
        String query = "select ID_DEFICIENCIAS_FUNCIONAIS, CD_DEFICIENCIA_FUNCIONAL, DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA "
                + "from DEFICIENCIAS_FUNCIONAIS; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<DeficienciaFuncional> deficienciaFuncional = new ArrayList<>();

        while (rs.next()) {
            deficienciaFuncional.add(new DeficienciaFuncional(rs.getInt("ID_DEFICIENCIAS_FUNCIONAIS"), 
                    rs.getString("CD_DEFICIENCIA_FUNCIONAL"), rs.getString("DS_DEFICIENCIA_FUNCIONAL"), rs.getString("DS_UNIDADE_MEDIDA")));
        }

        conexao.closeConnection();
        return deficienciaFuncional;
    }
}
