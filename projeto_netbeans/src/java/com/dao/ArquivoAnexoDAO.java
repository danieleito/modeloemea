/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.ArquivoAnexo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class ArquivoAnexoDAO {
    public ArrayList<ArquivoAnexo> buscarCadastro() throws SQLException {
        String query = "select A.ID_ARQUIVO_ANEXO, A.DS_ARQUIVO, A.DS_TIPO_ARQUIVO, "
                + "A.NR_NUMERO, A.DS_DESCRICAO, A.DS_REGISTRO, A.DT_DATA_ANEXACAO  "
                + "from ARQUIVO_ANEXO_CADASTRO A;";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<ArquivoAnexo> arquivos = new ArrayList<>();

        while (rs.next()) {
            arquivos.add(new ArquivoAnexo(rs.getInt("ID_ARQUIVO_ANEXO"), 
                    rs.getString("DS_ARQUIVO"), rs.getString("DS_TIPO_ARQUIVO"), 
                    rs.getString("NR_NUMERO"), rs.getString("DS_DESCRICAO"), 
                    rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO")));
        }

        conexao.closeConnection();
        return arquivos;
    }
    
    public ArquivoAnexo buscarCadastro(int id) throws SQLException {
        String query = "select A.ID_ARQUIVO_ANEXO, A.DS_ARQUIVO, A.DS_TIPO_ARQUIVO, "
                + "A.NR_NUMERO, A.DS_DESCRICAO, A.DS_REGISTRO, A.DT_DATA_ANEXACAO  "
                + "from ARQUIVO_ANEXO A "
                + "and A.ID_ARQUIVO_ANEXO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArquivoAnexo arquivoAnexo = null;
        if (rs.next()) {
            arquivoAnexo = new ArquivoAnexo(rs.getInt("ID_ARQUIVO_ANEXO"), 
                    rs.getString("DS_ARQUIVO"), rs.getString("DS_TIPO_ARQUIVO"), 
                    rs.getString("NR_NUMERO"), rs.getString("DS_DESCRICAO"), 
                    rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO"));
        }

        conexao.closeConnection();
        return arquivoAnexo;
    }
    
    public ArrayList<ArquivoAnexo> buscarInspecao() throws SQLException {
        String query = "select A.ID_ARQUIVO_ANEXO, A.DS_ARQUIVO, A.DS_TIPO_ARQUIVO, "
                + "A.NR_NUMERO, A.DS_DESCRICAO, A.DS_REGISTRO, A.DT_DATA_ANEXACAO  "
                + "from ID_ARQUIVO_ANEXO_INSPECAO A;";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<ArquivoAnexo> arquivos = new ArrayList<>();

        while (rs.next()) {
            arquivos.add(new ArquivoAnexo(rs.getInt("ID_ARQUIVO_ANEXO"), 
                    rs.getString("DS_ARQUIVO"), rs.getString("DS_TIPO_ARQUIVO"), 
                    rs.getString("NR_NUMERO"), rs.getString("DS_DESCRICAO"), 
                    rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO")));
        }

        conexao.closeConnection();
        return arquivos;
    }
    
    public ArquivoAnexo buscar(int id) throws SQLException {
        String query = "select A.ID_ARQUIVO_ANEXO, A.DS_ARQUIVO, A.DS_TIPO_ARQUIVO, "
                + "A.NR_NUMERO, A.DS_DESCRICAO, A.DS_REGISTRO, A.DT_DATA_ANEXACAO  "
                + "from ARQUIVO_ANEXO A "
                + "and A.ID_ARQUIVO_ANEXO_INSPECAO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArquivoAnexo arquivoAnexo = null;
        if (rs.next()) {
            arquivoAnexo = new ArquivoAnexo(rs.getInt("ID_ARQUIVO_ANEXO"), 
                    rs.getString("DS_ARQUIVO"), rs.getString("DS_TIPO_ARQUIVO"), 
                    rs.getString("NR_NUMERO"), rs.getString("DS_DESCRICAO"), 
                    rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO"));
        }

        conexao.closeConnection();
        return arquivoAnexo;
    }
}