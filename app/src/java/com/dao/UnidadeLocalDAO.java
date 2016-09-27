/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.SuperintendenciaRegional;
import com.model.Uf;
import com.model.UnidadeLocal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class UnidadeLocalDAO {
    public ArrayList<UnidadeLocal> buscar() throws SQLException {
        String query = "select UL.ID_UNIDADE_LOCAL, UL.DS_UNIDADE_LOCAL, UL.ID_SUPERINTENDENCIA_REGIONAL, "
                + "S.DS_SUPERINTENDENCIA_REGIONAL, S.ID_UF, U.DS_UF, U.SG_UF "
                + "from UNIDADE_LOCAL UL, SUPERINTENDENCIA_REGIONAL S, UF U "
                + "where UL.ID_SUPERINTENDENCIA_REGIONAL = S.ID_SUPERINTENDENCIA_REGIONAL "
                + "and S.ID_UF = U.ID_UF; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt
                ;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<UnidadeLocal> tipos = new ArrayList<>();

        while (rs.next()) {
            tipos.add(new UnidadeLocal(rs.getInt("ID_UNIDADE_LOCAL"), rs.getString("DS_UNIDADE_LOCAL"), 
                    new SuperintendenciaRegional(rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), 
                    rs.getString("DS_SUPERINTENDENCIA_REGIONAL"), new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF"), rs.getString("SG_UF")))));
        }

        conexao.closeConnection();
        return tipos;
    }
}
