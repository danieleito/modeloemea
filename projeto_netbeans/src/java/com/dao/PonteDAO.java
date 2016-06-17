/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Ponte;
import com.model.IdentificacaoObraDadosBasicos;
import com.model.IdentificacaoObraInspecao;
import com.model.IdentificacaoObraLocalizacao;
import com.model.IdentificacaoObraResponsaveis;
import com.model.NaturezaTransposicao;
import com.model.SistemaConstrutivo;
import com.model.SuperintendenciaRegional;
import com.model.TipoAdministracao;
import com.model.TipoEstrutura;
import com.model.TremTipo;
import com.model.Uf;
import com.model.UnidadeLocal;
import com.model.Via;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniele Harumi Ito
 */
public class PonteDAO {
    public ArrayList<Ponte> buscar() throws SQLException {
        String query = "select P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, DB.CD_CODIGO, DB.CD_CODIGO_INTEGRACAO, "
                + "DB.DS_STATUS, DB.DS_IDENTIFICACAO, DB.ID_NATUREZA_TRANSPOSICAO, NT.DS_NATUREZA_TRANSPOSICAO, "
                + "DB.ID_TIPO_ESTRUTURA, TE.DS_TIPO_ESTRUTURA, DB.ID_SISTEMA_CONSTRUTIVO, SC.DS_SISTEMA_CONSTRUTIVO, "
                + "DB.DS_COMPRIMENTO, DB.DS_LARGURA, DB.ID_TREM_TIPO, TT.DS_TREM_TIPO, DB.DS_ANO_CONSTRUCAO, "
                + "P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO, L.ID_VIA, V.DS_VIA, L.ID_UF, U.DS_UF, L.DS_LOCAL_VIA, "
                + "L.DS_CIDADE_MAIS_PROXIMA, L.DS_PNV_ANO, L.DS_PNV_VERSAO, L.DS_PNV_CODIGO, L.DS_PNV_ALTITUDE, "
                + "L.DS_LATITUDE_GRAU, L.DS_LATITUDE_MINUTO, L.DS_LONGITUDE_GRAU, L.DS_LONGITUDE_MINUTO, "
                + "P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, R.ID_SUPERINTENDENCIA_REGIONAL, SR.DS_SUPERINTENDENCIA_REGIONAL, "
                + "R.ID_UNIDADE_LOCAL, UL.DS_UNIDADE_LOCAL, R.ID_TIPO_ADMINISTRACAO, TA.DS_TIPO_ADMINISTRACAO, "
                + "R.DS_ADMINISTRADOR, R.DS_PROJETISTA_ORIGEM, R.DS_PROJETISTA_PROJETISTA, R.DS_CONSTRUTOR_ORIGEM, "
                + "R.DS_CONSTRUTOR_CONSTRUTOR, R.DS_LOCALIZACAO_PROJETO, R.DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, "
                + "R.DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS,"
                + "P.ID_IDENTIFICACAO_OBRA_INSPECAO, I.DS_PERIODO, I.DS_EQUIPAMENTO_NECESSARIO, I.DS_MELHOR_EPOCA "
                
                + "from PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, IDENTIFICACAO_OBRA_LOCALIZACAO L, "
                + "IDENTIFICACAO_OBRA_RESPONSAVEIS R, IDENTIFICACAO_OBRA_INSPECAO I, UF U, VIA V, SUPERINTENDENCIA_REGIONAL SR, "
                + "UNIDADE_LOCAL UL, NATUREZA_TRANSPOSICAO NT, TIPO_ESTRUTURA TE, SISTEMA_CONSTRUTIVO SC, TREM_TIPO TT, "
                + "TIPO_ADMINISTRACAO TA "
                
                + "where P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS "
                + "AND P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO = L.ID_IDENTIFICACAO_OBRA_LOCALIZACAO "
                + "AND P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS = R.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS "
                + "AND P.ID_IDENTIFICACAO_OBRA_INSPECAO = I.ID_IDENTIFICACAO_OBRA_INSPECAO "
                + "AND BD.ID_NATUREZA_TRANSPOSICAO = NT.ID_NATUREZA_TRANSPOSICAO "
                + "AND DB.ID_TIPO_ESTRUTURA = TE.ID_TIPO_ESTRUTURA "
                + "AND DB.ID_SISTEMA_CONSTRUTIVO = SC.ID_SISTEMA_CONSTRUTIVO "
                + "AND DB.ID_TREM_TIPO = TT.ID_TREM_TIPO "
                + "AND L.ID_UF = U.ID_UF "
                + "AND L.ID_VIA = V.ID_VIA "
                + "AND R.ID_SUPERINTENDENCIA_REGIONAL = SR.ID_SUPERINTENDENCIA_REGIONAL "
                + "AND R.ID_UNIDADE_LOCAL = UL.ID_UNIDADE_LOCAL "
                + "AND R.ID_TIPO_ADMINISTRACAO = TA.ID_TIPO_ADMINISTRACAO";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Ponte> identificacaoObra = new ArrayList<>();

        while (rs.next()) {
            identificacaoObra.add(new Ponte(
                    new IdentificacaoObraDadosBasicos(rs.getInt("ID_IDENTIFICACAO_OBRA_DADOS_BASICOS"), 
                            rs.getString("CD_CODIGO"), rs.getString("CD_CODIGO_INTEGRACAO"), 
                            rs.getString("DS_STATUS"), rs.getString("DS_IDENTIFICACAO"), 
                            new NaturezaTransposicao(rs.getInt("ID_NATUREZA_TRANSPOSICAO"), 
                            rs.getString("DS_NATUREZA_TRANSPOSICAO")), 
                            new TipoEstrutura(rs.getInt("ID_TIPO_ESTRUTURA"), rs.getString("DS_TIPO_ESTRUTURA")), 
                            new SistemaConstrutivo(rs.getInt("ID_SISTEMA_CONSTRUTIVO"), rs.getString("DS_SISTEMA_CONSTRUTIVO")), 
                            rs.getString("DS_COMPRIMENTO"), rs.getString("DS_LARGURA"), 
                            new TremTipo(rs.getInt("ID_TREM_TIPO"), rs.getString("DS_TREM_TIPO")), 
                            rs.getString("DS_ANO_CONSTRUCAO")), 
                    new IdentificacaoObraLocalizacao(rs.getInt("ID_IDENTIFICACAO_OBRA_LOCALIZACAO"), 
                            new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF")), 
                            new Via(rs.getInt("ID_VIA"), rs.getString("DS_VIA")), rs.getString("DS_LOCAL_VIA"), 
                            rs.getString("DS_CIDADE_MAIS_PROXIMA"), rs.getString("DS_PNV_ANO"), 
                            rs.getString("DS_PNV_VERSAO"), rs.getString("DS_PNV_CODIGO"), rs.getString("DS_PNV_ALTITUDE"), 
                            rs.getString("DS_LATITUDE_GRAU"), rs.getString("DS_LATITUDE_MINUTO"), 
                            rs.getString("DS_LONGITUDE_GRAU"), rs.getString("DS_LONGITUDE_MINUTO")), 
                    new IdentificacaoObraResponsaveis(rs.getInt("ID_IDENTIFICACAO_OBRA_RESPONSAVEIS"), 
                            new SuperintendenciaRegional(rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), 
                            rs.getString("DS_SUPERINTENDENCIA_REGIONAL")), 
                            new UnidadeLocal(rs.getInt("ID_UNIDADE_LOCAL"), rs.getString("DS_UNIDADE_LOCAL")), 
                            new TipoAdministracao(rs.getInt("ID_TIPO_ADMINISTRACAO"), rs.getString("DS_TIPO_ADMINISTRACAO")), 
                            rs.getString("DS_ADMINISTRADOR"), rs.getString("DS_PROJETISTA_ORIGEM"), 
                            rs.getString("DS_PROJETISTA_PROJETISTA"), rs.getString("DS_CONSTRUTOR_ORIGEM"), 
                            rs.getString("DS_CONSTRUTOR_CONSTRUTOR"), rs.getString("DS_LOCALIZACAO_PROJETO"), 
                            rs.getString("DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO"), rs.getString("DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS")), 
                    new IdentificacaoObraInspecao(rs.getInt("ID_IDENTIFICACAO_OBRA_INSPECAO"), rs.getString("DS_PERIODO"), 
                            rs.getString("DS_EQUIPAMENTO_NECESSARIO"), rs.getString("DS_MELHOR_EPOCA"))));
        }
        conexao.closeConnection();
        return identificacaoObra;
    }

    public Ponte buscar(int id) throws SQLException {
        String query = "select P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, DB.CD_CODIGO, DB.CD_CODIGO_INTEGRACAO, "
                + "DB.DS_STATUS, DB.DS_IDENTIFICACAO, DB.ID_NATUREZA_TRANSPOSICAO, NT.DS_NATUREZA_TRANSPOSICAO, "
                + "DB.ID_TIPO_ESTRUTURA, TE.DS_TIPO_ESTRUTURA, DB.ID_SISTEMA_CONSTRUTIVO, SC.DS_SISTEMA_CONSTRUTIVO, "
                + "DB.DS_COMPRIMENTO, DB.DS_LARGURA, DB.ID_TREM_TIPO, TT.DS_TREM_TIPO, DB.DS_ANO_CONSTRUCAO, "
                + "P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO, L.ID_VIA, V.DS_VIA, L.ID_UF, U.DS_UF, L.DS_LOCAL_VIA, "
                + "L.DS_CIDADE_MAIS_PROXIMA, L.DS_PNV_ANO, L.DS_PNV_VERSAO, L.DS_PNV_CODIGO, L.DS_PNV_ALTITUDE, "
                + "L.DS_LATITUDE_GRAU, L.DS_LATITUDE_MINUTO, L.DS_LONGITUDE_GRAU, L.DS_LONGITUDE_MINUTO, "
                + "P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, R.ID_SUPERINTENDENCIA_REGIONAL, SR.DS_SUPERINTENDENCIA_REGIONAL, "
                + "R.ID_UNIDADE_LOCAL, UL.DS_UNIDADE_LOCAL, R.ID_TIPO_ADMINISTRACAO, TA.DS_TIPO_ADMINISTRACAO, "
                + "R.DS_ADMINISTRADOR, R.DS_PROJETISTA_ORIGEM, R.DS_PROJETISTA_PROJETISTA, R.DS_CONSTRUTOR_ORIGEM, "
                + "R.DS_CONSTRUTOR_CONSTRUTOR, R.DS_LOCALIZACAO_PROJETO, R.DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, "
                + "R.DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS,"
                + "P.ID_IDENTIFICACAO_OBRA_INSPECAO, I.DS_PERIODO, I.DS_EQUIPAMENTO_NECESSARIO, I.DS_MELHOR_EPOCA "
                
                + "from PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, IDENTIFICACAO_OBRA_LOCALIZACAO L, "
                + "IDENTIFICACAO_OBRA_RESPONSAVEIS R, IDENTIFICACAO_OBRA_INSPECAO I, UF U, VIA V, SUPERINTENDENCIA_REGIONAL SR, "
                + "UNIDADE_LOCAL UL, NATUREZA_TRANSPOSICAO NT, TIPO_ESTRUTURA TE, SISTEMA_CONSTRUTIVO SC, TREM_TIPO TT, "
                + "TIPO_ADMINISTRACAO TA "
                
                + "where P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS "
                + "AND P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO = L.ID_IDENTIFICACAO_OBRA_LOCALIZACAO "
                + "AND P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS = R.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS "
                + "AND P.ID_IDENTIFICACAO_OBRA_INSPECAO = I.ID_IDENTIFICACAO_OBRA_INSPECAO "
                + "AND BD.ID_NATUREZA_TRANSPOSICAO = NT.ID_NATUREZA_TRANSPOSICAO "
                + "AND DB.ID_TIPO_ESTRUTURA = TE.ID_TIPO_ESTRUTURA "
                + "AND DB.ID_SISTEMA_CONSTRUTIVO = SC.ID_SISTEMA_CONSTRUTIVO "
                + "AND DB.ID_TREM_TIPO = TT.ID_TREM_TIPO "
                + "AND L.ID_UF = U.ID_UF "
                + "AND L.ID_VIA = V.ID_VIA "
                + "AND R.ID_SUPERINTENDENCIA_REGIONAL = SR.ID_SUPERINTENDENCIA_REGIONAL "
                + "AND R.ID_UNIDADE_LOCAL = UL.ID_UNIDADE_LOCAL "
                + "AND R.ID_TIPO_ADMINISTRACAO = TA.ID_TIPO_ADMINISTRACAO "
                + "AND L.ID_PONTE = " + id + ";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Ponte identificacaoObra = null;
        if (rs.next()) {
            identificacaoObra = new Ponte(
                    new IdentificacaoObraDadosBasicos(rs.getInt("ID_IDENTIFICACAO_OBRA_DADOS_BASICOS"), 
                            rs.getString("CD_CODIGO"), rs.getString("CD_CODIGO_INTEGRACAO"), 
                            rs.getString("DS_STATUS"), rs.getString("DS_IDENTIFICACAO"), 
                            new NaturezaTransposicao(rs.getInt("ID_NATUREZA_TRANSPOSICAO"), 
                            rs.getString("DS_NATUREZA_TRANSPOSICAO")), 
                            new TipoEstrutura(rs.getInt("ID_TIPO_ESTRUTURA"), rs.getString("DS_TIPO_ESTRUTURA")), 
                            new SistemaConstrutivo(rs.getInt("ID_SISTEMA_CONSTRUTIVO"), rs.getString("DS_SISTEMA_CONSTRUTIVO")), 
                            rs.getString("DS_COMPRIMENTO"), rs.getString("DS_LARGURA"), 
                            new TremTipo(rs.getInt("ID_TREM_TIPO"), rs.getString("DS_TREM_TIPO")), 
                            rs.getString("DS_ANO_CONSTRUCAO")), 
                    new IdentificacaoObraLocalizacao(rs.getInt("ID_IDENTIFICACAO_OBRA_LOCALIZACAO"), 
                            new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF")), 
                            new Via(rs.getInt("ID_VIA"), rs.getString("DS_VIA")), rs.getString("DS_LOCAL_VIA"), 
                            rs.getString("DS_CIDADE_MAIS_PROXIMA"), rs.getString("DS_PNV_ANO"), 
                            rs.getString("DS_PNV_VERSAO"), rs.getString("DS_PNV_CODIGO"), rs.getString("DS_PNV_ALTITUDE"), 
                            rs.getString("DS_LATITUDE_GRAU"), rs.getString("DS_LATITUDE_MINUTO"), 
                            rs.getString("DS_LONGITUDE_GRAU"), rs.getString("DS_LONGITUDE_MINUTO")), 
                    new IdentificacaoObraResponsaveis(rs.getInt("ID_IDENTIFICACAO_OBRA_RESPONSAVEIS"), 
                            new SuperintendenciaRegional(rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), 
                            rs.getString("DS_SUPERINTENDENCIA_REGIONAL")), 
                            new UnidadeLocal(rs.getInt("ID_UNIDADE_LOCAL"), rs.getString("DS_UNIDADE_LOCAL")), 
                            new TipoAdministracao(rs.getInt("ID_TIPO_ADMINISTRACAO"), rs.getString("DS_TIPO_ADMINISTRACAO")), 
                            rs.getString("DS_ADMINISTRADOR"), rs.getString("DS_PROJETISTA_ORIGEM"), 
                            rs.getString("DS_PROJETISTA_PROJETISTA"), rs.getString("DS_CONSTRUTOR_ORIGEM"), 
                            rs.getString("DS_CONSTRUTOR_CONSTRUTOR"), rs.getString("DS_LOCALIZACAO_PROJETO"), 
                            rs.getString("DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO"), rs.getString("DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS")), 
                    new IdentificacaoObraInspecao(rs.getInt("ID_IDENTIFICACAO_OBRA_INSPECAO"), rs.getString("DS_PERIODO"), 
                            rs.getString("DS_EQUIPAMENTO_NECESSARIO"), rs.getString("DS_MELHOR_EPOCA")));
        }
        conexao.closeConnection();
        return identificacaoObra;
    }
    
    public ArrayList<Ponte> buscar2(String codigo, String identificacao, int uf, int via, 
            String localVia, int superintendenciaRegional, int unidadeLocal) throws SQLException {
        
        String query;

        query = "select P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, DB.CD_CODIGO, DB.CD_CODIGO_INTEGRACAO, "
                + "DB.DS_STATUS, DB.DS_IDENTIFICACAO, DB.ID_NATUREZA_TRANSPOSICAO, NT.DS_NATUREZA_TRANSPOSICAO, "
                + "DB.ID_TIPO_ESTRUTURA, TE.DS_TIPO_ESTRUTURA, DB.ID_SISTEMA_CONSTRUTIVO, SC.DS_SISTEMA_CONSTRUTIVO, "
                + "DB.DS_COMPRIMENTO, DB.DS_LARGURA, DB.ID_TREM_TIPO, TT.DS_TREM_TIPO, DB.DS_ANO_CONSTRUCAO, "
                + "P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO, L.ID_VIA, V.DS_VIA, L.ID_UF, U.DS_UF, L.DS_LOCAL_VIA, "
                + "L.DS_CIDADE_MAIS_PROXIMA, L.DS_PNV_ANO, L.DS_PNV_VERSAO, L.DS_PNV_CODIGO, L.DS_PNV_ALTITUDE, "
                + "L.DS_LATITUDE_GRAU, L.DS_LATITUDE_MINUTO, L.DS_LONGITUDE_GRAU, L.DS_LONGITUDE_MINUTO, "
                + "P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, R.ID_SUPERINTENDENCIA_REGIONAL, SR.DS_SUPERINTENDENCIA_REGIONAL, "
                + "R.ID_UNIDADE_LOCAL, UL.DS_UNIDADE_LOCAL, R.ID_TIPO_ADMINISTRACAO, TA.DS_TIPO_ADMINISTRACAO, "
                + "R.DS_ADMINISTRADOR, R.DS_PROJETISTA_ORIGEM, R.DS_PROJETISTA_PROJETISTA, R.DS_CONSTRUTOR_ORIGEM, "
                + "R.DS_CONSTRUTOR_CONSTRUTOR, R.DS_LOCALIZACAO_PROJETO, R.DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, "
                + "R.DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS,"
                + "P.ID_IDENTIFICACAO_OBRA_INSPECAO, I.DS_PERIODO, I.DS_EQUIPAMENTO_NECESSARIO, I.DS_MELHOR_EPOCA "
                
                + "from PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, IDENTIFICACAO_OBRA_LOCALIZACAO L, "
                + "IDENTIFICACAO_OBRA_RESPONSAVEIS R, IDENTIFICACAO_OBRA_INSPECAO I, UF U, VIA V, SUPERINTENDENCIA_REGIONAL SR, "
                + "UNIDADE_LOCAL UL, NATUREZA_TRANSPOSICAO NT, TIPO_ESTRUTURA TE, SISTEMA_CONSTRUTIVO SC, TREM_TIPO TT, "
                + "TIPO_ADMINISTRACAO TA "
                
                + "where P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS "
                + "AND P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO = L.ID_IDENTIFICACAO_OBRA_LOCALIZACAO "
                + "AND P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS = R.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS "
                + "AND P.ID_IDENTIFICACAO_OBRA_INSPECAO = I.ID_IDENTIFICACAO_OBRA_INSPECAO "
                + "AND BD.ID_NATUREZA_TRANSPOSICAO = NT.ID_NATUREZA_TRANSPOSICAO "
                + "AND DB.ID_TIPO_ESTRUTURA = TE.ID_TIPO_ESTRUTURA "
                + "AND DB.ID_SISTEMA_CONSTRUTIVO = SC.ID_SISTEMA_CONSTRUTIVO "
                + "AND DB.ID_TREM_TIPO = TT.ID_TREM_TIPO "
                + "AND L.ID_UF = U.ID_UF "
                + "AND L.ID_VIA = V.ID_VIA "
                + "AND R.ID_SUPERINTENDENCIA_REGIONAL = SR.ID_SUPERINTENDENCIA_REGIONAL "
                + "AND R.ID_UNIDADE_LOCAL = UL.ID_UNIDADE_LOCAL "
                + "AND R.ID_TIPO_ADMINISTRACAO = TA.ID_TIPO_ADMINISTRACAO";

        if (codigo != null && !codigo.isEmpty()) {
            query += " and DB.CD_PONTE like '%" + codigo + "%'";
        } 
        if (identificacao != null && !identificacao.isEmpty()) {
            query += " and DB.DS_IDENTIFICACAO like '%" + identificacao + "%'";
        }
        if (uf != 0) {
            query += " and L.ID_UF = " + uf
                    + " and L.ID_UF = S.ID_UF";
        }
        if (via != 0) {
            query += " and L.ID_VIA = " + via;
//                    + " and L.ID_UF = V.ID_UF";
        }
        if (localVia != null && !localVia.isEmpty()) {
            query += " and L.DS_LOCAL_VIA like '%" + localVia + "%'";
        }
        if (superintendenciaRegional != 0) {
            query += " and R.ID_SUPERINTENDENCIA_REGIONAL = " + superintendenciaRegional
                    + " and L.ID_UF = S.ID_UF";
        }
        if (unidadeLocal != 0) {
            query += " and R.ID_UNIDADE_LOCAL = " + unidadeLocal
                    + " and L.ID_UF = S.ID_UF";
        }

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<Ponte> identificacaoObra = new ArrayList<>();
        while (rs.next()) {
            identificacaoObra.add(new Ponte(
                    new IdentificacaoObraDadosBasicos(rs.getInt("ID_IDENTIFICACAO_OBRA_DADOS_BASICOS"), 
                            rs.getString("CD_CODIGO"), rs.getString("CD_CODIGO_INTEGRACAO"), 
                            rs.getString("DS_STATUS"), rs.getString("DS_IDENTIFICACAO"), 
                            new NaturezaTransposicao(rs.getInt("ID_NATUREZA_TRANSPOSICAO"), 
                            rs.getString("DS_NATUREZA_TRANSPOSICAO")), 
                            new TipoEstrutura(rs.getInt("ID_TIPO_ESTRUTURA"), rs.getString("DS_TIPO_ESTRUTURA")), 
                            new SistemaConstrutivo(rs.getInt("ID_SISTEMA_CONSTRUTIVO"), rs.getString("DS_SISTEMA_CONSTRUTIVO")), 
                            rs.getString("DS_COMPRIMENTO"), rs.getString("DS_LARGURA"), 
                            new TremTipo(rs.getInt("ID_TREM_TIPO"), rs.getString("DS_TREM_TIPO")), 
                            rs.getString("DS_ANO_CONSTRUCAO")), 
                    new IdentificacaoObraLocalizacao(rs.getInt("ID_IDENTIFICACAO_OBRA_LOCALIZACAO"), 
                            new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF")), 
                            new Via(rs.getInt("ID_VIA"), rs.getString("DS_VIA")), rs.getString("DS_LOCAL_VIA"), 
                            rs.getString("DS_CIDADE_MAIS_PROXIMA"), rs.getString("DS_PNV_ANO"), 
                            rs.getString("DS_PNV_VERSAO"), rs.getString("DS_PNV_CODIGO"), rs.getString("DS_PNV_ALTITUDE"), 
                            rs.getString("DS_LATITUDE_GRAU"), rs.getString("DS_LATITUDE_MINUTO"), 
                            rs.getString("DS_LONGITUDE_GRAU"), rs.getString("DS_LONGITUDE_MINUTO")), 
                    new IdentificacaoObraResponsaveis(rs.getInt("ID_IDENTIFICACAO_OBRA_RESPONSAVEIS"), 
                            new SuperintendenciaRegional(rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), 
                            rs.getString("DS_SUPERINTENDENCIA_REGIONAL")), 
                            new UnidadeLocal(rs.getInt("ID_UNIDADE_LOCAL"), rs.getString("DS_UNIDADE_LOCAL")), 
                            new TipoAdministracao(rs.getInt("ID_TIPO_ADMINISTRACAO"), rs.getString("DS_TIPO_ADMINISTRACAO")), 
                            rs.getString("DS_ADMINISTRADOR"), rs.getString("DS_PROJETISTA_ORIGEM"), 
                            rs.getString("DS_PROJETISTA_PROJETISTA"), rs.getString("DS_CONSTRUTOR_ORIGEM"), 
                            rs.getString("DS_CONSTRUTOR_CONSTRUTOR"), rs.getString("DS_LOCALIZACAO_PROJETO"), 
                            rs.getString("DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO"), rs.getString("DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS")), 
                    new IdentificacaoObraInspecao(rs.getInt("ID_IDENTIFICACAO_OBRA_INSPECAO"), rs.getString("DS_PERIODO"), 
                            rs.getString("DS_EQUIPAMENTO_NECESSARIO"), rs.getString("DS_MELHOR_EPOCA"))));
        }
        conexao.closeConnection();
        return identificacaoObra;
    }

    public void carregar() {

    }
}
