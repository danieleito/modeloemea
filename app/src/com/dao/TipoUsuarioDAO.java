/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.TipoUsuario;
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
public class TipoUsuarioDAO {
    public void inserir(TipoUsuario tipoUsuario) throws SQLException {
        String query = "insert into TIPO_USUARIO (DS_TIPO)"
                        + "values(?); ";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        PreparedStatement stmt;
        stmt = conn.prepareStatement(query);
        stmt.setString(1, tipoUsuario.getTipoUsuario());
        stmt.execute();
    }

    public ArrayList<TipoUsuario> buscar() throws SQLException {
        String query = "select ID_TIPO_USUARIO, DS_TIPO from TIPO_USUARIO; ";
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<TipoUsuario> tipos = new ArrayList<>();

        while (rs.next()) {
            tipos.add(new TipoUsuario(rs.getInt("ID_TIPO_USUARIO"), rs.getString("DS_TIPO")));
        }

        conexao.closeConnection();
        return tipos;
    }
}