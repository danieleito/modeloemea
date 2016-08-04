/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.CondicaoSgo;
import com.model.DanoElementoSgo;
import com.model.IdentificacaoObraSgo;
import com.model.Inspecao;
import com.model.InspecaoRotineira;
import com.model.InsuficienciaEstruturalElementoSgo;
import com.model.LaudoEspecializadoSgo;
import com.model.Modelo;
import com.model.MonitoramentoSgo;
import com.model.Ponte;
import com.model.SuperintendenciaRegional;
import com.model.Uf;
import com.model.Usuario;
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
public class InspecaoRotineiraDAO {
    public InspecaoRotineira buscar(int id) throws SQLException {
        String query = "select IR.ID_INSPECAO_ROTINEIRA, IR.ID_INSPECAO, I.DT_DATA, I.ID_USUARIO, USU.ID_USUARIO, USU.NM_NOME, USU.DS_USUARIO, "
                + "I.ID_PONTE, I.ID_MODELO, MO.DS_INDICE_BASE, MO.DS_INDICE_PERFORMANCE, IR.ID_IDENTIFICACAO_OBRA_SGO, IO.CD_CODIGO, IO.DT_DATA_INSPECAO, "
                + "IO.NM_PONTE, IO.NM_INSPETOR, IO.ID_VIA, V.DS_VIA, IO.ID_UF, U.DS_UF, U.SG_UF, IO.DS_KM, IO.ID_SUPERINTENDENCIA_REGIONAL, "
                + "SR.DS_SUPERINTENDENCIA_REGIONAL, IO.DS_UL, IR.ID_CONDICOES_SGO, C.DS_CONDICAO_ESTABILIDADE, C.DS_CONDICAO_CONSERVACAO, C.DS_OBSERVACOES, C.DS_NOTA_TECNICA, "
                + "IR.ID_DANOS_ELEMENTOS_SGO, DE.DS_ELEMENTO, DE.DS_NOTA, DE.DS_DANO, DE.DS_UNIDADE, DE.DS_QUANTIDADE, DE.DS_EXTENSAO_RELATIVA, DE.DS_LOCALIZACAO, "
                + "IR.ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO, IE.DS_ELEMENTO, IE.DS_NOTA, IE.DS_INSUFICIENCIA, IE.DS_CAUSA_PROVAVEL, IE.DS_COMENTARIOS, "
                + "IR.ID_LAUDO_ESPECIALIZADO_SGO, LE.DT_DATA_LAUDO, LE.DS_CONSULTOR, LE.DS_OBSERVACOES, "
                + "IR.ID_MONITORAMENTO_SGO, M.DS_PERIODO, M.DS_TIPO_MONITORAMENTO, M.DS_EXECUTOR, M.DS_CUSTO, M.DS_OBJETO, M.DS_TECNICAS, "
                + "IR.DS_RELATORIO "
                
                
                + "from INSPECAO_ROTINEIRA IR, IDENTIFICACAO_OBRA_SGO IO, CONDICOES_SGO C, DANOS_ELEMENTOS_SGO DE, INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO IE, "
                + "LAUDO_ESPECIALIZADO_SGO LE, MONITORAMENTO_SGO M, UF U, VIA V, INSPECAO I, USUARIO USU, PONTE P, MODELO MO, SUPERINTENDENCIA_REGIONAL SR "
                
                
                + "where IR.ID_IDENTIFICACAO_OBRA_SGO = IO.ID_IDENTIFICACAO_OBRA_SGO "
                + "and IR.ID_CONDICOES_SGO = C.ID_CONDICOES_SGO "
                + "and IR.ID_DANOS_ELEMENTOS_SGO = DE.ID_DANOS_ELEMENTOS_SGO "
                + "and IR.ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO = IE.ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO "
                + "and IR.ID_LAUDO_ESPECIALIZADO_SGO = LE.ID_LAUDO_ESPECIALIZADO_SGO "
                + "and IR.ID_MONITORAMENTO_SGO = M.ID_MONITORAMENTO_SGO "
                + "and IR.ID_INSPECAO = I.ID_INSPECAO "
                + "and I.ID_USUARIO = USU.ID_USUARIO "
                + "and I.ID_PONTE = P.ID_PONTE "
                + "and I.ID_MODELO = MO.ID_MODELO "
                + "and IO.ID_UF = U.ID_UF "
                + "and IO.ID_VIA = V.ID_VIA "
                + "and IO.ID_SUPERINTENDENCIA_REGIONAL = SR.ID_SUPERINTENDENCIA_REGIONAL; ";
                
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        InspecaoRotineira inspecaoRotineira = null;
        
        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("ID_USUARIO"));
            usuario.setNome(rs.getString("NM_NOME"));
            usuario.setUsuario(rs.getString("DS_USUARIO"));
            
            inspecaoRotineira = new InspecaoRotineira(rs.getInt("ID_INSPECAO_ROTINEIRA"), 
                    new Inspecao(rs.getInt("ID_INSPECAO"), rs.getDate("DT_DATA"), usuario, new Ponte(rs.getInt("ID_PONTE")), new Modelo(rs.getInt("ID_MODELO"), rs.getString("DS_INDICE_BASE"), rs.getString("DS_INDICE_PERFORMANCE"))), 
                    new IdentificacaoObraSgo(rs.getInt("ID_IDENTIFICACAO_OBRA_SGO"), rs.getString("CD_CODIGO"), rs.getDate("DT_DATA_INSPECAO"), rs.getString("NM_PONTE"), rs.getString("NM_INSPETOR"), new Via(rs.getInt("ID_VIA"), rs.getString("DS_VIA")), rs.getString("DS_KM"), new SuperintendenciaRegional(rs.getInt("ID_SUPERINTENDENCIA_REGIONAL"), rs.getString("DS_SUPERINTENDENCIA_REGIONAL"), new Uf(rs.getInt("ID_UF"), rs.getString("DS_UF"), rs.getString("SG_UF"))), rs.getString("DS_UL")), 
                    new CondicaoSgo(rs.getInt("ID_CONDICOES_SGO"), rs.getString("DS_CONDICAO_ESTABILIDADE"), rs.getString("DS_CONDICAO_CONSERVACAO"), rs.getString("DS_OBSERVACOES"), rs.getString("DS_NOTA_TECNICA")), 
                    new DanoElementoSgo(rs.getInt("ID_DANOS_ELEMENTOS_SGO"), rs.getString("DS_ELEMENTO"), rs.getString("DS_NOTA"), rs.getString("DS_DANO"), rs.getString("DS_UNIDADE"), rs.getString("DS_QUANTIDADE") , rs.getString("DS_EXTENSAO_RELATIVA"), rs.getString("DS_LOCALIZACAO")), 
                    new InsuficienciaEstruturalElementoSgo(rs.getInt("ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO"), rs.getString("DS_ELEMENTO"), rs.getString("DS_NOTA"), rs.getString("DS_INSUFICIENCIA"), rs.getString("DS_CAUSA_PROVAVEL"), rs.getString("DS_COMENTARIOS")), 
                    new LaudoEspecializadoSgo(rs.getInt("ID_LAUDO_ESPECIALIZADO_SGO"), rs.getDate("DT_DATA_LAUDO"), rs.getString("DS_CONSULTOR"), rs.getString("DS_OBSERVACOES")), 
                    new MonitoramentoSgo(rs.getInt("ID_MONITORAMENTO_SGO"), rs.getString("DS_PERIODO"), rs.getString("DS_TIPO_MONITORAMENTO"), rs.getString("DS_EXECUTOR"), rs.getString("DS_CUSTO"), rs.getString("DS_OBJETO"), rs.getString("DS_TECNICAS")), 
                    rs.getString("DS_RELATORIO"));
        }
        conexao.closeConnection(); 
        return inspecaoRotineira;
    }
    
}
