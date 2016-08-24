/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.DadosManifestacao;
import com.model.ManifestacaoExtensao;
import com.model.ManifestacaoUrgencia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniele Harumi Ito
 */
public class DadosManifestacaoDAO {
    public DadosManifestacao buscar(int idDadosManifestacao) throws SQLException {
        String query = "select DM.ID_DADOS_MANIFESTACAO, DM.DS_FOTO, DM.DS_TAMANHO, DM.DS_NUMERO, "
                + "DM.ID_MANIFESTACOES_EXTENSAO, ME.DS_MANIFESTACOES_EXTENSAO, "
                + "ME.DS_CRITERIO_MANIFESTACOES_EXTENSAO, ME.DS_CAPA2, "
                + "DM.ID_MANIFESTACOES_URGENCIA, MU.DS_MANIFESTACOES_URGENCIA, "
                + "MU.DS_CRITERIO_MANIFESTACOES_URGENCIA, MU.DS_CAPA4 "
                + "from DADOS_MANIFESTACAO DM, MANIFESTACOES_EXTENSAO ME, MANIFESTACOES_URGENCIA MU "
                + "where DM.ID_DADOS_MANIFESTACAO = " + idDadosManifestacao + " "
                + "and DM.ID_MANIFESTACOES_EXTENSAO = DE.ID_MANIFESTACOES_EXTENSAO "
                + "and DM.ID_MANIFESTACOES_URGENCIA = MU.ID_MANIFESTACOES_URGENCIA;";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        DadosManifestacao dadosManifestacao = null;
        if (rs.next()) {
            dadosManifestacao = new DadosManifestacao(rs.getInt("ID_DADOS_MANIFESTACAO"), rs.getString("DS_FOTO"), 
                    rs.getString("DS_TAMANHO"), rs.getString("DS_NUMERO"), 
                    new ManifestacaoExtensao(rs.getInt("ID_MANIFESTACOES_EXTENSAO"), rs.getString("DS_MANIFESTACOES_EXTENSAO"), 
                            rs.getString("DS_CRITERIO_MANIFESTACOES_EXTENSAO"), rs.getString("DS_CAPA2")), 
                    new ManifestacaoUrgencia(rs.getInt("ID_MANIFESTACOES_URGENCIA"), rs.getString("DS_MANIFESTACOES_URGENCIA"), 
                            rs.getString("DS_CRITERIO_MANIFESTACOES_URGENCIA"), rs.getString("DS_CAPA4")));
        }

        conexao.closeConnection();
        return dadosManifestacao;
    }
}