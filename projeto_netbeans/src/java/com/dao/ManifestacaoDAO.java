/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Manifestacao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class ManifestacaoDAO {
    public ArrayList<Manifestacao> buscar() throws SQLException {
        String query = "select M.ID_MANIFESTACAO, M.NM_MANIFESTACAO, M.DS_BETA  "
                + "from MANIFESTACAO M;";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Manifestacao> manifestacoes = new ArrayList<>();

        while (rs.next()) {
            manifestacoes.add(new Manifestacao(rs.getInt("ID_MANIFESTACAO"), rs.getString("NM_MANIFESTACAO"),
                    rs.getString("DS_BETA")));
        }

        conexao.closeConnection();
        return manifestacoes;
    }

    public void excluir(int id) throws SQLException {
        String query = "delete from MANIFESTACAO where ID_MANIFESTACAO = " + id;

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute(query);
    }

    public void editar(Manifestacao manifestacao) throws SQLException {
        String query = "update MANIFESTACAO ";
        query += "set NM_MANIFESTACAO = '" + manifestacao.getManifestacao()+ "', ";
        query += "DS_BETA = '" + manifestacao.getBeta()+ "' ";
        query += "where ID_MANIFESTACAO = " + manifestacao.getId();

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public Manifestacao buscar(int id) throws SQLException {
        String query = "select M.ID_MANIFESTACAO, M.NM_MANIFESTACAO, M.DS_BETA  "
                + "from MANIFESTACAO M "
                + "and M.ID_MANIFESTACAO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Manifestacao manifestacao = null;
        if (rs.next()) {
            manifestacao = new Manifestacao(rs.getInt("ID_MANIFESTACAO"), rs.getString("NM_MANIFESTACAO"),
                    rs.getString("DS_BETA"));
        }

        conexao.closeConnection();
        return manifestacao;
    }

    public Manifestacao buscar(String nomeManifestacao) throws SQLException {
        String query = "select M.ID_MANIFESTACAO, M.NM_MANIFESTACAO, M.DS_BETA "
                + "from MANIFESTACAO M "
                + "where M.NM_MANIFESTACAO = '" + nomeManifestacao + "';";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Manifestacao manifestacao = null;
        if (rs.next()) {
            manifestacao = new Manifestacao(rs.getInt("ID_MANIFESTACAO"), rs.getString("NM_MANIFESTACAO"),
                    rs.getString("DS_BETA"));
        }

        conexao.closeConnection();
        return manifestacao;
    }
}