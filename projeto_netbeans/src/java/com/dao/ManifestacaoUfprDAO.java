/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.ManifestacaoUfpr;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class ManifestacaoUfprDAO {
    public ArrayList<ManifestacaoUfpr> buscar() throws SQLException {
        String query = "select M.ID_MANIFESTACAO_UFPR, M.CD_MANIFESTACAO_UFPR, "
                + "M.DS_MANIFESTACAO_UFPR, M.DS_UNIDADE, M.DS_BETA "
                + "from MANIFESTACAO_UFPR M;";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<ManifestacaoUfpr> manifestacaoUfpr = new ArrayList<>();

        while (rs.next()) {
            manifestacaoUfpr.add(new ManifestacaoUfpr(rs.getInt("ID_MANIFESTACAO_UFPR"),  
                    rs.getString("CD_MANIFESTACAO_UFPR"), rs.getString("DS_MANIFESTACAO_UFPR"), rs.getString("DS_UNIDADE"), rs.getString("DS_BETA")));
        }

        conexao.closeConnection();
        return manifestacaoUfpr;
    }
}
