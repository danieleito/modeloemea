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
import com.relatorio.RelatorioGenerator;
import com.relatorio.StringPDFbox;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Usuario
 */
public class RelatorioPonteGenerator  extends RelatorioGenerator{

    public static void main(String[] args) {
        PonteDAO ponteDao = new PonteDAO();
        Ponte ponte = new Ponte();
        try {
            ponte = ponteDao.buscar(1);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioPonteGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            RelatorioPonteGenerator.generatePdf(ponte,"C:\\\\Users\\\\Usuario\\\\Documents\\\\test.pdf" );
        } catch (IOException ex) {
            Logger.getLogger(RelatorioPonteGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void generatePdf(Ponte ponte, String path) throws IOException {
        PDDocument doc = new PDDocument();
        PDPage page1 = new PDPage();
        doc.addPage(page1);
        PDPageContentStream contentStream = new PDPageContentStream(doc, page1);
        
        //PAGE INFO
        final float marginX = 10;
        final float fullContentWidth = (float) (page1.getCropBox().getWidth() - (2 * marginX));
        final float halfContentWidth = (float) (fullContentWidth * 0.5);
        final float topY = page1.getCropBox().getHeight() - 20;
        
        int contSection = 2;
        
        IdentificacaoObraDadosBasicos dadosBasicos = ponte.getIdentificacaoObraDadosBasicos();
        IdentificacaoObraResponsaveis responsaveis = ponte.getIdentificacaoObraResponsaveis();
        IdentificacaoObraLocalizacao localizacao = ponte.getIdentificacaoObraLocalizacao();
        IdentificacaoObraInspecao inspecao = ponte.getIdentificacaoObraInspecao();

        CaracteristicasFuncionaisCaracteristicas caracteristicasFuncionaisCaracteristicas = ponte.getCaracteristicasFuncionaisCaracteristicas();
        CaracteristicasFuncionaisDimensoes caracteristicasFuncionaisDimensoes = ponte.getCaracteristicasFuncionaisDimensoes();

        String[][] contentSecaoDadosBasicos = {
            /**
             * IDENTIFICACAO DA OBRA
             */
            {"Dados B�sicos", "-----"},
            {"C�digo", dadosBasicos.getCodigo()},
            {"Identifica��o", dadosBasicos.getIdentificacao()},
            //TODO: Formatar data
            {"�lt. Atualiza��o", ponte.getDataUltimaInspecao().toString()},
            {"Nat. Transposi��o", dadosBasicos.getNaturezaTransposicao().toString()},
            {"Sistema Construtivo", dadosBasicos.getSistemaConstrutivo().toString()},
            {"Comp/Larg(m)", dadosBasicos.getComprimento() + "/" + dadosBasicos.getLargura()},
            {"Trem-Tipo", dadosBasicos.getTremTipo().toString()},
            {"Constru��o", dadosBasicos.getAnoConstrucao().toString()},};
        String[][] contentSecaoLocalizacao = {{"Localiza��o", "-----"},
        {"Via/UF/Km", localizacao.getVia() + "/" + localizacao.getUf() + "/" + localizacao.getLocalVia()},
        {"Trecho", localizacao.getPnvCodigo() + "/" + localizacao.getPnvAno() + "/" + localizacao.getPnvVersao()},
        {"Cidade Prox.", localizacao.getCidadeMaisProxima()},
        {"Alt./Lat/Long", localizacao.getPnvAltitude() + "/" + localizacao.getLatitudeGrau() + " " + localizacao.getLatitudeMinuto() + "/" + localizacao.getLongitudeGrau() + " " + localizacao.getLongitudeMinuto()},
        {"Inspe��es", "-----"},
        {"Per�odo(anos)", inspecao.getPeriodo()},
        {"Equip. Necess�rio", inspecao.getEquipamentoNecessario()},
        {"Melhor �poca", inspecao.getMelhorEpoca()},};

        String[][] contentSecaoResponsaveis = {
            {"Respons�veis", "-----"},
            {"Superint. Regional", responsaveis.getUnidadeLocal().getSuperintendenciaRegional().toString()},
            {"Unidade Local", responsaveis.getUnidadeLocal().toString()},
            {"Tp. Administra��o", responsaveis.getTipoAdministracao().toString()},
            {"Administrador", responsaveis.getAdministrador()},
            {"Projetista", responsaveis.getProjetistaProjetista()},
            {"Construtor", responsaveis.getConstrutorConstrutor()},
            {"Observa��es", ponte.getObservacao().toString()},};
        String[][] contentSecao4 = {//TODO: Descobrir quais s�o os campos abaixo
            {"Loc. Projeto", ""},
            {"Loc. Doc. Constr", ""},
            {"Loc. Doc. Diversos", ""},};

      

        

        float secaoDadosBasicosEndY = drawSection(page1, contentStream, topY, marginX, halfContentWidth, "1. IDENTIFICA��O DA OBRA", contentSecaoDadosBasicos, false);

        drawSection(page1, contentStream, topY, marginX + halfContentWidth, halfContentWidth, "", contentSecaoLocalizacao, true);

        float identificacaoObraEndY = drawSection(page1, contentStream, secaoDadosBasicosEndY, marginX, halfContentWidth, "", contentSecaoResponsaveis, false);

        drawSection(page1, contentStream, secaoDadosBasicosEndY, marginX + halfContentWidth, halfContentWidth, "", contentSecao4, true);

        //TODO: colocar caracteristicasFuncionaisSecao1 no relat�rio
        String[][] caracteristicasFuncionaisSecao1 = {
            /**
             * CARACTER�STICAS FUNCIONAIS
             */
            {"Regi�o", caracteristicasFuncionaisCaracteristicas.getTipoRegiao().toString()},
            //TODO: Descobrir se mostra ou n�o o raio se for nulo
            {"Tra�ada/Raio(m)", caracteristicasFuncionaisCaracteristicas.getRaioCurva() == null ? "N�o possui" : caracteristicasFuncionaisCaracteristicas.getRaioCurva()},
            {"Rampa Max�ma", caracteristicasFuncionaisCaracteristicas.getRampaMaxima()},
            {"VMD", caracteristicasFuncionaisCaracteristicas.getVmd()},
            {"N� de V�os", caracteristicasFuncionaisDimensoes.getNumeroVaos()},
            {"Descr. dos V�os", caracteristicasFuncionaisDimensoes.getDescricaoVaos()}
        };
        String[][] caracteristicasFuncionaisSecao2 = {
            {"Largura total da pista(m)", caracteristicasFuncionaisDimensoes.getLarguraTotalPista()},
            {"N� de Faixas/Larg. Faixa(m)", caracteristicasFuncionaisDimensoes.getNumeroFaixas() + "/" + caracteristicasFuncionaisDimensoes.getLarguraFaixa()},
            {"Larg. Acost. Dir/Esq", caracteristicasFuncionaisDimensoes.getAcostamentoDireito() + "/" + caracteristicasFuncionaisDimensoes.getAcostamentoEsquerdo()},
            {"Larg. Cal�ada Dir/Esqauerda", caracteristicasFuncionaisDimensoes.getCalcadaDireita() + "/" + caracteristicasFuncionaisDimensoes.getCalcadaEsquerda()},
            {"Gabarito Horiz/Vertical(m)", caracteristicasFuncionaisDimensoes.getGabaritoHorizontal() + "/" + caracteristicasFuncionaisDimensoes.getGabaritoVertical()}
        };

          final float caracteristicasFuncionaisTopY = identificacaoObraEndY - 20;

        final float caracteristicasFuncionaisEndY = drawSection(page1, contentStream, caracteristicasFuncionaisTopY, marginX, halfContentWidth, "2. CARACTERISTICAS FUNCIONAIS", contentSecaoDadosBasicos, false);

        drawSection(page1, contentStream, caracteristicasFuncionaisTopY, marginX + halfContentWidth, halfContentWidth, "", caracteristicasFuncionaisSecao2, true);
          
        //ELEMENTOS COMPONENTES
        final float elementosComponentesTopY = caracteristicasFuncionaisEndY - 20;
        float elementosComponentesEndY = caracteristicasFuncionaisEndY;
        
        if (ponte.getElementosComponentes().size() > 0) {
            String[][] contentSecaoElementosComponentes = new String[ponte.getElementosComponentes().size()][2];
      
            int i = 0;
            for (ElementoComponente ec : ponte.getElementosComponentes()) {
                //TODO: DESCOBRIR DA ONDE PUXAR OS DADOS
                contentSecaoElementosComponentes[i][0] = ec.getElementoUfpr().getCodigo();
                contentSecaoElementosComponentes[i][1] = ec.getElementoUfpr().getDescricao();
                ++i;
            }
            
           
          elementosComponentesEndY =  drawSection(page1, contentStream, elementosComponentesTopY, marginX, fullContentWidth, ++contSection + ". ELEMENTOS COMPONENTES", contentSecaoElementosComponentes, false);
            
        }
       
        //TODO: Testar aspectos 
        final float aspectosEspeciaisTopY = elementosComponentesEndY - 20;
        float aspectosEspeciaisEndY = elementosComponentesEndY;
        if (ponte.getAspectosEspeciais().size() > 0) {
            String[][] contentAspectosEspeciais = new String[ponte.getAspectosEspeciais().size()][2];

  
            int i = 0;
            for (CadastroAspectoEspecial ae : ponte.getAspectosEspeciais()) {
                //TODO: Descobir qual � o valor real da primeira coluna
                contentAspectosEspeciais[i][0] = Integer.toString(ae.getAspectoEspecial().getId());
                contentAspectosEspeciais[i][1] = ae.getAspectoEspecial().getDescricao();
                ++i;
            }

            
            aspectosEspeciaisEndY = drawSection(page1, contentStream, aspectosEspeciaisTopY, marginX, fullContentWidth, ++contSection + ". ASPECTOS ESPECIAIS", contentAspectosEspeciais, false);
            
        }
       

        /**
         * P�GINA 5
         */
        /*
     TODO: Consertar NULLPOINT do defici�ncias funcionais
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
        
        
        final float rotasAlternativasTopY = aspectosEspeciaisEndY - 20;
        float rotasAlternativasEndY = aspectosEspeciaisEndY;
       String[][]  contentRotaRotas = {
           {"Rota:", ponte.getRotasAlternativas().getIdentificacao()}
       };
        String[][]  contentAcrescimoRota = {
           {"Acr�scimo de Km:", ponte.getRotasAlternativas().getAcrescimoKm()}
        };
        
        drawSection(page1, contentStream, rotasAlternativasTopY, marginX, halfContentWidth, ++contSection + ". ROTAS ALTERNATIVAS", contentRotaRotas, false);
        drawSection(page1, contentStream, rotasAlternativasTopY, marginX + halfContentWidth , halfContentWidth, "", contentAcrescimoRota, false);
        contentStream.close();
        /**
         * P�GINA 5
         */
        /**
         * TODO: Descobrir se pode apenas ter uma �nica rota alternativa
         * if(ponte.getRotasAlternativas().size() > 0){ String[][] contentP4 =
         * new String[ponte.getAspectosEspeciais().size()+1][2];
         *
         * contentP4[0][0] = "4"; contentP4[0][1] = "Aspectos Especiais";
         *
         * int i=1; for (CadastroAspectoEspecial ae:
         * ponte.getAspectosEspeciais()) { //TODO: Descobir qual � o valor real
         * da primeira coluna contentP4[i][0] =
         * Integer.toString(ae.getAspectoEspecial().getId()); contentP4[i][1] =
         * ae.getAspectoEspecial().getDescricao(); ++i; }
         *
         * PDPage page4 = new PDPage(); doc.addPage(page4); PDPageContentStream
         * contentStream4 = new PDPageContentStream(doc, page4);
         * PdfGenerator.drawTable(page4, contentStream4, 700, 100, contentP4);
         * contentStream4.close(); }
         *
         */
        //final String path = "C:\\Users\\Usuario\\Documents\\test.pdf";
        doc.save(path);
        //OPEN FILE
    }

   

}
