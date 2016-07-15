/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.ElementoUfpr;
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
        String query = "select ID_MANIFESTACOES_UFPR, ID_ELEMENTO_UFPR, CD_MANIFESTACOES_UFPR, DS_MANIFESTACOES_UFPR, DS_UNIDADE, DS_BETA from MANIFESTACOES_UFPR; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<ManifestacaoUfpr> manifestacaoUfpr = new ArrayList<>();

        while (rs.next()) {
            manifestacaoUfpr.add(new ManifestacaoUfpr(rs.getInt("ID_MANIFESTACOES_UFPR"), 
                    new ElementoUfpr(rs.getInt("ID_ELEMENTO_UFPR"), rs.getString("CD_ELEMENTO"), rs.getString("DS_ELEMENTO"), rs.getString("DS_CAPA1")), 
                    rs.getString("CD_MANIFESTACOES_UFPR"), rs.getString("DS_MANIFESTACOES_UFPR"), rs.getString("DS_UNIDADE"), rs.getString("DS_BETA")));
        }

        conexao.closeConnection();
        return manifestacaoUfpr;
    }
}
