/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relatorio.ponte;

import com.dao.PonteDAO;
import com.model.AspectoEspecial;
import com.model.CadastroAspectoEspecial;
import com.model.CaracteristicasFuncionaisCaracteristicas;
import com.model.CaracteristicasFuncionaisDimensoes;
import com.model.DeficienciaFuncional;
import com.model.ElementoComponente;
import com.model.IdentificacaoObraDadosBasicos;
import com.model.IdentificacaoObraInspecao;
import com.model.IdentificacaoObraLocalizacao;
import com.model.IdentificacaoObraResponsaveis;
import com.model.Ponte;
import com.relatorio.PdfGenerator;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
    
    IdentificacaoObraDadosBasicos dadosBasicos = ponte.getIdentificacaoObraDadosBasicos();
    IdentificacaoObraResponsaveis responsaveis = ponte.getIdentificacaoObraResponsaveis();
    IdentificacaoObraLocalizacao localizacao = ponte.getIdentificacaoObraLocalizacao();
    IdentificacaoObraInspecao inspecao = ponte.getIdentificacaoObraInspecao();
    
    CaracteristicasFuncionaisCaracteristicas caracteristicasFuncionaisCaracteristicas = ponte.getCaracteristicasFuncionaisCaracteristicas();
    CaracteristicasFuncionaisDimensoes caracteristicasFuncionaisDimensoes = ponte.getCaracteristicasFuncionaisDimensoes();
    
      
    String[][] contentP1 = {
        /**
         * IDENTIFICACAO DA OBRA
         */
        {"1","Identificação da Obra"},
        {"Dados Básicos","-----"},
        {"Código",dadosBasicos.getCodigo()},
        {"Identificação",dadosBasicos.getIdentificacao()},
        //TODO: Formatar data
        {"Últ. Atualização", ponte.getDataUltimaInspecao().toString()},
        {"Nat. Transposição",dadosBasicos.getNaturezaTransposicao().toString()},      
        {"Sistema Construtivo",dadosBasicos.getSistemaConstrutivo().toString()},
        {"Comp/Larg(m)",dadosBasicos.getComprimento()+"/"+dadosBasicos.getLargura()},
        {"Trem-Tipo",dadosBasicos.getTremTipo().toString()},
        {"Construção",dadosBasicos.getAnoConstrucao().toString()},
        

        {"Responsáveis","-----"},
        {"Superint. Regional", responsaveis.getUnidadeLocal().getSuperintendenciaRegional().toString()},
        {"Unidade Local", responsaveis.getUnidadeLocal().toString()},
        {"Tp. Administração",responsaveis.getTipoAdministracao().toString()}, 
        {"Administrador",responsaveis.getAdministrador()},
        {"Projetista", responsaveis.getProjetistaProjetista()},
        {"Construtor", responsaveis.getConstrutorConstrutor()},
        {"Observações", ponte.getObservacao().toString()},
       
        //TODO: Descobrir quais são os campos abaixo
        {"Loc. Projeto", ""},
        {"Loc. Doc. Constr;", ""},
        {"Loc. Doc. Diversos",""},
        
        {"Localização","-----"},
        {"Via/UF/Km", localizacao.getVia()+"/"+localizacao.getUf()+"/"+localizacao.getLocalVia()},
        {"Trecho", localizacao.getPnvCodigo()+"/"+localizacao.getPnvAno()+"/"+localizacao.getPnvVersao()},
        {"Cidade Prox.",localizacao.getCidadeMaisProxima()}, 
        {"Alt./Lat/Long",localizacao.getPnvAltitude()+"/"+localizacao.getLatitudeGrau()+" "+localizacao.getLatitudeMinuto()+"/"+ localizacao.getLongitudeGrau()+" "+localizacao.getLongitudeMinuto()},
        
        {"Inspeções","-----"},
        {"Período(anos)", inspecao.getPeriodo()},
        {"Equip. Necessário", inspecao.getEquipamentoNecessario()},
        {"Melhor Época", inspecao.getMelhorEpoca()},

    } ;
        
        PDPage page1 = new PDPage();
        doc.addPage(page1);
        PDPageContentStream contentStream = new PDPageContentStream(doc, page1);
        PdfGenerator.drawTable(page1, contentStream, 700, 100, contentP1);
         contentStream.close();
        /**
         *  PÁGINA 2
         */
        String[][] contentP2 = {
                /**
         * CARACTERÍSTICAS FUNCIONAIS
         */
        {"2","Características Funcionais"},
        {"Região", caracteristicasFuncionaisCaracteristicas.getTipoRegiao().toString()},
        //TODO: Somente se a ponte for curva existe o raio
        {"Traçada/Raio(m)", "ARRUMAR"},
        {"Rampa Maxíma", caracteristicasFuncionaisCaracteristicas.getRampaMaxima()},
        {"VMD", caracteristicasFuncionaisCaracteristicas.getVmd()},
        {"N° de Vãos", caracteristicasFuncionaisDimensoes.getNumeroVaos()},
        {"Descr. dos Vãos", caracteristicasFuncionaisDimensoes.getDescricaoVaos()},
        
        {"Largura total da pista(m)", caracteristicasFuncionaisDimensoes.getLarguraTotalPista()},
        {"N° de Faixas/Larg. Faixa(m)", caracteristicasFuncionaisDimensoes.getNumeroFaixas()+"/"+caracteristicasFuncionaisDimensoes.getLarguraFaixa()},
        {"Larg. Acost. Dir/Esq", caracteristicasFuncionaisDimensoes.getAcostamentoDireito()+"/"+caracteristicasFuncionaisDimensoes.getAcostamentoEsquerdo()},
        {"Larg. Calçada Dir/Esqauerda", caracteristicasFuncionaisDimensoes.getCalcadaDireita()+"/"+caracteristicasFuncionaisDimensoes.getCalcadaEsquerda()},
        {"Gabarito Horiz/Vertical(m)", caracteristicasFuncionaisDimensoes.getGabaritoHorizontal()+"/"+caracteristicasFuncionaisDimensoes.getGabaritoVertical()},
                
        };
        
        
        PDPage page2 = new PDPage();
        doc.addPage(page2);
        PDPageContentStream contentStream2 = new PDPageContentStream(doc, page2);
        PdfGenerator.drawTable(page2, contentStream2, 700, 100, contentP2);
        contentStream2.close();
        
      /**
       * TODO: Adicionar nova página dinâmicamente
       * PÁGINA 3
       */  
     
      if(ponte.getElementosComponentes().size()>0){
        String[][] contentP3 = new String[ponte.getElementosComponentes().size()+1][2];
        contentP3[0][0] = "3";
        contentP3[0][1] = "Elementos Componentes";

          int i=1;
          for (ElementoComponente ec : ponte.getElementosComponentes()) {
              //TODO: DESCOBRIR DA ONDE PUXAR OS DADOS
              contentP3[i][0] = ec.getElementoUfpr().getCodigo();
              contentP3[i][1] = ec.getElementoUfpr().getDescricao();
              ++i;
          }

        PDPage page3 = new PDPage();
        doc.addPage(page3);
        PDPageContentStream contentStream3 = new PDPageContentStream(doc, page3);
        PdfGenerator.drawTable(page3, contentStream3, 700, 100, contentP3);
        contentStream3.close();
      }
    /**
       * PÁGINA 4
       */  
      
    if(ponte.getAspectosEspeciais().size() > 0){
        String[][] contentP4 = new String[ponte.getAspectosEspeciais().size()+1][2];
        
        contentP4[0][0] = "4";
        contentP4[0][1] = "Aspectos Especiais";

          int i=1;
        for (CadastroAspectoEspecial ae: ponte.getAspectosEspeciais()) {
            //TODO: Descobir qual é o valor real da primeira coluna
            contentP4[i][0] = Integer.toString(ae.getAspectoEspecial().getId());
            contentP4[i][1] = ae.getAspectoEspecial().getDescricao();
            ++i;
        }

        PDPage page4 = new PDPage();
        doc.addPage(page4);
        PDPageContentStream contentStream4 = new PDPageContentStream(doc, page4);
        PdfGenerator.drawTable(page4, contentStream4, 700, 100, contentP4);
        contentStream4.close();
    }
    
    
     /**
       * PÁGINA 5
       */  
     /*
     TODO: Consertar NULLPOINT do deficiências funcionais
    if(ponte.getDeficienciasFuncionais().size() > 0){
        String[][] contentP5 = new String[ponte.getDeficienciasFuncionais().size()][2];

        int i=0;
        for (DeficienciaFuncional df: ponte.getDeficienciasFuncionais()) {
            //TODO: Descobir o significado do campo unidadeMedia
            contentP5[i][0] = df.getCodigo();
            contentP5[i][1] = df.getDescricao();
            ++i;
        }

        PDPage page5 = new PDPage();
        doc.addPage(page5);
        PDPageContentStream contentStream5 = new PDPageContentStream(doc, page5);
        PdfGenerator.drawTable(page5, contentStream5, 700, 100, contentP5);
        contentStream5.close();
    }
    */
     
    /**
       * PÁGINA 5
       */  
     
    /** TODO: Descobrir se pode apenas ter uma única rota alternativa
    if(ponte.getRotasAlternativas().size() > 0){
        String[][] contentP4 = new String[ponte.getAspectosEspeciais().size()+1][2];
        
        contentP4[0][0] = "4";
        contentP4[0][1] = "Aspectos Especiais";

          int i=1;
        for (CadastroAspectoEspecial ae: ponte.getAspectosEspeciais()) {
            //TODO: Descobir qual é o valor real da primeira coluna
            contentP4[i][0] = Integer.toString(ae.getAspectoEspecial().getId());
            contentP4[i][1] = ae.getAspectoEspecial().getDescricao();
            ++i;
        }

        PDPage page4 = new PDPage();
        doc.addPage(page4);
        PDPageContentStream contentStream4 = new PDPageContentStream(doc, page4);
        PdfGenerator.drawTable(page4, contentStream4, 700, 100, contentP4);
        contentStream4.close();
    }
    
    */
    doc.save("C:\\Users\\Usuario\\Documents\\test.pdf" );
        
    }
    
}
