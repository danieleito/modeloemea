/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Inspecao;
import com.model.Modelo;
import com.model.Ponte;
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
public class InspecaoDAO {
    public void excluir(int id) throws SQLException {
        String query = "delete from INSPECAO where ID_INSPECAO = " + id;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute(query);
    }
    
    public void inserir(Inspecao inspecao) throws SQLException {
        String query = "insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO "
                + "values (?, ?, ?, ?);";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        
        PreparedStatement stmt;
        stmt = conn.prepareStatement(query);
        stmt.setDate(1, new java.sql.Date(inspecao.getData().getTime()));
        stmt.setInt(2, inspecao.getUsuario().getId());
        stmt.setInt(3, inspecao.getPonte().getId());
        stmt.setInt(4, inspecao.getModelo().getId());
        stmt.execute();
    }
    
    public ArrayList<Inspecao> buscar() throws SQLException {
        String query = "select I.ID_INSPECAO, I.DT_DATA, I.ID_USUARIO, "
                + "I.DS_CONDICAO_ESTABILIDADE, I.DS_CONDICAO_CONSERVACAO, "
                + "U.ID_USUARIO, U.NM_NOME, U.DS_USUARIO "
                + "from INSPECAO I, USUARIO U "
                + "where I.ID_USUARIO = U.ID_USUARIO;";
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Inspecao> inspecoes = new ArrayList<>();
        
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("ID_USUARIO"));
            usuario.setNome(rs.getString("NM_NOME"));
            usuario.setUsuario(rs.getString("DS_USUARIO"));
            
            Inspecao inspecao = new Inspecao(rs.getInt("ID_INSPECAO"), rs.getDate("DT_DATA"), usuario, 
                    new Ponte(), 
                    new Modelo(rs.getInt("ID_MODELO"), rs.getString("DS_INDICE_BASE"), rs.getString("DS_INDICE_PERFORMANCE")));
            inspecoes.add(inspecao);
        }
        conexao.closeConnection();
        return inspecoes;
    }
    
    public Inspecao buscar(int id) throws SQLException {
        String query = "select I.ID_INSPECAO, I.DT_DATA, I.ID_USUARIO, "
                + "U.ID_USUARIO, U.NM_NOME, U.DS_USUARIO, "
                + "I.ID_PONTE, I.ID_MODELO, M.DS_INDICE_BASE, DS_INDICE_PERFORMANCE "
                
                + "from INSPECAO I, USUARIO U, PONTE P, MODELO M "
                + "where I.ID_USUARIO = U.ID_USUARIO "
                + "and I.ID_PONTE = P.ID_PONTE "
                + "and I.ID_MODELO = M.ID_MODELO "
                + "and I.ID_INSPECAO = " + id + ";";
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Inspecao inspecao = null;
        
        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("ID_USUARIO"));
            usuario.setNome(rs.getString("NM_NOME"));
            usuario.setUsuario(rs.getString("DS_USUARIO"));
            
            inspecao = new Inspecao(rs.getInt("ID_INSPECAO"), rs.getDate("DT_DATA"), usuario, 
                    new Ponte(), 
                    new Modelo(rs.getInt("ID_MODELO"), rs.getString("DS_INDICE_BASE"), rs.getString("DS_INDICE_PERFORMANCE")));
        }
        conexao.closeConnection();
        return inspecao;
    }
    
    //terminar isso
    public ArrayList<Inspecao> buscarInspecao (int idPonte) throws SQLException {
        String query = "select I.ID_INSPECAO, I.DT_DATA, I.ID_USUARIO, U.NM_NOME, U.DS_USUARIO, U.DS_EMAIL, "
                + "I.ID_PONTE, I.ID_MODELO, M.DS_INDICE_BASE, M.DS_INDICE_PERFORMANCE "
                + "from Ponte P, Inspecao I, USUARIO U, MODELO M "
                + "where I.ID_USUARIO = U.ID_USUARIO "
                + "and I.ID_MODELO = M.ID_MODELO "
                + "and I.ID_PONTE = P.ID_PONTE "
                + "and P.ID_PONTE = " + idPonte;

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<Inspecao> inspecoes = new ArrayList<>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("ID_USUARIO"));
            usuario.setNome(rs.getString("NM_NOME"));
            usuario.setUsuario(rs.getString("DS_USUARIO"));
            
            inspecoes.add(new Inspecao(rs.getInt("ID_INSPECAO"), rs.getDate("DT_DATA"), usuario, 
                    new Ponte(rs.getInt("ID_PONTE")), 
                    new Modelo(rs.getInt("ID_MODELO"), rs.getString("DS_INDICE_BASE"), rs.getString("DS_INDICE_PERFORMANCE"))));
        }
        conexao.closeConnection();
        return inspecoes;
    }
}
