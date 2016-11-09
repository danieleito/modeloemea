/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.ArquivoAnexoInspecao;
import com.model.ArquivoAnexoManifestacao;
import com.model.DadosManifestacao;
import com.model.ElementoUfpr;
import com.model.ElementoUfprManifestacaoUfpr;
import com.model.Imagem;
import com.model.Inspecao;
import com.model.InspecaoManifestacaoElemento;
import com.model.ManifestacaoExtensao;
import com.model.ManifestacaoUfpr;
import com.model.ManifestacaoUrgencia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class InspecaoManifestacaoElementoDAO {
    public ArrayList<InspecaoManifestacaoElemento> buscar(int idInspecao) throws SQLException {
        String query = "select IME.ID_INSPECAO_MANIFESTACAO_ELEMENTO, IME.ID_INSPECAO, "
                + "IME.ID_DADOS_MANIFESTACAO, DM.DS_TAMANHO, DM.DS_NUMERO, "
                + "DM.ID_MANIFESTACOES_EXTENSAO, ME.DS_MANIFESTACOES_EXTENSAO, ME.DS_CRITERIO_MANIFESTACOES_EXTENSAO, ME.DS_CAPA2, "
                + "DM.ID_MANIFESTACOES_URGENCIA, MU.DS_MANIFESTACOES_URGENCIA, MU.DS_CRITERIO_MANIFESTACOES_URGENCIA, MU.DS_CAPA4, "
                + "DM.ID_ARQUIVO_ANEXO_INSPECAO, AAI.ID_INSPECAO, AAI.DS_ARQUIVO, AAI.DS_TIPO_ARQUIVO, AAI.NR_NUMERO, "
                + "AAI.DS_DESCRICAO, AAI.DS_REGISTRO, AAI.DT_DATA_ANEXACAO, I.ID_IMAGEM, I.NM_NOME, I.TIPO_MIME, "
                + "IME.ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR, EUMU.ID_ELEMENTO_UFPR, EU.CD_ELEMENTO, EU.DS_ELEMENTO, EU.DS_CAPA1, "
                + "EUMU.ID_MANIFESTACAO_UFPR, MUF.CD_MANIFESTACAO_UFPR, MUF.CD_MANIFESTACAO_UFPR, MUF.DS_MANIFESTACAO_UFPR, MUF.DS_UNIDADE, MUF.DS_BETA, DM.DS_VALOR_DANO " 
                
                + "from INSPECAO_MANIFESTACAO_ELEMENTO IME, DADOS_MANIFESTACAO DM, MANIFESTACOES_EXTENSAO ME, MANIFESTACOES_URGENCIA MU, "
                + "ARQUIVO_ANEXO_INSPECAO AAI, IMAGEM I, ELEMENTO_UFPR_MANIFESTACAO_UFPR EUMU, ELEMENTO_UFPR EU, MANIFESTACAO_UFPR MUF "
                
                + "where IME.ID_DADOS_MANIFESTACAO = DM.ID_DADOS_MANIFESTACAO "
                + "and IME.ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR = EUMU.ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR "
                + "and DM.ID_MANIFESTACOES_EXTENSAO = ME.ID_MANIFESTACOES_EXTENSAO "
                + "and DM.ID_MANIFESTACOES_URGENCIA = MU.ID_MANIFESTACOES_URGENCIA "
                + "and DM.ID_ARQUIVO_ANEXO_INSPECAO = AAI.ID_ARQUIVO_ANEXO_INSPECAO "
                + "and EUMU.ID_ELEMENTO_UFPR = EU.ID_ELEMENTO_UFPR "
                + "and EUMU.ID_MANIFESTACAO_UFPR = MUF.ID_MANIFESTACAO_UFPR "
                + "and AAI.ID_IMAGEM = I. ID_IMAGEM "
                + "and IME.ID_INSPECAO = " + idInspecao;

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<InspecaoManifestacaoElemento> inspecaoManifestacaoElementos = new ArrayList<>();
        
//        DadosManifestacaoDAO

        while (rs.next()) {
            inspecaoManifestacaoElementos.add(new InspecaoManifestacaoElemento(rs.getInt("ID_INSPECAO_MANIFESTACAO_ELEMENTO"), 
                    rs.getInt("ID_INSPECAO"), new DadosManifestacao(rs.getInt("ID_DADOS_MANIFESTACAO"), rs.getString("DS_TAMANHO"), 
                            rs.getString("DS_NUMERO"), new ManifestacaoExtensao(rs.getInt("ID_MANIFESTACOES_EXTENSAO"), 
                                    rs.getString("DS_MANIFESTACOES_EXTENSAO"), rs.getString("DS_CRITERIO_MANIFESTACOES_EXTENSAO"), 
                                    rs.getString("DS_CAPA2")), new ManifestacaoUrgencia(rs.getInt("ID_MANIFESTACOES_URGENCIA"), 
                                            rs.getString("DS_MANIFESTACOES_URGENCIA"), rs.getString("DS_CRITERIO_MANIFESTACOES_URGENCIA"), 
                                            rs.getString("DS_CAPA4")), 
                            new ArquivoAnexoInspecao(rs.getInt("ID_ARQUIVO_ANEXO_INSPECAO"), 
                                    new Inspecao(rs.getInt("ID_INSPECAO")), rs.getString("DS_ARQUIVO"), rs.getString("DS_TIPO_ARQUIVO"), 
                                    rs.getString("NR_NUMERO"), rs.getString("DS_DESCRICAO"), rs.getString("DS_REGISTRO"), 
                                    rs.getDate("DT_DATA_ANEXACAO"), 
                                    new Imagem(rs.getInt("ID_IMAGEM"), rs.getString("NM_NOME"), rs.getString("TIPO_MIME"))), rs.getDouble("DS_VALOR_DANO")), 
                    new ElementoUfprManifestacaoUfpr(rs.getInt("ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR"), new ElementoUfpr(rs.getInt("ID_ELEMENTO_UFPR"), 
                                    rs.getString("CD_ELEMENTO"), rs.getString("DS_ELEMENTO"), rs.getString("DS_CAPA1")), 
                                    new ManifestacaoUfpr(rs.getInt("ID_MANIFESTACAO_UFPR"), rs.getString("CD_MANIFESTACAO_UFPR"), 
                                            rs.getString("DS_MANIFESTACAO_UFPR"), rs.getString("DS_UNIDADE"), rs.getString("DS_BETA")))));
        }

        conexao.closeConnection();
        return inspecaoManifestacaoElementos;
    }
}
