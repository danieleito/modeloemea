/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.relatorio;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Usuario
 */
public class StringPDFbox {
    
    private String text;
    private PDType1Font font;
    private float size;

    public StringPDFbox(String text, PDType1Font font, float size) {
        this.text = text;
        this.font = font;
        this.size = size;
    } 
   
    
    public float getWidth() throws IOException{
        return font.getStringWidth(text) / 1000 * size;
    }
    
    public void draw(PDPageContentStream contentStream, float x, float y) throws IOException{
        
        contentStream.setFont(font, size);
        contentStream.beginText();
        contentStream.newLineAtOffset(x,y);
        contentStream.showText(text);
        contentStream.endText();
        
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PDType1Font getFont() {
        return font;
    }

    public void setFont(PDType1Font font) {
        this.font = font;
    }



    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
    
    
    
}
