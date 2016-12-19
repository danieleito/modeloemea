/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.DanoElementoSgo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class DanoElementoSgoDAO {
    public ArrayList<DanoElementoSgo> buscarDanosElementosSgo(int id) throws SQLException {
        String query = "select D.ID_DANOS_ELEMENTOS_SGO, I.ID_INSPECAO, D.DS_ELEMENTO, "
                + "D.DS_NOTA, D.DS_DANO, D.DS_UNIDADE, D.DS_QUANTIDADE, D.DS_EXTENSAO_RELATIVA, "
                + "D.DS_LOCALIZACAO "
                + "from DANOS_ELEMENTOS_SGO D, INSPECAO I "
                + "where D.ID_INSPECAO = I.ID_INSPECAO "
                + "and I.ID_INSPECAO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<DanoElementoSgo> danoElementoSgo = new ArrayList<>();
 
        while (rs.next()) {     
            danoElementoSgo.add(new DanoElementoSgo(rs.getInt("ID_DANOS_ELEMENTOS_SGO"), rs.getString("DS_ELEMENTO"), 
                    rs.getString("DS_NOTA"), rs.getString("DS_DANO"), rs.getString("DS_UNIDADE"), 
                    rs.getString("DS_QUANTIDADE"), rs.getString("DS_EXTENSAO_RELATIVA"), rs.getString("DS_LOCALIZACAO")));
        }

        conexao.closeConnection();
        return danoElementoSgo;
    }
}
