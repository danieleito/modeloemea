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
        String query = "select P.ID_PONTE, P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, DB.CD_CODIGO, DB.CD_CODIGO_INTEGRACAO, "
                + "DB.DS_STATUS, DB.DS_IDENTIFICACAO, DB.ID_NATUREZA_TRANSPOSICAO, NT.DS_NATUREZA_TRANSPOSICAO, "
                + "DB.ID_TIPO_ESTRUTURA, TE.DS_TIPO_ESTRUTURA, DB.ID_SISTEMA_CONSTRUTIVO, SC.DS_SISTEMA_CONSTRUTIVO, "
                + "DB.DS_COMPRIMENTO, DB.DS_LARGURA, DB.ID_TREM_TIPO, TT.DS_TREM_TIPO, DB.DS_ANO_CONSTRUCAO, "
                + "P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO, L.ID_VIA, V.DS_VIA, L.ID_UF, U.DS_UF, L.DS_LOCAL_VIA, "
                + "L.DS_CIDADE_MAIS_PROXIMA, L.DS_PNV_ANO, L.DS_PNV_VERSAO, L.DS_PNV_CODIGO, L.DS_PNV_ALTITUDE, "
                + "L.DS_LATITUDE_GRAU, L.DS_LATITUDE_MINUTO, L.DS_LONGITUDE_GRAU, L.DS_LONGITUDE_MINUTO, "
                + "P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, UL.ID_SUPERINTENDENCIA_REGIONAL, SR.DS_SUPERINTENDENCIA_REGIONAL, "
                + "R.ID_UNIDADE_LOCAL, UL.DS_UNIDADE_LOCAL, R.ID_TIPO_ADMINISTRACAO, TA.DS_TIPO_ADMINISTRACAO, "
                + "R.DS_ADMINISTRADOR, R.DS_PROJETISTA_ORIGEM, R.DS_PROJETISTA_PROJETISTA, R.DS_CONSTRUTOR_ORIGEM, "
                + "R.DS_CONSTRUTOR_CONSTRUTOR, R.DS_LOCALIZACAO_PROJETO, R.DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, "
                + "R.DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS, P.DS_INDICE_PERFORMANCE_RELATIVO, "
                + "P.ID_IDENTIFICACAO_OBRA_INSPECAO, I.DS_PERIODO, I.DS_EQUIPAMENTO_NECESSARIO, I.DS_MELHOR_EPOCA, "
                + "U2.ID_UF as ID_UF_2, U2.DS_UF as DS_UF_2, "
                + "(select max(DT_DATA) from INSPECAO, PONTE P2 where P2.ID_PONTE = P.ID_PONTE) as DATA "
                
                + "from PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, IDENTIFICACAO_OBRA_LOCALIZACAO L, "
                + "IDENTIFICACAO_OBRA_RESPONSAVEIS R, IDENTIFICACAO_OBRA_INSPECAO I, UF U, UF U2, VIA V, SUPERINTENDENCIA_REGIONAL SR, "
                + "UNIDADE_LOCAL UL, NATUREZA_TRANSPOSICAO NT, TIPO_ESTRUTURA TE, SISTEMA_CONSTRUTIVO SC, TREM_TIPO TT, "
                + "TIPO_ADMINISTRACAO TA "
                
                + "where P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS "
                + "AND P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO = L.ID_IDENTIFICACAO_OBRA_LOCALIZACAO "
                + "AND P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS = R.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS "
                + "AND P.ID_IDENTIFICACAO_OBRA_INSPECAO = I.ID_IDENTIFICACAO_OBRA_INSPECAO "
                + "AND DB.ID_NATUREZA_TRANSPOSICAO = NT.ID_NATUREZA_TRANSPOSICAO "
                + "AND DB.ID_TIPO_ESTRUTURA = TE.ID_TIPO_ESTRUTURA "
                + "AND DB.ID_SISTEMA_CONSTRUTIVO = SC.ID_SISTEMA_CONSTRUTIVO "
                + "AND DB.ID_TREM_TIPO = TT.ID_TREM_TIPO "
                + "AND L.ID_UF = U.ID_UF "
                + "AND L.ID_VIA = V.ID_VIA "
                + "AND UL.ID_SUPERINTENDENCIA_REGIONAL = SR.ID_SUPERINTENDENCIA_REGIONAL "
                //+ "AND R.ID_SUPERINTENDENCIA_REGIONAL = SR.ID_SUPERINTENDENCIA_REGIONAL "
                + "AND R.ID_TIPO_ADMINISTRACAO = TA.ID_TIPO_ADMINISTRACAO "
                + "AND R.ID_UNIDADE_LOCAL = UL.ID_UNIDADE_LOCAL "
                + "AND SR.ID_UF = U2.ID_UF";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Ponte> pontes = new ArrayList<>();
        Ponte ponte;
        while (rs.next()) {
            ponte = new Ponte(
                    rs.getInt("ID_PONTE"), 
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
                            new Via(rs.getInt("ID_VIA"), rs.getString("DS_VIA")), rs.getInt("DS_LOCAL_VIA"), 
                            rs.getString("DS_CIDADE_MAIS_PROXIMA"), rs.getString("DS_PNV_ANO"), 
                            rs.getString("DS_PNV_VERSAO"), rs.getString("DS_PNV_CODIGO"), rs.getString("DS_PNV_ALTITUDE"), 
                            rs.getString("DS_LATITUDE_GRAU"), rs.getString("DS_LATITUDE_MINUTO"), 
                            rs.getString("DS_LONGITUDE_GRAU"), rs.getString("DS_LONGITUDE_MINUTO")), 
                    new IdentificacaoObraResponsaveis(rs.getInt("ID_IDENTIFICACAO_OBRA_RESPONSAVEIS"),  
                            new UnidadeLocal(rs.getInt("ID_UNIDADE_LOCAL"), rs.getString("DS_UNIDADE_LOCAL"), 
                                    new SuperintendenciaRegional(rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), 
                                            rs.getString("DS_SUPERINTENDENCIA_REGIONAL"), new Uf(rs.getInt("ID_UF_2"), rs.getString("DS_UF_2")))), 
                            new TipoAdministracao(rs.getInt("ID_TIPO_ADMINISTRACAO"), rs.getString("DS_TIPO_ADMINISTRACAO")), 
                            rs.getString("DS_ADMINISTRADOR"), rs.getString("DS_PROJETISTA_ORIGEM"), 
                            rs.getString("DS_PROJETISTA_PROJETISTA"), rs.getString("DS_CONSTRUTOR_ORIGEM"), 
                            rs.getString("DS_CONSTRUTOR_CONSTRUTOR"), rs.getString("DS_LOCALIZACAO_PROJETO"), 
                            rs.getString("DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO"), rs.getString("DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS")), 
                    new IdentificacaoObraInspecao(rs.getInt("ID_IDENTIFICACAO_OBRA_INSPECAO"), rs.getString("DS_PERIODO"), 
                            rs.getString("DS_EQUIPAMENTO_NECESSARIO"), rs.getString("DS_MELHOR_EPOCA")),
                    rs.getString("DS_INDICE_PERFORMANCE_RELATIVO"));
            ponte.setDataUltimaInspecao(rs.getDate("DATA"));
            pontes.add(ponte);
        }
        conexao.closeConnection();
        return pontes;
    }

    public Ponte buscar(int id) throws SQLException {
        String query = "";
        query += "select P.ID_PONTE, P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, DB.CD_CODIGO, DB.CD_CODIGO_INTEGRACAO,  ";
        query += "DB.DS_STATUS, DB.DS_IDENTIFICACAO, DB.ID_NATUREZA_TRANSPOSICAO, NT.DS_NATUREZA_TRANSPOSICAO,  ";
        query += "DB.ID_TIPO_ESTRUTURA, TE.DS_TIPO_ESTRUTURA, DB.ID_SISTEMA_CONSTRUTIVO, SC.DS_SISTEMA_CONSTRUTIVO,  ";
        query += "DB.DS_COMPRIMENTO, DB.DS_LARGURA, DB.ID_TREM_TIPO, TT.DS_TREM_TIPO, DB.DS_ANO_CONSTRUCAO,  ";
        query += "P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO, L.ID_VIA, V.DS_VIA, L.ID_UF, U.DS_UF, L.DS_LOCAL_VIA,  ";
        query += "L.DS_CIDADE_MAIS_PROXIMA, L.DS_PNV_ANO, L.DS_PNV_VERSAO, L.DS_PNV_CODIGO, L.DS_PNV_ALTITUDE,  ";
        query += "L.DS_LATITUDE_GRAU, L.DS_LATITUDE_MINUTO, L.DS_LONGITUDE_GRAU, L.DS_LONGITUDE_MINUTO,  ";
        query += "P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, SR.ID_SUPERINTENDENCIA_REGIONAL, SR.DS_SUPERINTENDENCIA_REGIONAL,  ";
        query += "R.ID_UNIDADE_LOCAL, UL.DS_UNIDADE_LOCAL, R.ID_TIPO_ADMINISTRACAO, TA.DS_TIPO_ADMINISTRACAO,  ";
        query += "R.DS_ADMINISTRADOR, R.DS_PROJETISTA_ORIGEM, R.DS_PROJETISTA_PROJETISTA, R.DS_CONSTRUTOR_ORIGEM,  ";
        query += "R.DS_CONSTRUTOR_CONSTRUTOR, R.DS_LOCALIZACAO_PROJETO, R.DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO,  ";
        query += "R.DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS, ";
        query += "P.ID_IDENTIFICACAO_OBRA_INSPECAO, I.DS_PERIODO, I.DS_EQUIPAMENTO_NECESSARIO, I.DS_MELHOR_EPOCA,  ";
        query += "(select max(DT_DATA) from INSPECAO, PONTE P2 where P2.ID_PONTE = P.ID_PONTE) as DATA, ";
        query += "P.DS_INDICE_PERFORMANCE_RELATIVO ";
        query += "from PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, IDENTIFICACAO_OBRA_LOCALIZACAO L,  ";
        query += "IDENTIFICACAO_OBRA_RESPONSAVEIS R, IDENTIFICACAO_OBRA_INSPECAO I, UF U, VIA V, SUPERINTENDENCIA_REGIONAL SR,  ";
        query += "UNIDADE_LOCAL UL, NATUREZA_TRANSPOSICAO NT, TIPO_ESTRUTURA TE, SISTEMA_CONSTRUTIVO SC, TREM_TIPO TT,  ";
        query += "TIPO_ADMINISTRACAO TA  ";
        query += "where P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS  ";
        query += "AND P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO = L.ID_IDENTIFICACAO_OBRA_LOCALIZACAO  ";
        query += "AND P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS = R.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS  ";
        query += "AND P.ID_IDENTIFICACAO_OBRA_INSPECAO = I.ID_IDENTIFICACAO_OBRA_INSPECAO  ";
        query += "AND DB.ID_NATUREZA_TRANSPOSICAO = NT.ID_NATUREZA_TRANSPOSICAO  ";
        query += "AND DB.ID_TIPO_ESTRUTURA = TE.ID_TIPO_ESTRUTURA  ";
        query += "AND DB.ID_SISTEMA_CONSTRUTIVO = SC.ID_SISTEMA_CONSTRUTIVO  ";
        query += "AND DB.ID_TREM_TIPO = TT.ID_TREM_TIPO  ";
        query += "AND L.ID_UF = U.ID_UF  ";
        query += "AND L.ID_VIA = V.ID_VIA  ";
        query += "AND R.ID_UNIDADE_LOCAL = UL.ID_UNIDADE_LOCAL  ";
        query += "AND UL.ID_SUPERINTENDENCIA_REGIONAL = SR.ID_SUPERINTENDENCIA_REGIONAL ";
        query += "AND R.ID_TIPO_ADMINISTRACAO = TA.ID_TIPO_ADMINISTRACAO  ";
        query += "AND P.ID_PONTE = " + id;

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Ponte ponte = null;
        if (rs.next()) {
            Uf uf = new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF"));
            ponte = new Ponte(
                    rs.getInt("ID_PONTE"), 
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
                    new IdentificacaoObraLocalizacao(rs.getInt("ID_IDENTIFICACAO_OBRA_LOCALIZACAO"), uf, 
                            new Via(rs.getInt("ID_VIA"), rs.getString("DS_VIA")), rs.getInt("DS_LOCAL_VIA"), 
                            rs.getString("DS_CIDADE_MAIS_PROXIMA"), rs.getString("DS_PNV_ANO"), 
                            rs.getString("DS_PNV_VERSAO"), rs.getString("DS_PNV_CODIGO"), rs.getString("DS_PNV_ALTITUDE"), 
                            rs.getString("DS_LATITUDE_GRAU"), rs.getString("DS_LATITUDE_MINUTO"), 
                            rs.getString("DS_LONGITUDE_GRAU"), rs.getString("DS_LONGITUDE_MINUTO")), 
                    new IdentificacaoObraResponsaveis(rs.getInt("ID_IDENTIFICACAO_OBRA_RESPONSAVEIS"),  
                            new UnidadeLocal(rs.getInt("ID_UNIDADE_LOCAL"), rs.getString("DS_UNIDADE_LOCAL"), 
                                    new SuperintendenciaRegional(rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), 
                                            rs.getString("DS_SUPERINTENDENCIA_REGIONAL"), uf)), 
                            new TipoAdministracao(rs.getInt("ID_TIPO_ADMINISTRACAO"), rs.getString("DS_TIPO_ADMINISTRACAO")), 
                            rs.getString("DS_ADMINISTRADOR"), rs.getString("DS_PROJETISTA_ORIGEM"), 
                            rs.getString("DS_PROJETISTA_PROJETISTA"), rs.getString("DS_CONSTRUTOR_ORIGEM"), 
                            rs.getString("DS_CONSTRUTOR_CONSTRUTOR"), rs.getString("DS_LOCALIZACAO_PROJETO"), 
                            rs.getString("DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO"), rs.getString("DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS")), 
                    new IdentificacaoObraInspecao(rs.getInt("ID_IDENTIFICACAO_OBRA_INSPECAO"), rs.getString("DS_PERIODO"), 
                            rs.getString("DS_EQUIPAMENTO_NECESSARIO"), rs.getString("DS_MELHOR_EPOCA")),
                    rs.getString("DS_INDICE_PERFORMANCE_RELATIVO"));
            ponte.setDataUltimaInspecao(rs.getDate("DATA"));
        }
        conexao.closeConnection();
        return ponte;
    }
    
    public ArrayList<Ponte> buscar2(String codigo, String identificacao, int uf, int via, 
            int kmInicial, int kmFinal, int superintendenciaRegional, int unidadeLocal) throws SQLException {
        
        String query = "select P.ID_PONTE, P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, DB.CD_CODIGO, DB.CD_CODIGO_INTEGRACAO, "
                + "DB.DS_STATUS, DB.DS_IDENTIFICACAO, DB.ID_NATUREZA_TRANSPOSICAO, NT.DS_NATUREZA_TRANSPOSICAO, "
                + "DB.ID_TIPO_ESTRUTURA, TE.DS_TIPO_ESTRUTURA, DB.ID_SISTEMA_CONSTRUTIVO, SC.DS_SISTEMA_CONSTRUTIVO, "
                + "DB.DS_COMPRIMENTO, DB.DS_LARGURA, DB.ID_TREM_TIPO, TT.DS_TREM_TIPO, DB.DS_ANO_CONSTRUCAO, "
                + "P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO, L.ID_VIA, V.DS_VIA, L.ID_UF, U.DS_UF, L.DS_LOCAL_VIA, "
                + "L.DS_CIDADE_MAIS_PROXIMA, L.DS_PNV_ANO, L.DS_PNV_VERSAO, L.DS_PNV_CODIGO, L.DS_PNV_ALTITUDE, "
                + "L.DS_LATITUDE_GRAU, L.DS_LATITUDE_MINUTO, L.DS_LONGITUDE_GRAU, L.DS_LONGITUDE_MINUTO, "
                + "P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, UL.ID_SUPERINTENDENCIA_REGIONAL, SR.DS_SUPERINTENDENCIA_REGIONAL, "
                + "R.ID_UNIDADE_LOCAL, UL.DS_UNIDADE_LOCAL, R.ID_TIPO_ADMINISTRACAO, TA.DS_TIPO_ADMINISTRACAO, "
                + "R.DS_ADMINISTRADOR, R.DS_PROJETISTA_ORIGEM, R.DS_PROJETISTA_PROJETISTA, R.DS_CONSTRUTOR_ORIGEM, "
                + "R.DS_CONSTRUTOR_CONSTRUTOR, R.DS_LOCALIZACAO_PROJETO, R.DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, "
                + "R.DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS, P.DS_INDICE_PERFORMANCE_RELATIVO, "
                + "P.ID_IDENTIFICACAO_OBRA_INSPECAO, I.DS_PERIODO, I.DS_EQUIPAMENTO_NECESSARIO, I.DS_MELHOR_EPOCA, "
                + "U2.ID_UF as ID_UF_2, U2.DS_UF as DS_UF_2, "
                + "(select max(DT_DATA) from INSPECAO, PONTE P2 where P2.ID_PONTE = P.ID_PONTE) as DATA "
                
                + "from PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, IDENTIFICACAO_OBRA_LOCALIZACAO L, "
                + "IDENTIFICACAO_OBRA_RESPONSAVEIS R, IDENTIFICACAO_OBRA_INSPECAO I, UF U, UF U2, VIA V, SUPERINTENDENCIA_REGIONAL SR, "
                + "UNIDADE_LOCAL UL, NATUREZA_TRANSPOSICAO NT, TIPO_ESTRUTURA TE, SISTEMA_CONSTRUTIVO SC, TREM_TIPO TT, "
                + "TIPO_ADMINISTRACAO TA "
                
                + "where P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS "
                + "AND P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO = L.ID_IDENTIFICACAO_OBRA_LOCALIZACAO "
                + "AND P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS = R.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS "
                + "AND P.ID_IDENTIFICACAO_OBRA_INSPECAO = I.ID_IDENTIFICACAO_OBRA_INSPECAO "
                + "AND DB.ID_NATUREZA_TRANSPOSICAO = NT.ID_NATUREZA_TRANSPOSICAO "
                + "AND DB.ID_TIPO_ESTRUTURA = TE.ID_TIPO_ESTRUTURA "
                + "AND DB.ID_SISTEMA_CONSTRUTIVO = SC.ID_SISTEMA_CONSTRUTIVO "
                + "AND DB.ID_TREM_TIPO = TT.ID_TREM_TIPO "
                + "AND L.ID_UF = U.ID_UF "
                + "AND L.ID_VIA = V.ID_VIA "
                + "AND UL.ID_SUPERINTENDENCIA_REGIONAL = SR.ID_SUPERINTENDENCIA_REGIONAL "
                //+ "AND R.ID_SUPERINTENDENCIA_REGIONAL = SR.ID_SUPERINTENDENCIA_REGIONAL "
                + "AND R.ID_TIPO_ADMINISTRACAO = TA.ID_TIPO_ADMINISTRACAO "
                + "AND R.ID_UNIDADE_LOCAL = UL.ID_UNIDADE_LOCAL "
                + "AND SR.ID_UF = U2.ID_UF ";

        if (codigo != null && !codigo.isEmpty()) {
            query += " and DB.CD_CODIGO like '%" + codigo + "%' ";
        } 
        if (identificacao != null && !identificacao.isEmpty()) {
            query += " and DB.DS_IDENTIFICACAO like '%" + identificacao + "%' ";
        }
        if (uf != 0) {
            query += " and L.ID_UF = " + uf + " ";
        }
        if (via != 0) {
            query += " and L.ID_VIA = " + via + " ";
        }
        if (kmInicial > 0 || kmFinal > 0) {
            query += " and L.DS_LOCAL_VIA > " + kmInicial + " ";
        }
        if (kmFinal > 0) {
            query += " and L.DS_LOCAL_VIA < " + kmFinal + " ";
        }
        if (superintendenciaRegional != 0) {
            query += " and UL.ID_SUPERINTENDENCIA_REGIONAL = " + superintendenciaRegional
                    + " and L.ID_UF = S.ID_UF ";
        }
        if (unidadeLocal != 0) {
            query += " and R.ID_UNIDADE_LOCAL = " + unidadeLocal
                    + " and L.ID_UF = S.ID_UF ";
        }

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<Ponte> pontes = new ArrayList<>();
        Ponte ponte;
        while (rs.next()) {
            ponte = new Ponte(
                    rs.getInt("ID_PONTE"), 
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
                            new Via(rs.getInt("ID_VIA"), rs.getString("DS_VIA")), rs.getInt("DS_LOCAL_VIA"), 
                            rs.getString("DS_CIDADE_MAIS_PROXIMA"), rs.getString("DS_PNV_ANO"), 
                            rs.getString("DS_PNV_VERSAO"), rs.getString("DS_PNV_CODIGO"), rs.getString("DS_PNV_ALTITUDE"), 
                            rs.getString("DS_LATITUDE_GRAU"), rs.getString("DS_LATITUDE_MINUTO"), 
                            rs.getString("DS_LONGITUDE_GRAU"), rs.getString("DS_LONGITUDE_MINUTO")), 
                    new IdentificacaoObraResponsaveis(rs.getInt("ID_IDENTIFICACAO_OBRA_RESPONSAVEIS"),  
                            new UnidadeLocal(rs.getInt("ID_UNIDADE_LOCAL"), rs.getString("DS_UNIDADE_LOCAL"), 
                                    new SuperintendenciaRegional(rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), 
                                            rs.getString("DS_SUPERINTENDENCIA_REGIONAL"), new Uf(rs.getInt("ID_UF_2"), rs.getString("DS_UF_2")))), 
                            new TipoAdministracao(rs.getInt("ID_TIPO_ADMINISTRACAO"), rs.getString("DS_TIPO_ADMINISTRACAO")), 
                            rs.getString("DS_ADMINISTRADOR"), rs.getString("DS_PROJETISTA_ORIGEM"), 
                            rs.getString("DS_PROJETISTA_PROJETISTA"), rs.getString("DS_CONSTRUTOR_ORIGEM"), 
                            rs.getString("DS_CONSTRUTOR_CONSTRUTOR"), rs.getString("DS_LOCALIZACAO_PROJETO"), 
                            rs.getString("DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO"), rs.getString("DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS")), 
                    new IdentificacaoObraInspecao(rs.getInt("ID_IDENTIFICACAO_OBRA_INSPECAO"), rs.getString("DS_PERIODO"), 
                            rs.getString("DS_EQUIPAMENTO_NECESSARIO"), rs.getString("DS_MELHOR_EPOCA")),
                    rs.getString("DS_INDICE_PERFORMANCE_RELATIVO"));
            ponte.setDataUltimaInspecao(rs.getDate("DATA"));
            pontes.add(ponte);
        }
        conexao.closeConnection();
        return pontes;
    }

    public void carregar() {

    }
}
