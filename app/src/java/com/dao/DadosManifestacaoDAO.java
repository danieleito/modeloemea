/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.ArquivoAnexoInspecao;
import com.model.ArquivoAnexoManifestacao;
import com.model.DadosManifestacao;
import com.model.Imagem;
import com.model.Inspecao;
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
        String query = "select DM.ID_DADOS_MANIFESTACAO, DM.DS_TAMANHO, DM.DS_NUMERO, "
                + "DM.ID_MANIFESTACOES_EXTENSAO, ME.DS_MANIFESTACOES_EXTENSAO, "
                + "ME.DS_CRITERIO_MANIFESTACOES_EXTENSAO, ME.NR_CAPA2, "
                + "DM.ID_MANIFESTACOES_URGENCIA, MU.DS_MANIFESTACOES_URGENCIA, "
                + "MU.DS_CRITERIO_MANIFESTACOES_URGENCIA, MU.NR_CAPA4, DM.ID_ARQUIVO_ANEXO_INSPECAO, "
                + "AAI.ID_INSPECAO, AAI.DS_ARQUIVO, AAI.DS_TIPO_ARQUIVO, AAI.NR_NUMERO, "
                + "AAI.DS_DESCRICAO, AAI.DS_REGISTRO, AAI.DT_DATA_ANEXACAO, "
                + "I.ID_IMAGEM, I.NM_NOME, I.TIPO_MIME, DM.DS_VALOR_DANO "
                
                + "from DADOS_MANIFESTACAO DM, MANIFESTACOES_EXTENSAO ME, MANIFESTACOES_URGENCIA MU, "
                + "ARQUIVO_ANEXO_INSPECAO AAI, IMAGEM I "
                
                + "where DM.ID_DADOS_MANIFESTACAO = " + idDadosManifestacao + " "
                + "and DM.ID_MANIFESTACOES_EXTENSAO = ME.ID_MANIFESTACOES_EXTENSAO "
                + "and DM.ID_MANIFESTACOES_URGENCIA = MU.ID_MANIFESTACOES_URGENCIA "
                + "and DM.ID_ARQUIVO_ANEXO_INSPECAO = AAI.ID_ARQUIVO_ANEXO_INSPECAO "
                + "and AAI.ID_IMAGEM = I.ID_IMAGEM;";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        DadosManifestacao dadosManifestacao = null;
        if (rs.next()) {
            dadosManifestacao = new DadosManifestacao(rs.getInt("ID_DADOS_MANIFESTACAO"), rs.getString("DS_TAMANHO"), 
                    rs.getString("DS_NUMERO"), 
                    new ManifestacaoExtensao(rs.getInt("ID_MANIFESTACOES_EXTENSAO"), rs.getString("DS_MANIFESTACOES_EXTENSAO"), 
                            rs.getString("DS_CRITERIO_MANIFESTACOES_EXTENSAO"), rs.getDouble("NR_CAPA2")), 
                    new ManifestacaoUrgencia(rs.getInt("ID_MANIFESTACOES_URGENCIA"), rs.getString("DS_MANIFESTACOES_URGENCIA"), 
                            rs.getString("DS_CRITERIO_MANIFESTACOES_URGENCIA"), rs.getDouble("NR_CAPA4")), 
                    new ArquivoAnexoInspecao(rs.getInt("ID_ARQUIVO_ANEXO_INSPECAO"), new Inspecao(rs.getInt("ID_INSPECAO")), 
                            rs.getString("DS_ARQUIVO"), rs.getString("DS_TIPO_ARQUIVO"), rs.getString("NR_NUMERO"), 
                            rs.getString("DS_DESCRICAO"), rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO"), 
                            new Imagem(rs.getInt("ID_IMAGEM"), rs.getString("NM_NOME"), rs.getString("TIPO_MIME"))), 
                    rs.getDouble("DS_VALOR_DANO"));
        }

        conexao.closeConnection();
        return dadosManifestacao;
    }
}
