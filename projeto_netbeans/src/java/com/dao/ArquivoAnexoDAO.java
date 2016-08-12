/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.ArquivoAnexoCadastro;
import com.model.ArquivoAnexoInspecao;
import com.model.Imagem;
import com.model.Inspecao;
import com.model.Ponte;
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
    public ArrayList<ArquivoAnexoCadastro> buscarCadastro(int id) throws SQLException {
        String query = "select A.ID_ARQUIVO_ANEXO_CADASTRO, A.ID_PONTE, A.DS_ARQUIVO, "
                + "A.DS_TIPO_ARQUIVO, A.NR_NUMERO, A.DS_DESCRICAO, A.DS_REGISTRO, "
                + "A.DT_DATA_ANEXACAO, A.ID_IMAGEM, I.NM_NOME, I.TIPO_MIME, "
                + "(SELECT DS_CAMINHO_IMAGEM FROM CONFIGURACAO) AS CAMINHO "
                + "from ARQUIVO_ANEXO_CADASTRO A, IMAGEM I, PONTE P "
                + "where A.ID_IMAGEM = I.ID_IMAGEM "
                + "and A.ID_PONTE = P.ID_PONTE "
                + "and A.ID_PONTE = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<ArquivoAnexoCadastro> arquivos = new ArrayList<>();

        while (rs.next()) {
            arquivos.add(new ArquivoAnexoCadastro(rs.getInt("ID_ARQUIVO_ANEXO_CADASTRO"), new Ponte(rs.getInt("ID_PONTE")), rs.getString("DS_ARQUIVO"), rs.getString("DS_TIPO_ARQUIVO"), rs.getString("NR_NUMERO"), 
                    rs.getString("DS_DESCRICAO"), rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO"), 
                    new Imagem(rs.getInt("ID_IMAGEM"), rs.getString("NM_NOME"), rs.getString("TIPO_MIME"), rs.getString("CAMINHO"))));
        }

        conexao.closeConnection();
        return arquivos;
    }
    
    public ArquivoAnexoCadastro buscarCadastros(int id) throws SQLException {
        String query = "select A.ID_ARQUIVO_ANEXO_CADASTRO, A.ID_PONTE, A.DS_ARQUIVO, A.DS_TIPO_ARQUIVO, "
                + "A.NR_NUMERO, A.DS_DESCRICAO, A.DS_REGISTRO, A.DT_DATA_ANEXACAO, A.ID_IMAGEM, I.NM_NOME, "
                + "I.TIPO_MIME, I.DS_IMAGEM, "
                + "(SELECT DS_CAMINHO_IMAGEM FROM CONFIGURACAO) AS CAMINHO "
                + "from ARQUIVO_ANEXO_CADASTRO A, IMAGEM I, PONTE P "
                + "where A.ID_IMAGEM = I.ID_IMAGEM "
                + "and P.ID_PONTE = P.ID_PONTE "
                + "and A.ID_ARQUIVO_ANEXO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArquivoAnexoCadastro arquivoAnexo = null;
        if (rs.next()) {
            Ponte p = new Ponte();
            p.setId(rs.getInt("ID_PONTE"));
            
            arquivoAnexo = new ArquivoAnexoCadastro(rs.getInt("ID_ARQUIVO_ANEXO_CADASTRO"), new Ponte(rs.getInt("ID_PONTE")), rs.getString("DS_ARQUIVO"), 
                    rs.getString("DS_TIPO_ARQUIVO"), rs.getString("NR_NUMERO"), rs.getString("DS_DESCRICAO"), 
                    rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO"), 
                    new Imagem(rs.getInt("ID_IMAGEM"), rs.getString("NM_NOME"), rs.getString("TIPO_MIME"), rs.getString("CAMINHO")));
        }

        conexao.closeConnection();
        return arquivoAnexo;
    }
    
    public ArrayList<ArquivoAnexoCadastro> buscarInspecao() throws SQLException {
        String query = "select A.ID_ARQUIVO_ANEXO_INSPECAO, A.ID_INSPECAO, A.DS_ARQUIVO, A.DS_TIPO_ARQUIVO, "
                + "A.NR_NUMERO, A.DS_DESCRICAO, A.DS_REGISTRO, A.DT_DATA_ANEXACAO, A.ID_IMAGEM, I.NM_NOME, "
                + "I.TIPO_MIME, "
                + "(SELECT DS_CAMINHO_IMAGEM FROM CONFIGURACAO) AS CAMINHO "
                + "from ARQUIVO_ANEXO_INSPECAO A, IMAGEM I, INSPECAO INS "
                + "where A.ID_INSPECAO = INS.ID_INSPECAO "
                + "and A.ID_IMAGEM = I.ID_IMAGEM ";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<ArquivoAnexoCadastro> arquivos = new ArrayList<>();
 
        while (rs.next()) {
            arquivos.add(new ArquivoAnexoInspecao(rs.getInt("ID_ARQUIVO_ANEXO_INSPECAO"), new Inspecao(rs.getInt("ID_INSPECAO")), rs.getString("DS_ARQUIVO"), 
                    rs.getString("DS_TIPO_ARQUIVO"), rs.getString("NR_NUMERO"), rs.getString("DS_DESCRICAO"), rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO"), 
                    new Imagem(rs.getInt("ID_IMAGEM"), rs.getString("NM_NOME"), rs.getString("TIPO_MIME"), rs.getString("CAMINHO"))));
        }

        conexao.closeConnection();
        return arquivos;
    }
    
    public ArquivoAnexoCadastro buscarInspecao(int id) throws SQLException {
        String query = "select A.ID_ARQUIVO_ANEXO_INSPECAO, A.ID_INSPECAO, A.DS_ARQUIVO, A.DS_TIPO_ARQUIVO, "
                + "A.NR_NUMERO, A.DS_DESCRICAO, A.DS_REGISTRO, A.DT_DATA_ANEXACAO, A.ID_IMAGEM, I.NM_NOME, "
                + "I.TIPO_MIME, I.DS_IMAGEM "
                + "(SELECT DS_CAMINHO_IMAGEM FROM CONFIGURACAO) AS CAMINHO "
                + "from ARQUIVO_ANEXO_INSPECAO A, IMAGEM I, INSPECAO INS "
                + "where A.ID_IMAGEM = I.ID_IMAGEM "
                + "and P.ID_INSPECAO = INS.ID_INSPECAO "
                + "and A.ID_ARQUIVO_ANEXO_INSPECAO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArquivoAnexoCadastro arquivoAnexo = null;
        if (rs.next()) {
            arquivoAnexo = new ArquivoAnexoCadastro(rs.getInt("ID_ARQUIVO_ANEXO_INSPECAO"), new Ponte(rs.getInt("ID_PONTE")), rs.getString("DS_ARQUIVO"), rs.getString("DS_TIPO_ARQUIVO"), 
                    rs.getString("NR_NUMERO"), rs.getString("DS_DESCRICAO"), rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO"), 
                    new Imagem(rs.getInt("ID_IMAGEM"), rs.getString("NM_NOME"), rs.getString("TIPO_MIME"), rs.getString("CAMINHO")));
        }

        conexao.closeConnection();
        return arquivoAnexo;
    }
}