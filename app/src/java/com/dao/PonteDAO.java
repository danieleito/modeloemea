/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.AspectoEspecial;
import com.model.CadastroAspectoEspecial;
import com.model.CaracteristicasFuncionaisCaracteristicas;
import com.model.CaracteristicasFuncionaisDimensoes;
import com.model.ElementoComponente;
import com.model.ElementoUfpr;
import com.model.Ponte;
import com.model.IdentificacaoObraDadosBasicos;
import com.model.IdentificacaoObraInspecao;
import com.model.IdentificacaoObraLocalizacao;
import com.model.IdentificacaoObraResponsaveis;
import com.model.NaturezaTransposicao;
import com.model.Observacao;
import com.model.RotasAlternativas;
import com.model.SistemaConstrutivo;
import com.model.Substituicao;
import com.model.SuperintendenciaRegional;
import com.model.TipoAdministracao;
import com.model.TipoEstrutura;
import com.model.TipoRegiao;
import com.model.TipoTracado;
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
                + "DB.NR_COMPRIMENTO, DB.NR_LARGURA, DB.ID_TREM_TIPO, TT.DS_TREM_TIPO, DB.DS_ANO_CONSTRUCAO, "
                + "P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO, L.ID_VIA, V.DS_VIA, L.ID_UF, U.DS_UF, U.SG_UF, L.NR_LOCAL_VIA, "
                + "L.DS_CIDADE_MAIS_PROXIMA, L.DS_PNV_ANO, L.DS_PNV_VERSAO, L.DS_PNV_CODIGO, L.DS_PNV_ALTITUDE, "
                + "L.DS_LATITUDE_GRAU, L.DS_LATITUDE_MINUTO, L.DS_LONGITUDE_GRAU, L.DS_LONGITUDE_MINUTO, "
                + "P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, R.ID_UNIDADE_LOCAL, UL.DS_UNIDADE_LOCAL, UL.ID_SUPERINTENDENCIA_REGIONAL, "
                + "SR.DS_SUPERINTENDENCIA_REGIONAL, SR.ID_UF, U2.DS_UF, U2.SG_UF, "
                + "R.ID_TIPO_ADMINISTRACAO, TA.DS_TIPO_ADMINISTRACAO, "
                + "R.DS_ADMINISTRADOR, R.DS_PROJETISTA_ORIGEM, R.DS_PROJETISTA_PROJETISTA, R.DS_CONSTRUTOR_ORIGEM, "
                + "R.DS_CONSTRUTOR_CONSTRUTOR, R.DS_LOCALIZACAO_PROJETO, R.DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, "
                + "R.DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS, P.DS_INDICE_PERFORMANCE_RELATIVO, "
                + "P.ID_IDENTIFICACAO_OBRA_INSPECAO, I.DS_PERIODO, I.DS_EQUIPAMENTO_NECESSARIO, I.DS_MELHOR_EPOCA, "
                + "P.ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, C.ID_TIPO_REGIAO, TR.DS_TIPO_REGIAO, C.ID_TIPO_TRACADO, "
                + "T.DS_TIPO_TRACADO, C.DS_RAMPA_MAXIMA, C.DS_RAIO_CURVA, C.DS_VMD, P.ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, "
                + "D.DS_NUMERO_FAIXAS, D.DS_LARGURA_FAIXA, D.DS_ACOSTAMENTO_DIREITO, D.DS_ACOSTAMENTO_ESQUERDO, D.DS_CALCADA_DIREITA, "
                + "D.DS_CALCADA_ESQUERDA, D.DS_LARGURA_TOTAL_PISTA, D.DS_GABARITO_HORIZONTAL, D.DS_GABARITO_VERTICAL, D.DS_NUMERO_VAOS, "
                + "D.DS_DESCRICAO_VAOS, P.ID_ROTAS_ALTERNATIVAS, RA.DS_IDENTIFICACAO, RA.DS_ROTA_ALTERNATIVA, RA.DS_ACRESCIMO_KM, "
                + "P.ID_OBSERVACOES, O.DS_IDENTIFICACAO, O.DS_OBSERVACOES, P.ID_SUBSTITUICAO, S.DS_IDENTIFICACAO, "
                + "S.DS_EXISTE_PROJETO_SUBSTITUICAO, S.DS_CUSTO_ESTIMADO, S.DS_OBSERVACOES, "
                + "U2.ID_UF as ID_UF_2, U2.DS_UF as DS_UF_2, U2.SG_UF as SG_UF_2, "
                + "(select max(DT_DATA) from INSPECAO, PONTE P2 where P2.ID_PONTE = INSPECAO.ID_PONTE and P2.ID_PONTE = P.ID_PONTE) as DATA "
                
                + "from PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, IDENTIFICACAO_OBRA_LOCALIZACAO L, IDENTIFICACAO_OBRA_RESPONSAVEIS R, "
                + "IDENTIFICACAO_OBRA_INSPECAO I, CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS C, CARACTERISTICAS_FUNCIONAIS_DIMENSOES D, "
                + "ROTAS_ALTERNATIVAS RA, OBSERVACOES O, SUBSTITUICAO S, TIPO_REGIAO TR, TIPO_TRACADO T, NATUREZA_TRANSPOSICAO NT, TIPO_ESTRUTURA TE, "
                + "SISTEMA_CONSTRUTIVO SC, TREM_TIPO TT, UF U, VIA V, UNIDADE_LOCAL UL, TIPO_ADMINISTRACAO TA, SUPERINTENDENCIA_REGIONAL SR, UF U2 "
                
                + "where P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS "
                + "and P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO = L.ID_IDENTIFICACAO_OBRA_LOCALIZACAO "
                + "and P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS = R.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS "
                + "and P.ID_IDENTIFICACAO_OBRA_INSPECAO = I.ID_IDENTIFICACAO_OBRA_INSPECAO "
                + "and P.ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS = C.ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS "
                + "and P.ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES = D.ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES "
                + "and P.ID_ROTAS_ALTERNATIVAS = RA.ID_ROTAS_ALTERNATIVAS "
                + "and P.ID_OBSERVACOES = O.ID_OBSERVACOES "
                + "and P.ID_SUBSTITUICAO = S.ID_SUBSTITUICAO "
                + "and C.ID_TIPO_REGIAO = TR.ID_TIPO_REGIAO "
                + "and C.ID_TIPO_TRACADO = T.ID_TIPO_TRACADO "
                + "and DB.ID_NATUREZA_TRANSPOSICAO = NT.ID_NATUREZA_TRANSPOSICAO "
                + "and DB.ID_TIPO_ESTRUTURA = TE.ID_TIPO_ESTRUTURA "
                + "and DB.ID_SISTEMA_CONSTRUTIVO = SC.ID_SISTEMA_CONSTRUTIVO "
                + "and DB.ID_TREM_TIPO = TT.ID_TREM_TIPO "
                + "and L.ID_UF = U.ID_UF "
                + "and L.ID_VIA = V.ID_VIA "
                + "and R.ID_UNIDADE_LOCAL = UL.ID_UNIDADE_LOCAL "
                + "and UL.ID_SUPERINTENDENCIA_REGIONAL = SR.ID_SUPERINTENDENCIA_REGIONAL "
                + "and R.ID_TIPO_ADMINISTRACAO = TA.ID_TIPO_ADMINISTRACAO "
                + "and SR.ID_UF = U2.ID_UF;";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Ponte> pontes = new ArrayList<>();
        Ponte ponte;
        while (rs.next()) {
            ponte = new Ponte(
                    rs.getInt("ID_PONTE"), rs.getDouble("DS_INDICE_PERFORMANCE_RELATIVO"), 
                    new IdentificacaoObraDadosBasicos(rs.getInt("ID_IDENTIFICACAO_OBRA_DADOS_BASICOS"), 
                            rs.getString("CD_CODIGO"), rs.getString("CD_CODIGO_INTEGRACAO"), 
                            rs.getString("DS_STATUS"), rs.getString("DS_IDENTIFICACAO"), 
                            new NaturezaTransposicao(rs.getInt("ID_NATUREZA_TRANSPOSICAO"), 
                            rs.getString("DS_NATUREZA_TRANSPOSICAO")), 
                            new TipoEstrutura(rs.getInt("ID_TIPO_ESTRUTURA"), rs.getString("DS_TIPO_ESTRUTURA")), 
                            new SistemaConstrutivo(rs.getInt("ID_SISTEMA_CONSTRUTIVO"), rs.getString("DS_SISTEMA_CONSTRUTIVO")), 
                            rs.getDouble("NR_COMPRIMENTO"), rs.getDouble("NR_LARGURA"), 
                            new TremTipo(rs.getInt("ID_TREM_TIPO"), rs.getString("DS_TREM_TIPO")), 
                            rs.getString("DS_ANO_CONSTRUCAO")), 
                    new IdentificacaoObraLocalizacao(rs.getInt("ID_IDENTIFICACAO_OBRA_LOCALIZACAO"), 
                            new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF"), rs.getString("SG_UF")), 
                            new Via(rs.getInt("ID_VIA"), rs.getString("DS_VIA")), rs.getDouble("NR_LOCAL_VIA"), 
                            rs.getString("DS_CIDADE_MAIS_PROXIMA"), rs.getString("DS_PNV_ANO"), 
                            rs.getString("DS_PNV_VERSAO"), rs.getString("DS_PNV_CODIGO"), rs.getString("DS_PNV_ALTITUDE"), 
                            rs.getString("DS_LATITUDE_GRAU"), rs.getString("DS_LATITUDE_MINUTO"), 
                            rs.getString("DS_LONGITUDE_GRAU"), rs.getString("DS_LONGITUDE_MINUTO")), 
                    new IdentificacaoObraResponsaveis(rs.getInt("ID_IDENTIFICACAO_OBRA_RESPONSAVEIS"),  
                            new UnidadeLocal(rs.getInt("ID_UNIDADE_LOCAL"), rs.getString("DS_UNIDADE_LOCAL"), 
                                    new SuperintendenciaRegional(rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), 
                                    rs.getString("DS_SUPERINTENDENCIA_REGIONAL"), new Uf(rs.getInt("ID_UF_2"), rs.getString("DS_UF_2"), rs.getString("SG_UF_2")))), 
                            new TipoAdministracao(rs.getInt("ID_TIPO_ADMINISTRACAO"), rs.getString("DS_TIPO_ADMINISTRACAO")), 
                            rs.getString("DS_ADMINISTRADOR"), rs.getString("DS_PROJETISTA_ORIGEM"), 
                            rs.getString("DS_PROJETISTA_PROJETISTA"), rs.getString("DS_CONSTRUTOR_ORIGEM"), 
                            rs.getString("DS_CONSTRUTOR_CONSTRUTOR"), rs.getString("DS_LOCALIZACAO_PROJETO"), 
                            rs.getString("DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO"), rs.getString("DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS")), 
                    new IdentificacaoObraInspecao(rs.getInt("ID_IDENTIFICACAO_OBRA_INSPECAO"), rs.getString("DS_PERIODO"), 
                            rs.getString("DS_EQUIPAMENTO_NECESSARIO"), rs.getString("DS_MELHOR_EPOCA")),
                    new CaracteristicasFuncionaisCaracteristicas(rs.getInt("ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS"), 
                            new TipoRegiao(rs.getInt("ID_TIPO_REGIAO"), rs.getString("DS_TIPO_REGIAO")), 
                            new TipoTracado(rs.getInt("ID_TIPO_TRACADO"), rs.getString("DS_TIPO_TRACADO")), rs.getString("DS_RAMPA_MAXIMA"), 
                            rs.getString("DS_RAIO_CURVA"), rs.getString("DS_VMD")),
                    new CaracteristicasFuncionaisDimensoes(rs.getInt("ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES"), rs.getString("DS_NUMERO_FAIXAS"), 
                            rs.getString("DS_LARGURA_FAIXA"), rs.getString("DS_ACOSTAMENTO_DIREITO"), rs.getString("DS_ACOSTAMENTO_ESQUERDO"), 
                            rs.getString("DS_CALCADA_DIREITA"), rs.getString("DS_CALCADA_ESQUERDA"), rs.getString("DS_LARGURA_TOTAL_PISTA"), 
                            rs.getString("DS_GABARITO_HORIZONTAL"), rs.getString("DS_GABARITO_VERTICAL"), rs.getString("DS_NUMERO_VAOS"), 
                            rs.getString("DS_DESCRICAO_VAOS")), 
                    new RotasAlternativas(rs.getInt("ID_ROTAS_ALTERNATIVAS"), rs.getString("DS_IDENTIFICACAO"), rs.getString("DS_ROTA_ALTERNATIVA"), 
                            rs.getString("DS_ACRESCIMO_KM")), 
                    new Observacao(rs.getInt("ID_OBSERVACOES"), rs.getString("DS_IDENTIFICACAO"), rs.getString("DS_OBSERVACOES")), 
                    new Substituicao(rs.getInt("ID_SUBSTITUICAO"), rs.getString("DS_IDENTIFICACAO"), rs.getString("DS_EXISTE_PROJETO_SUBSTITUICAO"), 
                            rs.getString("DS_CUSTO_ESTIMADO"), rs.getString("DS_OBSERVACOES")));
            ponte.setDataUltimaInspecao(rs.getDate("DATA"));
//            ponte.setDeficienciasFuncionais(buscarDeficienciasFuncionais(ponte.getId()));
            ponte.setAspectosEspeciais(buscarAspectosEspeciais(ponte.getId()));
            ponte.setElementosComponentes(buscarElementosComponentes(ponte.getId()));
            ArquivoAnexoDAO dbArquivoAnexo = new ArquivoAnexoDAO();
            ponte.setArquivosAnexosCadastro(dbArquivoAnexo.buscarCadastros(ponte.getId()));
            pontes.add(ponte);
        }
        conexao.closeConnection(); 
        return pontes;
    }

    public Ponte buscar(int id) throws SQLException {
        String query = "";
        query += "select P.ID_PONTE, P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, DB.CD_CODIGO, DB.CD_CODIGO_INTEGRACAO, "
                + "DB.DS_STATUS, DB.DS_IDENTIFICACAO, DB.ID_NATUREZA_TRANSPOSICAO, NT.DS_NATUREZA_TRANSPOSICAO, "
                + "DB.ID_TIPO_ESTRUTURA, TE.DS_TIPO_ESTRUTURA, DB.ID_SISTEMA_CONSTRUTIVO, SC.DS_SISTEMA_CONSTRUTIVO, "
                + "DB.NR_COMPRIMENTO, DB.NR_LARGURA, DB.ID_TREM_TIPO, TT.DS_TREM_TIPO, DB.DS_ANO_CONSTRUCAO, "
                + "P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO, L.ID_VIA, V.DS_VIA, L.ID_UF, U.DS_UF, U.SG_UF, L.NR_LOCAL_VIA, "
                + "L.DS_CIDADE_MAIS_PROXIMA, L.DS_PNV_ANO, L.DS_PNV_VERSAO, L.DS_PNV_CODIGO, L.DS_PNV_ALTITUDE, "
                + "L.DS_LATITUDE_GRAU, L.DS_LATITUDE_MINUTO, L.DS_LONGITUDE_GRAU, L.DS_LONGITUDE_MINUTO, "
                + "P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, SR.ID_SUPERINTENDENCIA_REGIONAL, SR.DS_SUPERINTENDENCIA_REGIONAL, "
                + "R.ID_UNIDADE_LOCAL, UL.DS_UNIDADE_LOCAL, R.ID_TIPO_ADMINISTRACAO, TA.DS_TIPO_ADMINISTRACAO, "
                + "R.DS_ADMINISTRADOR, R.DS_PROJETISTA_ORIGEM, R.DS_PROJETISTA_PROJETISTA, R.DS_CONSTRUTOR_ORIGEM, "
                + "R.DS_CONSTRUTOR_CONSTRUTOR, R.DS_LOCALIZACAO_PROJETO, R.DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, "
                + "R.DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS, P.ID_IDENTIFICACAO_OBRA_INSPECAO, I.DS_PERIODO, "
                + "I.DS_EQUIPAMENTO_NECESSARIO, I.DS_MELHOR_EPOCA, P.ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, "
                + "C.ID_TIPO_REGIAO, TR.DS_TIPO_REGIAO, C.ID_TIPO_TRACADO, "
                + "T.DS_TIPO_TRACADO, C.DS_RAMPA_MAXIMA, C.DS_RAIO_CURVA, C.DS_VMD, P.ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, "
                + "D.DS_NUMERO_FAIXAS, D.DS_LARGURA_FAIXA, D.DS_ACOSTAMENTO_DIREITO, D.DS_ACOSTAMENTO_ESQUERDO, D.DS_CALCADA_DIREITA, "
                + "D.DS_CALCADA_ESQUERDA, D.DS_LARGURA_TOTAL_PISTA, D.DS_GABARITO_HORIZONTAL, D.DS_GABARITO_VERTICAL, D.DS_NUMERO_VAOS, "
                + "D.DS_DESCRICAO_VAOS, P.ID_ROTAS_ALTERNATIVAS, RA.DS_IDENTIFICACAO, RA.DS_ROTA_ALTERNATIVA, RA.DS_ACRESCIMO_KM, "
                + "P.ID_OBSERVACOES, O.DS_IDENTIFICACAO, O.DS_OBSERVACOES, P.ID_SUBSTITUICAO, SUB.DS_IDENTIFICACAO, "
                + "SUB.DS_EXISTE_PROJETO_SUBSTITUICAO, SUB.DS_CUSTO_ESTIMADO, SUB.DS_OBSERVACOES, "
                + "(select max(DT_DATA) from INSPECAO, PONTE P2 where P2.ID_PONTE = INSPECAO.ID_PONTE and P2.ID_PONTE = P.ID_PONTE) as DATA, "
                + "P.DS_INDICE_PERFORMANCE_RELATIVO "

                + "from PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, IDENTIFICACAO_OBRA_LOCALIZACAO L, "
                + "IDENTIFICACAO_OBRA_RESPONSAVEIS R, IDENTIFICACAO_OBRA_INSPECAO I, UF U, VIA V, SUPERINTENDENCIA_REGIONAL SR, "
                + "UNIDADE_LOCAL UL, NATUREZA_TRANSPOSICAO NT, TIPO_ESTRUTURA TE, SISTEMA_CONSTRUTIVO SC, TREM_TIPO TT, "
                + "TIPO_ADMINISTRACAO TA, CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS C, TIPO_REGIAO TR, TIPO_TRACADO T, "
                + "CARACTERISTICAS_FUNCIONAIS_DIMENSOES D, ROTAS_ALTERNATIVAS RA, OBSERVACOES O, SUBSTITUICAO SUB, "
                + "NUMERO N, FOTO F "

                + "where P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS "
                + "AND P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO = L.ID_IDENTIFICACAO_OBRA_LOCALIZACAO "
                + "AND P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS = R.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS "
                + "AND P.ID_IDENTIFICACAO_OBRA_INSPECAO = I.ID_IDENTIFICACAO_OBRA_INSPECAO  "
                + "AND P.ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS = C.ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS "
                + "AND P.ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES = D.ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES "
                + "AND P.ID_ROTAS_ALTERNATIVAS = RA.ID_ROTAS_ALTERNATIVAS "
                + "AND P.ID_OBSERVACOES = O.ID_OBSERVACOES "
                + "AND P.ID_SUBSTITUICAO = SUB.ID_SUBSTITUICAO "
                + "AND C.ID_TIPO_REGIAO = TR.ID_TIPO_REGIAO "
                + "AND C.ID_TIPO_TRACADO = T.ID_TIPO_TRACADO "
                + "AND DB.ID_NATUREZA_TRANSPOSICAO = NT.ID_NATUREZA_TRANSPOSICAO "
                + "AND DB.ID_TIPO_ESTRUTURA = TE.ID_TIPO_ESTRUTURA "
                + "AND DB.ID_SISTEMA_CONSTRUTIVO = SC.ID_SISTEMA_CONSTRUTIVO "
                + "AND DB.ID_TREM_TIPO = TT.ID_TREM_TIPO "
                + "AND L.ID_UF = U.ID_UF "
                + "AND L.ID_VIA = V.ID_VIA "
                + "AND R.ID_UNIDADE_LOCAL = UL.ID_UNIDADE_LOCAL "
                + "AND UL.ID_SUPERINTENDENCIA_REGIONAL = SR.ID_SUPERINTENDENCIA_REGIONAL "
                + "AND R.ID_TIPO_ADMINISTRACAO = TA.ID_TIPO_ADMINISTRACAO "
                + "AND P.ID_PONTE = " + id;

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Ponte ponte = null;
        if (rs.next()) {
            Uf uf = new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF"), rs.getString("SG_UF"));
            ponte = new Ponte(
                    rs.getInt("ID_PONTE"), rs.getDouble("DS_INDICE_PERFORMANCE_RELATIVO"), 
                    new IdentificacaoObraDadosBasicos(rs.getInt("ID_IDENTIFICACAO_OBRA_DADOS_BASICOS"), 
                            rs.getString("CD_CODIGO"), rs.getString("CD_CODIGO_INTEGRACAO"), 
                            rs.getString("DS_STATUS"), rs.getString("DS_IDENTIFICACAO"), 
                            new NaturezaTransposicao(rs.getInt("ID_NATUREZA_TRANSPOSICAO"), 
                            rs.getString("DS_NATUREZA_TRANSPOSICAO")), 
                            new TipoEstrutura(rs.getInt("ID_TIPO_ESTRUTURA"), rs.getString("DS_TIPO_ESTRUTURA")), 
                            new SistemaConstrutivo(rs.getInt("ID_SISTEMA_CONSTRUTIVO"), rs.getString("DS_SISTEMA_CONSTRUTIVO")), 
                            rs.getDouble("NR_COMPRIMENTO"), rs.getDouble("NR_LARGURA"), 
                            new TremTipo(rs.getInt("ID_TREM_TIPO"), rs.getString("DS_TREM_TIPO")), 
                            rs.getString("DS_ANO_CONSTRUCAO")), 
                    new IdentificacaoObraLocalizacao(rs.getInt("ID_IDENTIFICACAO_OBRA_LOCALIZACAO"), uf, 
                            new Via(rs.getInt("ID_VIA"), rs.getString("DS_VIA")), rs.getDouble("NR_LOCAL_VIA"), 
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
                    new CaracteristicasFuncionaisCaracteristicas(rs.getInt("ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS"), 
                            new TipoRegiao(rs.getInt("ID_TIPO_REGIAO"), rs.getString("DS_TIPO_REGIAO")), 
                            new TipoTracado(rs.getInt("ID_TIPO_TRACADO"), rs.getString("DS_TIPO_TRACADO")), rs.getString("DS_RAMPA_MAXIMA"), 
                            rs.getString("DS_RAIO_CURVA"), rs.getString("DS_VMD")),
                    new CaracteristicasFuncionaisDimensoes(rs.getInt("ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES"), rs.getString("DS_NUMERO_FAIXAS"), 
                            rs.getString("DS_LARGURA_FAIXA"), rs.getString("DS_ACOSTAMENTO_DIREITO"), rs.getString("DS_ACOSTAMENTO_ESQUERDO"), 
                            rs.getString("DS_CALCADA_DIREITA"), rs.getString("DS_CALCADA_ESQUERDA"), rs.getString("DS_LARGURA_TOTAL_PISTA"), 
                            rs.getString("DS_GABARITO_HORIZONTAL"), rs.getString("DS_GABARITO_VERTICAL"), rs.getString("DS_NUMERO_VAOS"), 
                            rs.getString("DS_DESCRICAO_VAOS")), 
                    new RotasAlternativas(rs.getInt("ID_ROTAS_ALTERNATIVAS"), rs.getString("DS_IDENTIFICACAO"), rs.getString("DS_ROTA_ALTERNATIVA"), 
                            rs.getString("DS_ACRESCIMO_KM")), 
                    new Observacao(rs.getInt("ID_OBSERVACOES"), rs.getString("DS_IDENTIFICACAO"), rs.getString("DS_OBSERVACOES")), 
                    new Substituicao(rs.getInt("ID_SUBSTITUICAO"), rs.getString("DS_IDENTIFICACAO"), rs.getString("DS_EXISTE_PROJETO_SUBSTITUICAO"), 
                            rs.getString("DS_CUSTO_ESTIMADO"), rs.getString("DS_OBSERVACOES")));
//            ponte.setDeficienciasFuncionais(buscarDeficienciasFuncionais(ponte.getId()));
            ponte.setAspectosEspeciais(buscarAspectosEspeciais(ponte.getId()));
            ponte.setElementosComponentes(buscarElementosComponentes(ponte.getId()));
            ponte.setDataUltimaInspecao(rs.getDate("DATA"));
            
            ArquivoAnexoDAO arquivoAnexoDAO = new ArquivoAnexoDAO();
            ponte.setArquivosAnexosCadastro(arquivoAnexoDAO.buscarCadastros(ponte.getId()));
            ponte.setArquivosAnexosInspecoes(arquivoAnexoDAO.buscarInspecoes(ponte.getId()));
            //ponte.setArquivosAnexosManifestacoes(arquivoAnexoDAO.buscarManifestacoes(ponte.getId()));

            InspecaoDAO inspecaoDAO = new InspecaoDAO();
            ponte.setInspecoes(inspecaoDAO.buscarInspecao(ponte.getId()));
        }
        conexao.closeConnection();
        return ponte;
    }

    public ArrayList<Ponte> buscar2(String codigo, String identificacao, int uf, int via, 
            double kmInicial, double kmFinal, int superintendenciaRegional, int unidadeLocal) throws SQLException {

        String query = "select P.ID_PONTE, P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, DB.CD_CODIGO, DB.CD_CODIGO_INTEGRACAO, "
                + "DB.DS_STATUS, DB.DS_IDENTIFICACAO, DB.ID_NATUREZA_TRANSPOSICAO, NT.DS_NATUREZA_TRANSPOSICAO, "
                + "DB.ID_TIPO_ESTRUTURA, TE.DS_TIPO_ESTRUTURA, DB.ID_SISTEMA_CONSTRUTIVO, SC.DS_SISTEMA_CONSTRUTIVO, "
                + "DB.NR_COMPRIMENTO, DB.NR_LARGURA, DB.ID_TREM_TIPO, TT.DS_TREM_TIPO, DB.DS_ANO_CONSTRUCAO, "
                + "P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO, L.ID_VIA, V.DS_VIA, L.ID_UF, U.DS_UF, U.SG_UF, L.NR_LOCAL_VIA, "
                + "L.DS_CIDADE_MAIS_PROXIMA, L.DS_PNV_ANO, L.DS_PNV_VERSAO, L.DS_PNV_CODIGO, L.DS_PNV_ALTITUDE, "
                + "L.DS_LATITUDE_GRAU, L.DS_LATITUDE_MINUTO, L.DS_LONGITUDE_GRAU, L.DS_LONGITUDE_MINUTO, "
                + "P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, R.ID_UNIDADE_LOCAL, UL.DS_UNIDADE_LOCAL, UL.ID_SUPERINTENDENCIA_REGIONAL, "
                + "SR.DS_SUPERINTENDENCIA_REGIONAL, SR.ID_UF, U2.DS_UF, U2.SG_UF, "
                + "R.ID_TIPO_ADMINISTRACAO, TA.DS_TIPO_ADMINISTRACAO, "
                + "R.DS_ADMINISTRADOR, R.DS_PROJETISTA_ORIGEM, R.DS_PROJETISTA_PROJETISTA, R.DS_CONSTRUTOR_ORIGEM, "
                + "R.DS_CONSTRUTOR_CONSTRUTOR, R.DS_LOCALIZACAO_PROJETO, R.DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, "
                + "R.DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS, P.DS_INDICE_PERFORMANCE_RELATIVO, "
                + "P.ID_IDENTIFICACAO_OBRA_INSPECAO, I.DS_PERIODO, I.DS_EQUIPAMENTO_NECESSARIO, I.DS_MELHOR_EPOCA, "
                + "P.ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, C.ID_TIPO_REGIAO, TR.DS_TIPO_REGIAO, C.ID_TIPO_TRACADO, "
                + "T.DS_TIPO_TRACADO, C.DS_RAMPA_MAXIMA, C.DS_RAIO_CURVA, C.DS_VMD, P.ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, "
                + "D.DS_NUMERO_FAIXAS, D.DS_LARGURA_FAIXA, D.DS_ACOSTAMENTO_DIREITO, D.DS_ACOSTAMENTO_ESQUERDO, D.DS_CALCADA_DIREITA, "
                + "D.DS_CALCADA_ESQUERDA, D.DS_LARGURA_TOTAL_PISTA, D.DS_GABARITO_HORIZONTAL, D.DS_GABARITO_VERTICAL, D.DS_NUMERO_VAOS, "
                + "D.DS_DESCRICAO_VAOS, P.ID_ROTAS_ALTERNATIVAS, RA.DS_IDENTIFICACAO, RA.DS_ROTA_ALTERNATIVA, RA.DS_ACRESCIMO_KM, "
                + "P.ID_OBSERVACOES, O.DS_IDENTIFICACAO, O.DS_OBSERVACOES, P.ID_SUBSTITUICAO, S.DS_IDENTIFICACAO, "
                + "S.DS_EXISTE_PROJETO_SUBSTITUICAO, S.DS_CUSTO_ESTIMADO, S.DS_OBSERVACOES, "
                + "U2.ID_UF as ID_UF_2, U2.DS_UF as DS_UF_2, U2.SG_UF as SG_UF_2, "
                + "(select max(DT_DATA) from INSPECAO, PONTE P2 where P2.ID_PONTE = INSPECAO.ID_PONTE and P2.ID_PONTE = P.ID_PONTE) as DATA "
                
                + "from PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, IDENTIFICACAO_OBRA_LOCALIZACAO L, IDENTIFICACAO_OBRA_RESPONSAVEIS R, "
                + "IDENTIFICACAO_OBRA_INSPECAO I, CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS C, CARACTERISTICAS_FUNCIONAIS_DIMENSOES D, "
                + "ROTAS_ALTERNATIVAS RA, OBSERVACOES O, SUBSTITUICAO S, TIPO_REGIAO TR, TIPO_TRACADO T, NATUREZA_TRANSPOSICAO NT, TIPO_ESTRUTURA TE, "
                + "SISTEMA_CONSTRUTIVO SC, TREM_TIPO TT, UF U, VIA V, UNIDADE_LOCAL UL, TIPO_ADMINISTRACAO TA, SUPERINTENDENCIA_REGIONAL SR, UF U2 "
                
                + "where P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS "
                + "and P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO = L.ID_IDENTIFICACAO_OBRA_LOCALIZACAO "
                + "and P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS = R.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS "
                + "and P.ID_IDENTIFICACAO_OBRA_INSPECAO = I.ID_IDENTIFICACAO_OBRA_INSPECAO "
                + "and P.ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS = C.ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS "
                + "and P.ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES = D.ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES "
                + "and P.ID_ROTAS_ALTERNATIVAS = RA.ID_ROTAS_ALTERNATIVAS "
                + "and P.ID_OBSERVACOES = O.ID_OBSERVACOES "
                + "and P.ID_SUBSTITUICAO = S.ID_SUBSTITUICAO "
                + "and C.ID_TIPO_REGIAO = TR.ID_TIPO_REGIAO "
                + "and C.ID_TIPO_TRACADO = T.ID_TIPO_TRACADO "
                + "and DB.ID_NATUREZA_TRANSPOSICAO = NT.ID_NATUREZA_TRANSPOSICAO "
                + "and DB.ID_TIPO_ESTRUTURA = TE.ID_TIPO_ESTRUTURA "
                + "and DB.ID_SISTEMA_CONSTRUTIVO = SC.ID_SISTEMA_CONSTRUTIVO "
                + "and DB.ID_TREM_TIPO = TT.ID_TREM_TIPO "
                + "and L.ID_UF = U.ID_UF "
                + "and L.ID_VIA = V.ID_VIA "
                + "and R.ID_UNIDADE_LOCAL = UL.ID_UNIDADE_LOCAL "
                + "and UL.ID_SUPERINTENDENCIA_REGIONAL = SR.ID_SUPERINTENDENCIA_REGIONAL "
                + "and R.ID_TIPO_ADMINISTRACAO = TA.ID_TIPO_ADMINISTRACAO "
                + "and SR.ID_UF = U2.ID_UF";

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
        if (kmInicial > 0) {
            query += " and L.NR_LOCAL_VIA > " + kmInicial + " ";
        }
        if (kmFinal > 0) {
            query += " and L.NR_LOCAL_VIA < " + kmFinal + " ";
        }
        if (superintendenciaRegional != 0) {
            query += " and UL.ID_SUPERINTENDENCIA_REGIONAL = " + superintendenciaRegional
                    + " and L.ID_UF = U.ID_UF ";
        }
        if (unidadeLocal != 0) {
            query += " and R.ID_UNIDADE_LOCAL = " + unidadeLocal
                    + " and L.ID_UF = U.ID_UF ";
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
                    rs.getInt("ID_PONTE"), rs.getDouble("DS_INDICE_PERFORMANCE_RELATIVO"), 
                    new IdentificacaoObraDadosBasicos(rs.getInt("ID_IDENTIFICACAO_OBRA_DADOS_BASICOS"), 
                            rs.getString("CD_CODIGO"), rs.getString("CD_CODIGO_INTEGRACAO"), 
                            rs.getString("DS_STATUS"), rs.getString("DS_IDENTIFICACAO"), 
                            new NaturezaTransposicao(rs.getInt("ID_NATUREZA_TRANSPOSICAO"), 
                            rs.getString("DS_NATUREZA_TRANSPOSICAO")), 
                            new TipoEstrutura(rs.getInt("ID_TIPO_ESTRUTURA"), rs.getString("DS_TIPO_ESTRUTURA")), 
                            new SistemaConstrutivo(rs.getInt("ID_SISTEMA_CONSTRUTIVO"), rs.getString("DS_SISTEMA_CONSTRUTIVO")), 
                            rs.getDouble("NR_COMPRIMENTO"), rs.getDouble("NR_LARGURA"), 
                            new TremTipo(rs.getInt("ID_TREM_TIPO"), rs.getString("DS_TREM_TIPO")), 
                            rs.getString("DS_ANO_CONSTRUCAO")), 
                    new IdentificacaoObraLocalizacao(rs.getInt("ID_IDENTIFICACAO_OBRA_LOCALIZACAO"), 
                            new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF"), rs.getString("SG_UF")), 
                            new Via(rs.getInt("ID_VIA"), rs.getString("DS_VIA")), rs.getDouble("NR_LOCAL_VIA"), 
                            rs.getString("DS_CIDADE_MAIS_PROXIMA"), rs.getString("DS_PNV_ANO"), 
                            rs.getString("DS_PNV_VERSAO"), rs.getString("DS_PNV_CODIGO"), rs.getString("DS_PNV_ALTITUDE"), 
                            rs.getString("DS_LATITUDE_GRAU"), rs.getString("DS_LATITUDE_MINUTO"), 
                            rs.getString("DS_LONGITUDE_GRAU"), rs.getString("DS_LONGITUDE_MINUTO")), 
                    new IdentificacaoObraResponsaveis(rs.getInt("ID_IDENTIFICACAO_OBRA_RESPONSAVEIS"),  
                            new UnidadeLocal(rs.getInt("ID_UNIDADE_LOCAL"), rs.getString("DS_UNIDADE_LOCAL"), 
                                    new SuperintendenciaRegional(rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), 
                                            rs.getString("DS_SUPERINTENDENCIA_REGIONAL"), new Uf(rs.getInt("ID_UF_2"), rs.getString("DS_UF_2"), rs.getString("SG_UF_2")))), 
                            new TipoAdministracao(rs.getInt("ID_TIPO_ADMINISTRACAO"), rs.getString("DS_TIPO_ADMINISTRACAO")), 
                            rs.getString("DS_ADMINISTRADOR"), rs.getString("DS_PROJETISTA_ORIGEM"), 
                            rs.getString("DS_PROJETISTA_PROJETISTA"), rs.getString("DS_CONSTRUTOR_ORIGEM"), 
                            rs.getString("DS_CONSTRUTOR_CONSTRUTOR"), rs.getString("DS_LOCALIZACAO_PROJETO"), 
                            rs.getString("DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO"), rs.getString("DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS")), 
                    new IdentificacaoObraInspecao(rs.getInt("ID_IDENTIFICACAO_OBRA_INSPECAO"), rs.getString("DS_PERIODO"), 
                            rs.getString("DS_EQUIPAMENTO_NECESSARIO"), rs.getString("DS_MELHOR_EPOCA")), 
                    new CaracteristicasFuncionaisCaracteristicas(rs.getInt("ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS"), 
                            new TipoRegiao(rs.getInt("ID_TIPO_REGIAO"), rs.getString("DS_TIPO_REGIAO")), 
                            new TipoTracado(rs.getInt("ID_TIPO_TRACADO"), rs.getString("DS_TIPO_TRACADO")), rs.getString("DS_RAMPA_MAXIMA"), 
                            rs.getString("DS_RAIO_CURVA"), rs.getString("DS_VMD")),
                    new CaracteristicasFuncionaisDimensoes(rs.getInt("ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES"), rs.getString("DS_NUMERO_FAIXAS"), 
                            rs.getString("DS_LARGURA_FAIXA"), rs.getString("DS_ACOSTAMENTO_DIREITO"), rs.getString("DS_ACOSTAMENTO_ESQUERDO"), 
                            rs.getString("DS_CALCADA_DIREITA"), rs.getString("DS_CALCADA_ESQUERDA"), rs.getString("DS_LARGURA_TOTAL_PISTA"), 
                            rs.getString("DS_GABARITO_HORIZONTAL"), rs.getString("DS_GABARITO_VERTICAL"), rs.getString("DS_NUMERO_VAOS"), 
                            rs.getString("DS_DESCRICAO_VAOS")), 
                    new RotasAlternativas(rs.getInt("ID_ROTAS_ALTERNATIVAS"), rs.getString("DS_IDENTIFICACAO"), rs.getString("DS_ROTA_ALTERNATIVA"), 
                            rs.getString("DS_ACRESCIMO_KM")), 
                    new Observacao(rs.getInt("ID_OBSERVACOES"), rs.getString("DS_IDENTIFICACAO"), rs.getString("DS_OBSERVACOES")), 
                    new Substituicao(rs.getInt("ID_SUBSTITUICAO"), rs.getString("DS_IDENTIFICACAO"), rs.getString("DS_EXISTE_PROJETO_SUBSTITUICAO"), 
                            rs.getString("DS_CUSTO_ESTIMADO"), rs.getString("DS_OBSERVACOES")));
            ponte.setDataUltimaInspecao(rs.getDate("DATA"));
//            ponte.setDeficienciasFuncionais(buscarDeficienciasFuncionais(ponte.getId()));
            ponte.setAspectosEspeciais(buscarAspectosEspeciais(ponte.getId()));
            ponte.setElementosComponentes(buscarElementosComponentes(ponte.getId()));

            pontes.add(ponte);
        }
        conexao.closeConnection();
        return pontes;
    }
    
    public ArrayList<Ponte> buscaAvancada(int naturezaTransposicao, int tipoEstrutura, int sistemaConstrutivo, 
            double comprimentoInicial, double comprimentoFinal, double larguraInicial, double larguraFinal, 
            int aspectoEspecial, int deficienciaFuncional, int morfologia, int elemento, int manifestacao, 
            ArrayList<ElementoUfpr> morfologias) throws SQLException {

        String query = "select P.ID_PONTE, P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, DB.CD_CODIGO, DB.CD_CODIGO_INTEGRACAO, "
                + "DB.DS_STATUS, DB.DS_IDENTIFICACAO, DB.ID_NATUREZA_TRANSPOSICAO, NT.DS_NATUREZA_TRANSPOSICAO, "
                + "DB.ID_TIPO_ESTRUTURA, TE.DS_TIPO_ESTRUTURA, DB.ID_SISTEMA_CONSTRUTIVO, SC.DS_SISTEMA_CONSTRUTIVO, "
                + "DB.NR_COMPRIMENTO, DB.NR_LARGURA, DB.ID_TREM_TIPO, TT.DS_TREM_TIPO, DB.DS_ANO_CONSTRUCAO, "
                + "P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO, L.ID_VIA, V.DS_VIA, L.ID_UF, U.DS_UF, U.SG_UF, L.NR_LOCAL_VIA, "
                + "L.DS_CIDADE_MAIS_PROXIMA, L.DS_PNV_ANO, L.DS_PNV_VERSAO, L.DS_PNV_CODIGO, L.DS_PNV_ALTITUDE, "
                + "L.DS_LATITUDE_GRAU, L.DS_LATITUDE_MINUTO, L.DS_LONGITUDE_GRAU, L.DS_LONGITUDE_MINUTO, "
                + "P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, R.ID_UNIDADE_LOCAL, UL.DS_UNIDADE_LOCAL, UL.ID_SUPERINTENDENCIA_REGIONAL, "
                + "SR.DS_SUPERINTENDENCIA_REGIONAL, SR.ID_UF, U2.DS_UF, U2.SG_UF, "
                + "R.ID_TIPO_ADMINISTRACAO, TA.DS_TIPO_ADMINISTRACAO, "
                + "R.DS_ADMINISTRADOR, R.DS_PROJETISTA_ORIGEM, R.DS_PROJETISTA_PROJETISTA, R.DS_CONSTRUTOR_ORIGEM, "
                + "R.DS_CONSTRUTOR_CONSTRUTOR, R.DS_LOCALIZACAO_PROJETO, R.DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, "
                + "R.DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS, P.DS_INDICE_PERFORMANCE_RELATIVO, "
                + "P.ID_IDENTIFICACAO_OBRA_INSPECAO, I.DS_PERIODO, I.DS_EQUIPAMENTO_NECESSARIO, I.DS_MELHOR_EPOCA, "
                + "P.ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, C.ID_TIPO_REGIAO, TR.DS_TIPO_REGIAO, C.ID_TIPO_TRACADO, "
                + "T.DS_TIPO_TRACADO, C.DS_RAMPA_MAXIMA, C.DS_RAIO_CURVA, C.DS_VMD, P.ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, "
                + "D.DS_NUMERO_FAIXAS, D.DS_LARGURA_FAIXA, D.DS_ACOSTAMENTO_DIREITO, D.DS_ACOSTAMENTO_ESQUERDO, D.DS_CALCADA_DIREITA, "
                + "D.DS_CALCADA_ESQUERDA, D.DS_LARGURA_TOTAL_PISTA, D.DS_GABARITO_HORIZONTAL, D.DS_GABARITO_VERTICAL, D.DS_NUMERO_VAOS, "
                + "D.DS_DESCRICAO_VAOS, P.ID_ROTAS_ALTERNATIVAS, RA.DS_IDENTIFICACAO, RA.DS_ROTA_ALTERNATIVA, RA.DS_ACRESCIMO_KM, "
                + "P.ID_OBSERVACOES, O.DS_IDENTIFICACAO, O.DS_OBSERVACOES, P.ID_SUBSTITUICAO, S.DS_IDENTIFICACAO, "
                + "S.DS_EXISTE_PROJETO_SUBSTITUICAO, S.DS_CUSTO_ESTIMADO, S.DS_OBSERVACOES, "
                + "U2.ID_UF as ID_UF_2, U2.DS_UF as DS_UF_2, U2.SG_UF as SG_UF_2, "
                + "(select max(DT_DATA) from INSPECAO, PONTE P2 where P2.ID_PONTE = INSPECAO.ID_PONTE and P2.ID_PONTE = P.ID_PONTE) as DATA "
                
                + "from PONTE P, IDENTIFICACAO_OBRA_DADOS_BASICOS DB, IDENTIFICACAO_OBRA_LOCALIZACAO L, IDENTIFICACAO_OBRA_RESPONSAVEIS R, "
                + "IDENTIFICACAO_OBRA_INSPECAO I, CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS C, CARACTERISTICAS_FUNCIONAIS_DIMENSOES D, "
                + "ROTAS_ALTERNATIVAS RA, OBSERVACOES O, SUBSTITUICAO S, TIPO_REGIAO TR, TIPO_TRACADO T, NATUREZA_TRANSPOSICAO NT, TIPO_ESTRUTURA TE, "
                + "SISTEMA_CONSTRUTIVO SC, TREM_TIPO TT, UF U, VIA V, UNIDADE_LOCAL UL, TIPO_ADMINISTRACAO TA, SUPERINTENDENCIA_REGIONAL SR, UF U2 "
                
                + "where P.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS = DB.ID_IDENTIFICACAO_OBRA_DADOS_BASICOS "
                + "and P.ID_IDENTIFICACAO_OBRA_LOCALIZACAO = L.ID_IDENTIFICACAO_OBRA_LOCALIZACAO "
                + "and P.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS = R.ID_IDENTIFICACAO_OBRA_RESPONSAVEIS "
                + "and P.ID_IDENTIFICACAO_OBRA_INSPECAO = I.ID_IDENTIFICACAO_OBRA_INSPECAO "
                + "and P.ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS = C.ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS "
                + "and P.ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES = D.ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES "
                + "and P.ID_ROTAS_ALTERNATIVAS = RA.ID_ROTAS_ALTERNATIVAS "
                + "and P.ID_OBSERVACOES = O.ID_OBSERVACOES "
                + "and P.ID_SUBSTITUICAO = S.ID_SUBSTITUICAO "
                + "and C.ID_TIPO_REGIAO = TR.ID_TIPO_REGIAO "
                + "and C.ID_TIPO_TRACADO = T.ID_TIPO_TRACADO "
                + "and DB.ID_NATUREZA_TRANSPOSICAO = NT.ID_NATUREZA_TRANSPOSICAO "
                + "and DB.ID_TIPO_ESTRUTURA = TE.ID_TIPO_ESTRUTURA "
                + "and DB.ID_SISTEMA_CONSTRUTIVO = SC.ID_SISTEMA_CONSTRUTIVO "
                + "and DB.ID_TREM_TIPO = TT.ID_TREM_TIPO "
                + "and L.ID_UF = U.ID_UF "
                + "and L.ID_VIA = V.ID_VIA "
                + "and R.ID_UNIDADE_LOCAL = UL.ID_UNIDADE_LOCAL "
                + "and UL.ID_SUPERINTENDENCIA_REGIONAL = SR.ID_SUPERINTENDENCIA_REGIONAL "
                + "and R.ID_TIPO_ADMINISTRACAO = TA.ID_TIPO_ADMINISTRACAO "
                + "and SR.ID_UF = U2.ID_UF";


        if (naturezaTransposicao != 0) {
            query += " and NT.ID_NATUREZA_TRANSPOSICAO = " + naturezaTransposicao + " ";
        }
        if (tipoEstrutura != 0) {
            query += " and DB.ID_TIPO_ESTRUTURA = " + tipoEstrutura + " ";
        }
        if (sistemaConstrutivo != 0) {
            query += " and DB.ID_SISTEMA_CONSTRUTIVO = " + sistemaConstrutivo + " ";
        }
        if (comprimentoInicial > 0) {
            query += " and DB.NR_COMPRIMENTO > " + comprimentoInicial + " ";
        }
        if (comprimentoFinal > 0) {
            query += " and DB.NR_COMPRIMENTO < " + comprimentoFinal + " ";
        }
        if (larguraInicial > 0) {
            query += " and DB.NR_LARGURA > " + larguraInicial + " ";
        }
        if (larguraFinal > 0) {
            query += " and DB.NR_LARGURA < " + larguraFinal + " ";
        }
        if (aspectoEspecial != 0) {
            query += " and P.ID_PONTE in (select ID_PONTE from CADASTRO_ASPECTOS_ESPECIAIS where ID_ASPECTOS_ESPECIAIS = " + aspectoEspecial + ") ";
        }
//        if (deficienciaFuncional != 0) {
//            query += " and P.ID_PONTE in (select ID_PONTE from CADASTRO_ASPECTOS_ESPECIAIS where ID_ASPECTOS_ESPECIAIS = " + aspectoEspecial + ") ";
//        }
        if (morfologias != null) {
            for (int i = 0; i < morfologias.size(); i++) {
                query += " and P.ID_PONTE in (select ID_PONTE from ELEMENTO_COMPONENTES where ID_ELEMENTO_UFPR = " + morfologias.get(i).getId() + ") ";
            }
        }
        if (elemento != 0) {
            query += " and P.ID_PONTE in (select ID_PONTE from INSPECAO I, INSPECAO_MANIFESTACAO_ELEMENTO IME, "
                    + "ELEMENTO_UFPR_MANIFESTACAO_UFPR EUMU "
                    + "where I.ID_INSPECAO = IME.ID_INSPECAO "
                    + "and IME.ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR = EUMU.ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR "
                    + "and EUMU.ID_ELEMENTO_UFPR = " + elemento + ") ";
        }
        if (manifestacao != 0) {
            query += " and P.ID_PONTE in (select ID_PONTE from INSPECAO I, INSPECAO_MANIFESTACAO_ELEMENTO IME, "
                    + "ELEMENTO_UFPR_MANIFESTACAO_UFPR EUMU "
                    + "where I.ID_INSPECAO = IME.ID_INSPECAO "
                    + "and IME.ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR = EUMU.ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR "
                    + "and EUMU.ID_MANIFESTACAO_UFPR = " + manifestacao + ") ";
        }

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<Ponte> pontes = new ArrayList<>();
        Ponte ponte;
        while (rs.next()) {
            ponte = new Ponte(rs.getInt("ID_PONTE"), rs.getDouble("DS_INDICE_PERFORMANCE_RELATIVO"), 
                    new IdentificacaoObraDadosBasicos(rs.getInt("ID_IDENTIFICACAO_OBRA_DADOS_BASICOS"), 
                            rs.getString("CD_CODIGO"), rs.getString("CD_CODIGO_INTEGRACAO"), 
                            rs.getString("DS_STATUS"), rs.getString("DS_IDENTIFICACAO"), 
                            new NaturezaTransposicao(rs.getInt("ID_NATUREZA_TRANSPOSICAO"), rs.getString("DS_NATUREZA_TRANSPOSICAO")), 
                            new TipoEstrutura(rs.getInt("ID_TIPO_ESTRUTURA"), rs.getString("DS_TIPO_ESTRUTURA")), 
                            new SistemaConstrutivo(rs.getInt("ID_SISTEMA_CONSTRUTIVO"), rs.getString("DS_SISTEMA_CONSTRUTIVO")), 
                            rs.getDouble("NR_COMPRIMENTO"), rs.getDouble("NR_LARGURA"), new TremTipo(rs.getInt("ID_TREM_TIPO"), 
                                    rs.getString("DS_TREM_TIPO")), rs.getString("DS_ANO_CONSTRUCAO")), 
                    new IdentificacaoObraLocalizacao(rs.getInt("ID_IDENTIFICACAO_OBRA_LOCALIZACAO"), 
                            new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF"), rs.getString("SG_UF")), 
                            new Via(rs.getInt("ID_VIA"), rs.getString("DS_VIA")), rs.getDouble("NR_LOCAL_VIA"), 
                            rs.getString("DS_CIDADE_MAIS_PROXIMA"), rs.getString("DS_PNV_ANO"), rs.getString("DS_PNV_VERSAO"), 
                            rs.getString("DS_PNV_CODIGO"), rs.getString("DS_PNV_ALTITUDE"), rs.getString("DS_LATITUDE_GRAU"), 
                            rs.getString("DS_LATITUDE_MINUTO"), rs.getString("DS_LONGITUDE_GRAU"), rs.getString("DS_LONGITUDE_MINUTO")), 
                    null, null, null, null, null, null, null);
            ponte.setAspectosEspeciais(buscarAspectosEspeciais(ponte.getId()));
            pontes.add(ponte);
        }
        
        conexao.closeConnection();
        return pontes;
    }

    public void carregar() {

    }

//    private ArrayList<DeficienciaFuncional> buscarDeficienciasFuncionais(int idPonte) throws SQLException {
//        String query = "select ID_DEFICIENCIAS_FUNCIONAIS, CD_DEFICIENCIA_FUNCIONAL, "
//                + "DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE "
//                + "from DEFICIENCIAS_FUNCIONAIS "
//                + "where ID_PONTE = " + idPonte;
//
//        Conexao conexao = new Conexao();
//        Connection conn = conexao.getConnection();
//        Statement stmt;
//        stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery(query);
//        ArrayList<DeficienciaFuncional> deficienciasFuncionais = new ArrayList<>();
//        Ponte ponte;
//        while (rs.next()) {
//            deficienciasFuncionais.add(new DeficienciaFuncional(rs.getInt("ID_DEFICIENCIAS_FUNCIONAIS"), 
//                    rs.getString("CD_DEFICIENCIA_FUNCIONAL"), rs.getString("DS_DEFICIENCIA_FUNCIONAL"), 
//                    rs.getString("DS_UNIDADE_MEDIDA")));
//        }
//
//        return deficienciasFuncionais;
//    }

    private ArrayList<CadastroAspectoEspecial> buscarAspectosEspeciais(int idPonte) throws SQLException {
        String query = "select AE.ID_CADASTRO_ASPECTOS_ESPECIAIS, "
                + "AE.ID_ASPECTOS_ESPECIAIS, A.DS_ASPECTOS_ESPECIAIS "
                + "from CADASTRO_ASPECTOS_ESPECIAIS AE, ASPECTOS_ESPECIAIS A "
                + "where AE.ID_ASPECTOS_ESPECIAIS = A.ID_ASPECTOS_ESPECIAIS "
                + "and AE.ID_PONTE = " + idPonte;

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<CadastroAspectoEspecial> aspectosEspeciais = new ArrayList<>();
        Ponte ponte;
        while (rs.next()) {
            aspectosEspeciais.add(new CadastroAspectoEspecial(rs.getInt("ID_CADASTRO_ASPECTOS_ESPECIAIS"),
                    new AspectoEspecial(rs.getInt("ID_ASPECTOS_ESPECIAIS"), 
                            rs.getString("DS_ASPECTOS_ESPECIAIS"))));
        }

        return aspectosEspeciais;
    }

    private ArrayList<ElementoComponente> buscarElementosComponentes(int idPonte) throws SQLException {
        String query = "select EC.ID_ELEMENTO_COMPONENTES, E.CD_ELEMENTO, E.DS_ELEMENTO, "
                + "E.NR_CAPA1, E.ID_ELEMENTO_UFPR, EC.DS_DETALHE, EC.NR_QUANTIDADE "
                + "from ELEMENTO_UFPR E, ELEMENTO_COMPONENTES EC "
                + "where E.ID_ELEMENTO_UFPR = EC.ID_ELEMENTO_UFPR "
                + "and EC.ID_PONTE = " + idPonte;

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<ElementoComponente> elementosComponentes = new ArrayList<>();
        while (rs.next()) {
            elementosComponentes.add(new ElementoComponente(rs.getInt("ID_ELEMENTO_COMPONENTES"), 
                    new ElementoUfpr(rs.getInt("ID_ELEMENTO_UFPR"), rs.getString("CD_ELEMENTO"), 
                    rs.getString("DS_ELEMENTO"), rs.getDouble("NR_CAPA1")), 
                    rs.getString("DS_DETALHE"), rs.getString("NR_QUANTIDADE"))); 
        }

        return elementosComponentes;
    }

    public boolean ponteEstaSimulacao(int idPonte, int idSimulacao) throws SQLException {
        String query = "select * "
                + "from RANKING "
                + "where ID_PONTE = "+idPonte+" "
                + "and ID_SIMULACAO = "+idSimulacao+";";

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        boolean retorno = false;
        if (rs.next()) {
            retorno = true;
        }
        conexao.closeConnection();
        return retorno;
    }

//    
//    private ArrayList<ArquivoAnexo> buscarArquivosAnexos(int idPonte) throws SQLException {
//        String query = "select ID_ARQUIVO_ANEXO_INSPECAO, DS_ARQUIVO, "
//                + "DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, "
//                + "DT_DATA_ANEXACAO, ID_PONTE "
//                + "from ARQUIVO_ANEXO_INSPECAO "
//                + "where ID_PONTE = " + idPonte;
//
//        Conexao conexao = new Conexao();
//        Connection conn = conexao.getConnection();
//        Statement stmt;
//        stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery(query);
//        ArrayList<ArquivoAnexo> arquivosAnexos = new ArrayList<>();
//        Ponte ponte;
//        while (rs.next()) {
//            arquivosAnexos.add(new ArquivoAnexoCadastro(rs.getInt("ID_ARQUIVO_ANEXO_INSPECAO"), 
//                    rs.getString("DS_ARQUIVO"), rs.getString("DS_TIPO_ARQUIVO"), 
//                    rs.getString("NR_NUMERO"), rs.getString("DS_DESCRICAO"), 
//                    rs.getString("DS_REGISTRO"), rs.getDate("DT_DATA_ANEXACAO")));  
//        }
//
//        return arquivosAnexos;
//    }
}