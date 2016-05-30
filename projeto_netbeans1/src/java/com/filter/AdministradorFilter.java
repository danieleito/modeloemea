/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filter;

import com.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniele Harumi Ito
 */
public class AdministradorFilter implements Filter {
    
    private ArrayList urlList;

    @Override
    public void init(FilterConfig config) throws ServletException {
        // Read the URLs to be avoided for authentication check (From web.xml)
        String urls = config.getInitParameter("avoid-urls");
        StringTokenizer token = new StringTokenizer(urls, ",");
        urlList = new ArrayList();
        while (token.hasMoreTokens()) {
          urlList.add(token.nextToken());
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        String url = request.getServletPath(); //url que está tentando entrar
        boolean allowedRequest = false;
        String strURL = "";
        
        // To check if the url can be excluded or not
        for (int i = 0; i < urlList.size(); i++) {
            strURL = urlList.get(i).toString();
            if (url.startsWith(strURL)) {
                allowedRequest = true;
            }
        }
        
        if (!allowedRequest) {
            Usuario user = null; 
            HttpSession sess = ((HttpServletRequest) request).getSession(false); 
            if (sess != null){ 
                user = (Usuario) sess.getAttribute("usuarioLogado"); 
            } 

            if (user == null || user.getTipoUsuario().getId() != 1) {
                String contextPath = ((HttpServletRequest) request).getContextPath();
                ((HttpServletResponse) response).sendRedirect(contextPath + "/View/Compartilhado/erroAdministrador.jsf");
                return;
            }
        }
        chain.doFilter(req, res);        
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
