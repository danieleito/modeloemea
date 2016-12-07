/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.ArquivoAnexoCadastro;
import com.model.ArquivoAnexoInspecao;
import com.model.ArquivoAnexoManifestacao;
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
//    metodos relacionados com arquivos anexos cadastro;
    public ArrayList<ArquivoAnexoCadastro> buscarCadastros(int id) throws SQLException {
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
            arquivos.add(new ArquivoAnexoCadastro(rs.getInt("ID_ARQUIVO_ANEXO_CADASTRO"), 
                    rs.getString("DS_ARQUIVO"), rs.getString("DS_TIPO_ARQUIVO"), rs.getString("NR_NUMERO"), 
                    rs.getString("DS_DESCRICAO"), rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO"), 
                    new Imagem(rs.getInt("ID_IMAGEM"), rs.getString("NM_NOME"), rs.getString("TIPO_MIME"))));
        }

        conexao.closeConnection();
        return arquivos;
    }

    public ArquivoAnexoCadastro buscarCadastro(int id) throws SQLException {
        String query = "select A.ID_ARQUIVO_ANEXO_CADASTRO, A.ID_PONTE, A.DS_ARQUIVO, A.DS_TIPO_ARQUIVO, "
                + "A.NR_NUMERO, A.DS_DESCRICAO, A.DS_REGISTRO, A.DT_DATA_ANEXACAO, A.ID_IMAGEM, I.NM_NOME, "
                + "I.TIPO_MIME, "
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

            arquivoAnexo = new ArquivoAnexoCadastro(rs.getInt("ID_ARQUIVO_ANEXO_CADASTRO"), rs.getString("DS_ARQUIVO"), 
                    rs.getString("DS_TIPO_ARQUIVO"), rs.getString("NR_NUMERO"), rs.getString("DS_DESCRICAO"), 
                    rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO"), 
                    new Imagem(rs.getInt("ID_IMAGEM"), rs.getString("NM_NOME"), rs.getString("TIPO_MIME")));
        }

        conexao.closeConnection();
        return arquivoAnexo;
    }


//    metodos relacionados com arquivos anexos inspecao
    public ArrayList<ArquivoAnexoInspecao> buscarInspecoes(int id) throws SQLException {
        String query = "select A.ID_ARQUIVO_ANEXO_INSPECAO, A.ID_INSPECAO, A.DS_ARQUIVO, A.DS_TIPO_ARQUIVO, "
                + "A.NR_NUMERO, A.DS_DESCRICAO, A.DS_REGISTRO, A.DT_DATA_ANEXACAO, A.ID_IMAGEM, I.NM_NOME, "
                + "I.TIPO_MIME, "
                + "(SELECT DS_CAMINHO_IMAGEM FROM CONFIGURACAO) AS CAMINHO "
                + "from ARQUIVO_ANEXO_INSPECAO A, IMAGEM I, INSPECAO INS "
                + "where A.ID_INSPECAO = INS.ID_INSPECAO "
                + "and A.ID_IMAGEM = I.ID_IMAGEM "
                + "and INS.ID_INSPECAO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<ArquivoAnexoInspecao> arquivos = new ArrayList<>();

        while (rs.next()) {     
            arquivos.add(new ArquivoAnexoInspecao(rs.getInt("ID_ARQUIVO_ANEXO_INSPECAO"), new Inspecao(rs.getInt("ID_INSPECAO")), rs.getString("DS_ARQUIVO"), 
                    rs.getString("DS_TIPO_ARQUIVO"), rs.getString("NR_NUMERO"), rs.getString("DS_DESCRICAO"), rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO"), 
                    new Imagem(rs.getInt("ID_IMAGEM"), rs.getString("NM_NOME"), rs.getString("TIPO_MIME"))));
        }

        conexao.closeConnection();
        return arquivos;
    }

    public ArquivoAnexoInspecao buscarInspecao(int id) throws SQLException {
        String query = "select A.ID_ARQUIVO_ANEXO_INSPECAO, A.ID_INSPECAO, A.DS_ARQUIVO, A.DS_TIPO_ARQUIVO, "
                + "A.NR_NUMERO, A.DS_DESCRICAO, A.DS_REGISTRO, A.DT_DATA_ANEXACAO, A.ID_IMAGEM, I.NM_NOME, "
                + "I.TIPO_MIME, "
                + "(SELECT DS_CAMINHO_IMAGEM FROM CONFIGURACAO) AS CAMINHO "
                + "from ARQUIVO_ANEXO_INSPECAO A, IMAGEM I, INSPECAO INS "
                + "where A.ID_INSPECAO = INS.ID_INSPECAO "
                + "and A.ID_IMAGEM = I.ID_IMAGEM "
                + "and A.ID_ARQUIVO_ANEXO_INSPECAO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArquivoAnexoInspecao arquivoAnexo = null;
        if (rs.next()) {
            arquivoAnexo = new ArquivoAnexoInspecao(rs.getInt("ID_ARQUIVO_ANEXO_INSPECAO"), new Inspecao(rs.getInt("ID_INSPECAO")), 
                    rs.getString("DS_ARQUIVO"), rs.getString("DS_TIPO_ARQUIVO"), rs.getString("NR_NUMERO"), 
                    rs.getString("DS_DESCRICAO"), rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO"), 
                    new Imagem(rs.getInt("ID_IMAGEM"), rs.getString("NM_NOME"), rs.getString("TIPO_MIME")));
        }

        conexao.closeConnection();
        return arquivoAnexo;
    }


//    metodos relacionados com arquivos anexos manifestacao
    public ArrayList<ArquivoAnexoManifestacao> buscarManifestacoes(int id) throws SQLException {
        String query = "select A.ID_ARQUIVO_ANEXO_MANIFESTACAO, A.DS_TIPO_ARQUIVO, A.NR_NUMERO, A.DS_DESCRICAO, A.DS_REGISTRO, "
                + "A.DT_DATA_ANEXACAO, A.ID_IMAGEM, I.NM_NOME, I.TIPO_MIME "
                + "from ARQUIVO_ANEXO_MANIFESTACAO A, IMAGEM I "
                + "where A.ID_IMAGEM = I.ID_IMAGEM "
                + "and A.ID_ARQUIVO_ANEXO_MANIFESTACAO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<ArquivoAnexoManifestacao> arquivos = new ArrayList<>();

        while (rs.next()) {     
            arquivos.add(new ArquivoAnexoManifestacao(rs.getInt("ID_ARQUIVO_ANEXO_MANIFESTACAO"), rs.getString("DS_TIPO_ARQUIVO"), 
                    rs.getString("NR_NUMERO"), rs.getString("DS_DESCRICAO"), rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO"), 
                    new Imagem(rs.getInt("ID_IMAGEM"), rs.getString("NM_NOME"), rs.getString("TIPO_MIME"))));
        }

        conexao.closeConnection();
        return arquivos;
    }

    public ArquivoAnexoManifestacao buscarManifestacao(int id) throws SQLException {
        String query = "select A.ID_ARQUIVO_ANEXO_MANIFESTACAO, A.DS_TIPO_ARQUIVO, A.NR_NUMERO, A.DS_DESCRICAO, A.DS_REGISTRO, "
                + "A.DT_DATA_ANEXACAO, A.ID_IMAGEM, I.NM_NOME, I.TIPO_MIME "
                + "from ARQUIVO_ANEXO_MANIFESTACAO A, IMAGEM I "
                + "where A.ID_IMAGEM = I.ID_IMAGEM "
                + "and A.ID_ARQUIVO_ANEXO_MANIFESTACAO = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArquivoAnexoManifestacao arquivoAnexo = null;
        if (rs.next()) {
            arquivoAnexo = new ArquivoAnexoManifestacao(rs.getInt("ID_ARQUIVO_ANEXO_MANIFESTACAO"), rs.getString("DS_TIPO_ARQUIVO"), 
                    rs.getString("NR_NUMERO"), rs.getString("DS_DESCRICAO"), rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO"), 
                    new Imagem(rs.getInt("ID_IMAGEM"), rs.getString("NM_NOME"), rs.getString("TIPO_MIME")));
        }

        conexao.closeConnection();
        return arquivoAnexo;
    }
}