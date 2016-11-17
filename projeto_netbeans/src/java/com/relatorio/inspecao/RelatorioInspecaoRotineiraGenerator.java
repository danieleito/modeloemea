/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relatorio.inspecao;

import com.dao.InspecaoDAO;
import com.dao.PonteDAO;
import com.model.Inspecao;
import com.model.Ponte;
import com.relatorio.RelatorioGenerator;
import com.relatorio.ponte.RelatorioPonteGenerator;
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
public class RelatorioInspecaoRotineiraGenerator  extends RelatorioGenerator{
    
    
    public static void main(String[] args) {
        InspecaoDAO inspecaoDAO = new InspecaoDAO();
        Inspecao inspecao = new Inspecao();
        try {
            inspecao = inspecaoDAO.buscar(1);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioInspecaoRotineiraGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            generatePdf(inspecao);
        } catch (IOException ex) {
            Logger.getLogger(RelatorioInspecaoRotineiraGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static void generatePdf(Inspecao inspecao) throws IOException {
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        
        //PAGE INFO
        final float marginX = 10;
        final float fullContentWidth = (float) (page.getCropBox().getWidth() - (2 * marginX));
        final float sixthContentWidth = (float) (fullContentWidth * 1.666666);
        final float topY = page.getCropBox().getHeight() - 20;
        
        //TODO: Descobrir a diferença entre a inspecao.getData() e inspecao.getIdentificacaoObraSgo().getDataInspecao()
        String[][] contentPrimeiraSecaoIdentificacao = {
            {"Código:", inspecao.getRelatorio()},
           // {"Data da Inspeção:", inspecao.getIdentificacaoObraSgo().getDataInspecao().toString()}
        };

        String[][] contentSegundaSecaoIdentificacao = {
            {"QUE CAMPO É ESSE?",""},
            {"Inspetor:",inspecao.getIdentificacaoObraSgo().getNomeInspetor()}
        };
        
       
        
   
     }
    
}
