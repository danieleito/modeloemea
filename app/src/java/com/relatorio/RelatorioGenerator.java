/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.relatorio;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.pdfbox.contentstream.PDFGraphicsStreamEngine;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.rendering.PageDrawer;
import org.apache.pdfbox.rendering.PageDrawerParameters;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;

/**
 * Example showing custom rendering by subclassing PageDrawer.
 * 
 * <p>If you want to do custom graphics processing rather than Graphics2D rendering, then you should
 * subclass {@link PDFGraphicsStreamEngine} instead. Subclassing PageDrawer is only suitable for
 * cases where the goal is to render onto a Graphics2D surface.
 *
 * @author John Hewson
 */
public class RelatorioGenerator 
{
    
    
  /* public static void main(String[] args) throws IOException {
    PDDocument doc = new PDDocument();
    PDPage page = new PDPage();
    doc.addPage( page );
    PDPageContentStream contentStream = new PDPageContentStream(doc, page);

    String[][] content = {
        {"Name"," Time "},
        {"HTC","01:25"},
        {"Samsung Tab2","05:30"}
    } ;
    
    //PAGE INFO
     final float marginX = 10;
     final float halfContentWidth = page.getCropBox().getWidth() - 2*marginX;
     final float topY = page.getCropBox().getHeight() - 20;
     
    final float primeiraSecaoWidth = (float) (halfContentWidth * 0.5);
    drawSection(page, contentStream, topY, marginX , primeiraSecaoWidth ,"1. IDENTIFICAÇÃO DA OBRA", content, false);

    final  float segundaSecaoWidth = primeiraSecaoWidth;
    drawSection(page, contentStream, topY, marginX + primeiraSecaoWidth, segundaSecaoWidth ,"", content, true);
    
    contentStream.close();
    final String path = "C:\\Users\\Usuario\\Documents\\test.pdf";
    doc.save(path);
    
    //OPEN FILE
    if (Desktop.isDesktopSupported()) {
    try {
        File myFile = new File(path);
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
    }
}
} 

*/
   public static float drawSection(PDPage page, PDPageContentStream contentStream,
            float y, float x, float width,
            String title, String[][] content, boolean lineLeft) throws IOException {

        //DRAW TITTLE
        StringPDFbox titlePDFbox = new StringPDFbox(title, PDType1Font.HELVETICA_BOLD, 7);
        final float titlex = x;
        final float titley = y;
        titlePDFbox.draw(contentStream, titlex, titley);
        //DRAW TITLE LINE
        final float titleLineY = titley - 5f;
        contentStream.moveTo(titlex, titleLineY);
        contentStream.lineTo(titlex + width, titleLineY);
        contentStream.stroke();

        //DRAW CONTENT
        final float marginContentLeft = lineLeft ? 5 : 0;
        final float marginContentTop = 10;
        final float marginContentRight = 100;
        final float topicTitleX = x + marginContentLeft;
        final float topicContentX = topicTitleX + marginContentRight;
        for (int i = 0; i < content.length; ++i) {
            StringPDFbox topicTitle = new StringPDFbox(content[i][0], PDType1Font.HELVETICA_BOLD, 5);
            StringPDFbox topicContent = new StringPDFbox(content[i][1], PDType1Font.HELVETICA_BOLD, 5);

            //TODO: Descer texto conforme não tem mais espaço na linha
            final float topicY = titleLineY - ((i + 1) * marginContentTop);
            topicTitle.draw(contentStream, topicTitleX, topicY);
            topicContent.draw(contentStream, topicContentX, topicY);
        }

        final float endY = titleLineY - (content.length * marginContentTop) - 10;
        if (lineLeft) {
            contentStream.moveTo(titlex, titleLineY);
            contentStream.lineTo(titlex, endY);
            contentStream.stroke();
        }
        return endY;
    }
}
 