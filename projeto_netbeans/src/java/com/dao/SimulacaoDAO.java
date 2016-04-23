/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Simulacao;
import com.model.Usuario;
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
public class SimulacaoDAO {
    public ArrayList<Simulacao> buscar() throws SQLException {
        String query = "SELECT S.ID_SIMULACAO, S.DT_DATA, S.ID_USUARIO, "
                + "S.NM_SIMULACAO, U.NM_NOME, U.DS_USUARIO "
                + "FROM SIMULACAO S, USUARIO U " 
                + "WHERE S.ID_USUARIO = U.ID_USUARIO;";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Simulacao> simulacoes = new ArrayList<>();

        Usuario usuario;
        while (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt("ID_USUARIO"));
            usuario.setNome(rs.getString("DS_USUARIO"));
            usuario.setUsuario(rs.getString("DS_USUARIO"));
            simulacoes.add(new Simulacao(rs.getInt("ID_SIMULACAO"),
                    usuario, rs.getString("NM_SIMULACAO")));
        }

        conexao.closeConnection();
        return simulacoes;
    }

    public void excluir(int id) throws SQLException {
        String query = "delete from SIMULACAO where ID_SIMULACAO = " + id;

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute(query);
    }

    public void inserir(Simulacao simulacao) throws SQLException {
//        String query = "insert into SIMULACAO (DT_DATA, NM_INSPETOR, NM_SIMULACAO) "
//                        + "values(?, ?, ?); ";
        //deletar a linha de baixo e descomentar a linha de cima, depois que o tipo DATE estiver correto
        String query = "insert into SIMULACAO (ID_USUARIO, NM_SIMULACAO) "
                        + "values(?, ?); ";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        PreparedStatement stmt;
        stmt = conn.prepareStatement(query);
        //stmt.setDate(1, simulacao.getData());
        stmt.setInt(1, simulacao.getUsuario().getId());
        stmt.setString(2, simulacao.getSimulacao());
        stmt.execute();
    }
    
    public void editar(Simulacao simulacao) throws SQLException {
        String query = "update SIMULACAO ";
        //query += "set DT_DATA = '" + simulacao.getData()+ "', ";
        query += "set NM_SIMULACAO = '" + simulacao.getSimulacao() + "'";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public Simulacao buscar(int id) throws SQLException {
        String query = "SELECT S.ID_SIMULACAO, S.DT_DATA, S.ID_USUARIO, "
                + "S.NM_SIMULACAO, U.NM_NOME, U.DS_USUARIO "
                + "FROM SIMULACAO S, USUARIO U " 
                + "WHERE S.ID_USUARIO = U.ID_USUARIO "
                + "AND SIM.ID_SIMULACAO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Simulacao simulacao = null;
        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("ID_USUARIO"));
            usuario.setNome(rs.getString("DS_USUARIO"));
            usuario.setUsuario(rs.getString("DS_USUARIO"));
            simulacao = new Simulacao(rs.getInt("ID_SIMULACAO"),
                    usuario, rs.getString("NM_SIMULACAO"));
        }

        conexao.closeConnection();
        return simulacao;
    }
}