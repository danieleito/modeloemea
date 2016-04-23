/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.model.Simulacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniele Harumi Ito
 */
@ManagedBean(name = "simulacao")
@SessionScoped
public class SimulacaoBean extends ComumBean {
    
    private Simulacao novaSimulacao;
    
    public SimulacaoBean() {
        novaSimulacao = new Simulacao();
        novaSimulacao.setUsuario(usuarioLogado);
    }
}
