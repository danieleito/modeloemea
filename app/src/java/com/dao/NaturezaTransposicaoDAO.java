/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.NaturezaTransposicao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class NaturezaTransposicaoDAO {
    public ArrayList<NaturezaTransposicao> buscar() throws SQLException {
        String query = "select ID_NATUREZA_TRANSPOSICAO, DS_NATUREZA_TRANSPOSICAO "
                + "from NATUREZA_TRANSPOSICAO; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<NaturezaTransposicao> naturezaTransposicao = new ArrayList<>();

        while (rs.next()) {
            naturezaTransposicao.add(new NaturezaTransposicao(rs.getInt("ID_NATUREZA_TRANSPOSICAO"), 
                    rs.getString("DS_NATUREZA_TRANSPOSICAO")));
        }

        conexao.closeConnection();
        return naturezaTransposicao;
    }
    
}
