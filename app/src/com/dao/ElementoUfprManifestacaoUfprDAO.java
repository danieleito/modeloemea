/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.ElementoUfpr;
import com.model.ElementoUfprManifestacaoUfpr;
import com.model.ManifestacaoUfpr;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniele Harumi Ito
 */
public class ElementoUfprManifestacaoUfprDAO {
    public ElementoUfprManifestacaoUfpr buscar(int idElementoUfprManifestacaoUfpr) throws SQLException {
        String query = "select EM.ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR, EM.ID_ELEMENTO_UFPR, "
                + "E.CD_ELEMENTO, E.DS_ELEMENTO, E.NR_CAPA1, EM.ID_MANIFESTACAO_UFPR, "
                + "M.CD_MANIFESTACAO_UFPR, M.DS_MANIFESTACAO_UFPR, M.DS_UNIDADE, M.NR_BETA "
                + "from ELEMENTO_UFPR_MANIFESTACAO_UFPR EM, ELEMENTO_UFPR E, MANIFESTACAO_UFPR M "
                + "where EM.ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR = " + idElementoUfprManifestacaoUfpr + " "
                + "and EM.ID_ELEMENTO_UFPR = E.ID_ELEMENTO_UFPR "
                + "and EM.ID_MANIFESTACAO_UFPR = M.ID_MANIFESTACAO_UFPR;";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ElementoUfprManifestacaoUfpr elementoUfprManifestacaoUfpr = null;
        if (rs.next()) {
            elementoUfprManifestacaoUfpr = new ElementoUfprManifestacaoUfpr(rs.getInt("ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR"), 
                    new ElementoUfpr(rs.getInt("ID_ELEMENTO_UFPR"), rs.getString("CD_ELEMENTO"), 
                            rs.getString("DS_ELEMENTO"), rs.getDouble("NR_CAPA1")), 
                    new ManifestacaoUfpr(rs.getInt("ID_MANIFESTACAO_UFPR"), rs.getString("CD_MANIFESTACOES_UFPR"), 
                            rs.getString("DS_MANIFESTACOES_UFPR"), rs.getString("DS_UNIDADE"), rs.getDouble("NR_BETA")));
        }

        conexao.closeConnection();
        return elementoUfprManifestacaoUfpr;
    }
}
