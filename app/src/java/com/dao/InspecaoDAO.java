/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

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
import com.model.Modelo;
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
        stmt.setInt(3, inspecao.getIdPonte());
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
                    new Modelo(rs.getInt("ID_MODELO"), rs.getString("DS_INDICE_BASE"), rs.getString("DS_INDICE_PERFORMANCE")));
        }
        conexao.closeConnection();
        return inspecao;
    }

    public ArrayList<Inspecao> buscarInspecao (int idPonte) throws SQLException {
        String query = "select I.ID_INSPECAO, I.DT_DATA, I.ID_USUARIO, "
                + "I.ID_PONTE, I.ID_MODELO, I.ID_IDENTIFICACAO_OBRA_SGO, "
                + "I.ID_CONDICOES_SGO, I.ID_LAUDO_ESPECIALIZADO_SGO, "
                + "I.ID_MONITORAMENTO_SGO, I.DS_RELATORIO "
                + "from Inspecao I "
                + "where I.ID_PONTE = " + idPonte;

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<Inspecao> inspecoes = new ArrayList<>();
        UsuarioDAO dbUsuario = new UsuarioDAO();
        ModeloDAO dbModelo = new ModeloDAO();
        ArquivoAnexoDAO dbArquivoAnexo = new ArquivoAnexoDAO();
        IdentificacaoObraSgoDAO dbIdentificacaoObraSgo = new IdentificacaoObraSgoDAO();
        CondicaoSgoDAO dbCondicaoSgo = new CondicaoSgoDAO();
        LaudoEspecializadoSgoDAO dbLaudoEspecializadoSgo = new LaudoEspecializadoSgoDAO();
        MonitoramentoSgoDAO dbMonitoramentoSgo = new MonitoramentoSgoDAO();
        DanoElementoSgoDAO dbDanoElementoSgo = new DanoElementoSgoDAO();
        InsuficienciaEstruturalElementoSgoDAO dbInsuficienciaEstruturalElementoSgo = new InsuficienciaEstruturalElementoSgoDAO();

        Inspecao inspecao;
        while (rs.next()) {
            inspecao = new Inspecao();
            inspecao.setId(rs.getInt("ID_INSPECAO"));
            inspecao.setData(rs.getDate("DT_DATA"));
            inspecao.setUsuario(dbUsuario.buscar(rs.getInt("ID_USUARIO")));
            inspecao.setModelo(dbModelo.buscar(rs.getInt("ID_MODELO")));
            inspecao.setIdentificacaoObraSgo(dbIdentificacaoObraSgo.buscar(rs.getInt("ID_IDENTIFICACAO_OBRA_SGO")));
            inspecao.setCondicaoSgo(dbCondicaoSgo.buscar(rs.getInt("ID_CONDICOES_SGO")));
            inspecao.setLaudoEspecializadoSgo(dbLaudoEspecializadoSgo.buscar(rs.getInt("ID_LAUDO_ESPECIALIZADO_SGO")));
            inspecao.setMonitoramentoSgo(dbMonitoramentoSgo.buscar(rs.getInt("ID_MONITORAMENTO_SGO")));
            inspecao.setRelatorio(rs.getString("DS_RELATORIO"));
            inspecao.setDanosElementosSgo(dbDanoElementoSgo.buscarDanosElementosSgo(rs.getInt("ID_INSPECAO")));
            inspecao.setInsuficienciasEstruturaisElementosSgo(dbInsuficienciaEstruturalElementoSgo.buscarInsuficienciasEstruturaisElementosSgo(rs.getInt("ID_INSPECAO")));
            inspecao.setArquivosAnexosInspecao(dbArquivoAnexo.buscarInspecoes(rs.getInt("ID_INSPECAO")));
            inspecao.setInspecaoManifestacaoElemento(buscarInspecaoManifestacaoElemento(rs.getInt("ID_INSPECAO")));
            inspecoes.add(inspecao);
        }
        conexao.closeConnection();
        return inspecoes;
    }
    
    private ArrayList<InspecaoManifestacaoElemento> buscarInspecaoManifestacaoElemento(int idInspecao) throws SQLException {
        String query = "select IME.ID_INSPECAO_MANIFESTACAO_ELEMENTO, IME.ID_INSPECAO, "
                + "IME.ID_DADOS_MANIFESTACAO, DM.DS_FOTO, DM.DS_NUMERO, DM.DS_TAMANHO, "
                + "DM.ID_MANIFESTACOES_EXTENSAO, ME.DS_MANIFESTACOES_EXTENSAO, "
                + "DM.ID_MANIFESTACOES_URGENCIA, MURG.DS_MANIFESTACOES_URGENCIA, "
                + "IME.ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR, EUMU.ID_ELEMENTO_UFPR, "
                + "EU.DS_ELEMENTO, EUMU.ID_MANIFESTACAO_UFPR, MU.DS_MANIFESTACAO_UFPR, "
                + "MU.DS_UNIDADE, AAM.ID_ARQUIVO_ANEXO_MANIFESTACAO, AAM.DS_TIPO_ARQUIVO, "
                + "AAM.NR_NUMERO, AAM.DS_DESCRICAO, AAM.DS_REGISTRO, AAM.DT_DATA_ANEXACAO, "
                + "I.ID_IMAGEM, I.NM_NOME, I.TIPO_MIME, DM.DS_VALOR_DANO "
                
                + "from INSPECAO_MANIFESTACAO_ELEMENTO IME, DADOS_MANIFESTACAO DM, "
                + "ELEMENTO_UFPR_MANIFESTACAO_UFPR EUMU, ELEMENTO_UFPR EU, MANIFESTACAO_UFPR MU, "
                + "MANIFESTACOES_EXTENSAO ME, MANIFESTACOES_URGENCIA MURG, "
                + "ARQUIVO_ANEXO_MANIFESTACAO AAM, IMAGEM I "
                
                + "where IME.ID_INSPECAO = " + idInspecao + " "
                + "and IME.ID_DADOS_MANIFESTACAO = DM.ID_DADOS_MANIFESTACAO "
                + "and IME.ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR = EUMU.ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR "
                + "and EUMU.ID_ELEMENTO_UFPR = EU.ID_ELEMENTO_UFPR "
                + "and EUMU.ID_MANIFESTACAO_UFPR = MU.ID_MANIFESTACAO_UFPR "
                + "and DM.ID_MANIFESTACOES_EXTENSAO = ME.ID_MANIFESTACOES_EXTENSAO "
                + "and DM.ID_MANIFESTACOES_URGENCIA = MURG.ID_MANIFESTACOES_URGENCIA "
                + "and DM.ID_ARQUIVO_ANEXO_MANIFESTACAO = AAM.ID_ARQUIVO_ANEXO_MANIFESTACAO "
                + "and AAM.ID_IMAGEM = I.ID_IMAGEM;";
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<InspecaoManifestacaoElemento> inspecaoManifestacaoElementos = new ArrayList<>();

        while (rs.next()) {
            InspecaoManifestacaoElemento inspecaoManifestacaoElemento = new InspecaoManifestacaoElemento(rs.getInt("ID_INSPECAO_MANIFESTACAO_ELEMENTO"), 
                    rs.getInt("ID_INSPECAO"), 
                    new DadosManifestacao(rs.getInt("ID_DADOS_MANIFESTACAO"), rs.getString("DS_FOTO"), rs.getString("DS_TAMANHO"), rs.getString("DS_NUMERO"), 
                            new ManifestacaoExtensao(rs.getInt("ID_MANIFESTACOES_EXTENSAO"), rs.getString("DS_MANIFESTACOES_EXTENSAO"), null, null), 
                            new ManifestacaoUrgencia(rs.getInt("ID_MANIFESTACOES_URGENCIA"), rs.getString("DS_MANIFESTACOES_URGENCIA"), null, null), 
                            new ArquivoAnexoManifestacao(rs.getInt("ID_ARQUIVO_ANEXO_MANIFESTACAO"), rs.getString("DS_TIPO_ARQUIVO"), 
                            rs.getString("NR_NUMERO"), rs.getString("DS_DESCRICAO"), rs.getString("DS_REGISTRO"), 
                            rs.getDate("DT_DATA_ANEXACAO"), new Imagem(rs.getInt("ID_IMAGEM"), rs.getString("NM_NOME"), rs.getString("TIPO_MIME"))), rs.getDouble("DS_VALOR_DANO")), 
                    new ElementoUfprManifestacaoUfpr(rs.getInt("ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR"), new ElementoUfpr(rs.getInt("ID_ELEMENTO_UFPR"), null, rs.getString("DS_ELEMENTO"), null), 
                            new ManifestacaoUfpr(rs.getInt("ID_MANIFESTACAO_UFPR"), null, rs.getString("DS_MANIFESTACAO_UFPR"), null, null)));
            inspecaoManifestacaoElementos.add(inspecaoManifestacaoElemento);
        }
        conexao.closeConnection();
        return inspecaoManifestacaoElementos;
    }
}
