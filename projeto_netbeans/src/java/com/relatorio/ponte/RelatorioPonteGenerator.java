/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relatorio.ponte;

import com.dao.PonteDAO;
import com.model.IdentificacaoObraDadosBasicos;
import com.model.IdentificacaoObraInspecao;
import com.model.IdentificacaoObraLocalizacao;
import com.model.IdentificacaoObraResponsaveis;
import com.model.Ponte;
import com.relatorio.PdfGenerator;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

/**
 *
 * @author Usuario
 */
public class RelatorioPonteGenerator {
    
    public static void main(String[] args) {
        PonteDAO ponteDao = new  PonteDAO();
        Ponte ponte = new Ponte();
        try {
            ponte = ponteDao.buscar(1);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioPonteGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            RelatorioPonteGenerator.generatePdf(ponte);
        } catch (IOException ex) {
            Logger.getLogger(RelatorioPonteGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void generatePdf(Ponte ponte) throws IOException{
    PDDocument doc = new PDDocument();
    PDPage page = new PDPage();
    doc.addPage( page );
    PDPageContentStream contentStream = new PDPageContentStream(doc, page);

    IdentificacaoObraDadosBasicos dadosBasicos = ponte.getIdentificacaoObraDadosBasicos();
    IdentificacaoObraResponsaveis responsaveis = ponte.getIdentificacaoObraResponsaveis();
    IdentificacaoObraLocalizacao localizacao = ponte.getIdentificacaoObraLocalizacao();
    IdentificacaoObraInspecao inspecao = ponte.getIdentificacaoObraInspecao();
    String[][] content = {
        {"Dados Básicos",""},
        {"Código",dadosBasicos.getCodigo()},
        {"Identificação",dadosBasicos.getIdentificacao()},
        //TODO: Formatar data
        {"Últ. Atualização", ponte.getDataUltimaInspecao().toString()},
        {"Nat. Transposição",dadosBasicos.getNaturezaTransposicao().toString()},
        
        {"Sistema Construtivo",dadosBasicos.getSistemaConstrutivo().toString()},
        {"Comp/Larg(m)",dadosBasicos.getComprimento()+"/"+dadosBasicos.getLargura()},
        {"Trem-Tipo",dadosBasicos.getTremTipo().toString()},
        {"Construção",dadosBasicos.getAnoConstrucao().toString()},
        

        {"Responsáveis",""},
        {"Superint. Regional", responsaveis.getUnidadeLocal().getSuperintendenciaRegional().toString()},
        {"Unidade Local", responsaveis.getUnidadeLocal().toString()},
        {"Tp. Administração",responsaveis.getTipoAdministracao().toString()}, 
        {"Administrador",responsaveis.getAdministrador()},
        {"Projetista", responsaveis.getProjetistaProjetista()},
        {"Construtor", responsaveis.getConstrutorConstrutor()},
        {"Observações", ponte.getObservacao().toString()},
       
        {"Loc. Projeto", ""},
        {"Loc. Doc. Constr;", ""},
        {"Loc. Doc. Diversos",""},
        
        {"Localização",""},
        {"Via/UF/Km", localizacao.getVia()+"/"+localizacao.getUf()+"/"+localizacao.getLocalVia()},
        {"Trecho", localizacao.getPnvCodigo()+"/"+localizacao.getPnvAno()+"/"+localizacao.getPnvVersao()},
        {"Cidade Prox.",localizacao.getCidadeMaisProxima()}, 
        {"Alt./Lat/Long",localizacao.getPnvAltitude()+"/"+localizacao.getLatitudeGrau()+" "+localizacao.getLatitudeMinuto()+"/"+ localizacao.getLongitudeGrau()+" "+localizacao.getLongitudeMinuto()},
        
        {"Inspeções",""},
        {"Período(anos)", inspecao.getPeriodo()},
        {"Equip. Necessário", inspecao.getEquipamentoNecessario()},
        {"Melhor Época", inspecao.getMelhorEpoca()}, 
    } ;

        PdfGenerator.drawTable(page, contentStream, 700, 100, content);

    contentStream.close();
    doc.save("C:\\Users\\Usuario\\Documents\\test.pdf" );
        
    }
    
}
