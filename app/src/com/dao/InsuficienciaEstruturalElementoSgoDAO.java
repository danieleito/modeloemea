/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.InsuficienciaEstruturalElementoSgo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class InsuficienciaEstruturalElementoSgoDAO {
    public ArrayList<InsuficienciaEstruturalElementoSgo> buscarInsuficienciasEstruturaisElementosSgo(int id) throws SQLException {
        String query = "select E.ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO, I.ID_INSPECAO, "
                + "E.DS_ELEMENTO, E.DS_NOTA, E.DS_INSUFICIENCIA, E.DS_CAUSA_PROVAVEL, "
                + "E.DS_COMENTARIOS "
                + "from INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO E, INSPECAO I "
                + "where E.ID_INSPECAO = I.ID_INSPECAO "
                + "and I.ID_INSPECAO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<InsuficienciaEstruturalElementoSgo> insuficienciaEstruturalElementoSgo = new ArrayList<>();
 
        while (rs.next()) {     
            insuficienciaEstruturalElementoSgo.add(new InsuficienciaEstruturalElementoSgo(rs.getInt("ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO"), 
                    rs.getString("DS_ELEMENTO"), rs.getString("DS_NOTA"), rs.getString("DS_INSUFICIENCIA"), 
                    rs.getString("DS_CAUSA_PROVAVEL"), rs.getString("DS_COMENTARIOS")));
        }

        conexao.closeConnection();
        return insuficienciaEstruturalElementoSgo;
    }
}
