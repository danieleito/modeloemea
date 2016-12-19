/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servilet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniele Harumi Ito
 */
@WebServlet(name = "FileManager", urlPatterns = {"/FileManager"})
public class FileManager extends HttpServlet {
    
    private String getBasePath() {
        return System.getProperty("jboss.server.data.dir") + File.separatorChar + 
                "imagens" + File.separatorChar;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("getImage")) {
            getImage(request, response);
        } else if (action.equalsIgnoreCase("getPdf")) {
            getPdf(request, response);
        }
    }
    
    public void getImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = request.getServletContext();
        String pathImagem = getBasePath() + request.getParameter("nomeImagem");
        String mime = context.getMimeType(pathImagem);
        if (mime == null) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        
        response.setContentType(mime);
        File file = new File(pathImagem);
        response.setContentLength((int) file.length());
        FileInputStream in = new FileInputStream(file);
        OutputStream out = response.getOutputStream();
        
        byte[] buf = new byte[1024];
        int count;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        out.close();
        in.close();
    }
    
    public void getPdf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pdfFilename = request.getParameter("nomePdf");
        File pdfFile = new File(getBasePath() + pdfFilename);
        
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=" + pdfFilename);
        response.setContentLength((int) pdfFile.length());
        
        FileInputStream in = new FileInputStream(pdfFile);
        OutputStream out = response.getOutputStream();
        int bytes;
        while ((bytes = in.read()) != -1) {
            out.write(bytes);
        }
    }
}
