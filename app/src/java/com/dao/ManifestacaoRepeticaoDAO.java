/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.ManifestacaoRepeticao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class ManifestacaoRepeticaoDAO {
    public ArrayList<ManifestacaoRepeticao> buscar() throws SQLException {
        String query = "select MR.ID_MANIFESTACOES_REPETICAO, MR.DS_CRITERIO_MANIFESTACOES_REPETICAO, "
                + "MR.DS_LIMITESUPERIOR, MR.DS_CAPA3 "
                + "from MANIFESTACOES_REPETICAO MR;";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<ManifestacaoRepeticao> manifestacaoRepeticoes = new ArrayList<>();

        while (rs.next()) {
            manifestacaoRepeticoes.add(new ManifestacaoRepeticao(rs.getInt("ID_MANIFESTACOES_REPETICAO"), 
                    rs.getString("DS_CRITERIO_MANIFESTACOES_REPETICAO"), rs.getString("DS_LIMITESUPERIOR"), 
                    rs.getString("DS_CAPA3")));
        }

        conexao.closeConnection();
        return manifestacaoRepeticoes;
    }
}
