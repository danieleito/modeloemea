/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.model.TipoUsuario;

/**
 *
 * @author Daniele Harumi Ito
 */
public class UsuarioDAO {
    public ArrayList<Usuario> buscar() throws SQLException {
        String query = "select USU.ID_USUARIO, USU.NM_NOME, USU.DS_USUARIO, USU.DS_EMAIL, USU.DS_SENHA,  "
                + "USU.ID_TIPO_USUARIO, TUS.DS_TIPO "
                + "from USUARIO USU, TIPO_USUARIO TUS "
                + "where USU.ID_TIPO_USUARIO = TUS.ID_TIPO_USUARIO; ";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Usuario> usuarios = new ArrayList<>();

        while (rs.next()) {
            usuarios.add(new Usuario(rs.getInt("ID_USUARIO"), rs.getString("NM_NOME"),
                    rs.getString("DS_USUARIO"), rs.getString("DS_EMAIL"),rs.getString("DS_SENHA"), 
                    new TipoUsuario(rs.getInt("ID_TIPO_USUARIO"), rs.getString("DS_TIPO"))));
        }

        conexao.closeConnection();
        return usuarios;
    }

    public void excluir(int id) throws SQLException {
        String query = "delete from USUARIO where ID_USUARIO = " + id;

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute(query);
    }

    public void inserir(Usuario usuario) throws SQLException {
        String query = "insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) "
                        + "values(?, ?, ?, ?, ?); ";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        PreparedStatement stmt;
        stmt = conn.prepareStatement(query);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getUsuario());
        stmt.setString(3, usuario.getEmail());
        stmt.setString(4, usuario.getSenha());
        stmt.setInt(5, usuario.getTipoUsuario().getId());
        stmt.execute();
    }

    public void editar(Usuario usuario) throws SQLException {
        String query = "update USUARIO ";
        query += "set NM_NOME = '" + usuario.getNome() + "', ";
        query += "DS_EMAIL = '" + usuario.getEmail()+ "', ";
        query += "DS_USUARIO = '" + usuario.getUsuario()+ "', ";
        query += "DS_SENHA = '" + usuario.getSenha()+ "', ";
        query += "ID_TIPO_USUARIO = " + usuario.getTipoUsuario().getId()+ " ";
        query += "where ID_USUARIO = " + usuario.getId();

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public Usuario buscar(int id) throws SQLException {
        String query = "select USU.ID_USUARIO, USU.NM_NOME, USU.DS_USUARIO, USU.DS_EMAIL, USU.DS_SENHA,  "
                + "USU.ID_TIPO_USUARIO, TUS.DS_TIPO "
                + "from USUARIO USU, TIPO_USUARIO TUS "
                + "where USU.ID_TIPO_USUARIO = TUS.ID_TIPO_USUARIO "
                + "and USU.ID_USUARIO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Usuario usuario = null;
        if (rs.next()) {
            usuario = new Usuario(rs.getInt("ID_USUARIO"), rs.getString("NM_NOME"),
                    rs.getString("DS_USUARIO"), rs.getString("DS_EMAIL"),rs.getString("DS_SENHA"), 
                    new TipoUsuario(rs.getInt("ID_TIPO_USUARIO"), rs.getString("DS_TIPO")));
        }

        conexao.closeConnection();
        return usuario;
    }

    public Usuario buscar(String nomeUsuario) throws SQLException {
        String query = "select USU.ID_USUARIO, USU.NM_NOME, USU.DS_USUARIO, USU.DS_EMAIL, USU.DS_SENHA,  "
                + "USU.ID_TIPO_USUARIO, TUS.DS_TIPO "
                + "from USUARIO USU, TIPO_USUARIO TUS "
                + "where USU.ID_TIPO_USUARIO = TUS.ID_TIPO_USUARIO "
                + "and USU.DS_USUARIO = '" + nomeUsuario + "';";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Usuario usuario = null;
        if (rs.next()) {
            usuario = new Usuario(rs.getInt("ID_USUARIO"), rs.getString("NM_NOME"),
                    rs.getString("DS_USUARIO"), rs.getString("DS_EMAIL"),rs.getString("DS_SENHA"), 
                    new TipoUsuario(rs.getInt("ID_TIPO_USUARIO"), rs.getString("DS_TIPO")));
        }

        conexao.closeConnection();
        return usuario;
    }

    public boolean usuarioExiste(String nomeUsuario) throws SQLException {
        String query = "select NM_NOME from USUARIO "
                + "where DS_USUARIO =  '" + nomeUsuario + "';";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        if (rs.next()) {
            return true;
        }
        return false;
    }

    public boolean conferirUsuarioSenha(Usuario usuario) throws SQLException {
        String query = "select DS_USUARIO, DS_SENHA from USUARIO "
                + "where DS_USUARIO = '" + usuario.getUsuario() + "' "
                + "and DS_SENHA = " + usuario.getSenha() + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        if (rs.next()) {
            return true;
        }
        return false;
    }
}