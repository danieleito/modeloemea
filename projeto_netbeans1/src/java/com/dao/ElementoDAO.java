/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Elemento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class ElementoDAO {
    public ArrayList<Elemento> buscar() throws SQLException {
        String query = "select E.ID_ELEMENTO, E.NM_ELEMENTO, E.DS_CAPA "
                + "from ELEMENTO E;";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Elemento> elementos = new ArrayList<>();

        while (rs.next()) {
            elementos.add(new Elemento(rs.getInt("ID_ELEMENTO"), rs.getString("NM_ELEMENTO"), 
                    rs.getString("DS_CAPA")));
        }

        conexao.closeConnection();
        return elementos;
    }

    public void excluir(int id) throws SQLException {
        String query = "delete from ELEMENTO where ID_ELEMENTO = " + id;

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute(query);
    }

//    public void inserir(Elemento elemento) throws SQLException {
//        String query = "insert into ELEMENTO (NM_ELEMENTO, DS_CAPA) "
//                        + "values(?, ?); ";
//
//        Conexao conexao = new Conexao();
//        Connection conn = conexao.getConnection();
//
//        PreparedStatement stmt;
//        stmt = conn.prepareStatement(query);
//        stmt.setString(1, elemento.getElemento());
//        stmt.setString(2, elemento.getCapa());
//        stmt.execute();
//    }

    public void editar(Elemento elemento) throws SQLException {
        String query = "update ELEMENTO ";
        query += "set NM_ELEMENTO = '" + elemento.getElemento()+ "', ";
        query += "DS_CAPA = '" + elemento.getCapa()+ "' ";
        query += "where ID_ELEMENTO = " + elemento.getId();

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public Elemento buscar(int id) throws SQLException {
        String query = "select E.ID_ELEMENTO, E.NM_ELEMENTO, E.DS_CAPA "
                + "from ELEMENTO E "
                + "where E.ID_ELEMENTO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Elemento elemento = null;
        if (rs.next()) {
            elemento = new Elemento(rs.getInt("ID_ELEMENTO"), rs.getString("NM_ELEMENTO"), 
                    rs.getString("DS_CAPA"));
        }

        conexao.closeConnection();
        return elemento;
    }

    public Elemento buscar(String nomeElemento) throws SQLException {
        String query = "select E.ID_ELEMENTO, E.NM_ELEMENTO, E.DS_CAPA "
                + "from ELEMENTO E "
                + "where E.NM_ELEMENTO = '" + nomeElemento + "';";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Elemento elemento = null;
        if (rs.next()) {
            elemento = new Elemento(rs.getInt("ID_ELEMENTO"), rs.getString("NM_ELEMENTO"),
                    rs.getString("DS_CAPA"));
        }

        conexao.closeConnection();
        return elemento;
    }

}
