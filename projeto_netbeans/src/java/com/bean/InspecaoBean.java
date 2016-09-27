/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.model.InspecaoManifestacaoElemento;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Daniele Harumi Ito
 */
@ManagedBean(name="inspecaoBean")
@ViewScoped
public class InspecaoBean implements Serializable {
    private ArrayList<InspecaoManifestacaoElemento> inspecaoManifestacaoElementos;
    private InspecaoManifestacaoElemento selectInspecaoManifestacaoElemento;
     
//    @ManagedProperty("#{carService}")
//    private CarService service;
     
    @PostConstruct
    public void init() {
//        inspecaoManifestacaoElementos = service.createCars(48);
    }

    // <editor-fold defaultstate="collapsed" desc=" Métodos getter e setter. ">
    public ArrayList<InspecaoManifestacaoElemento> getInspecaoManifestacaoElementos() {
        return inspecaoManifestacaoElementos;
    }

    public void setInspecaoManifestacaoElementos(ArrayList<InspecaoManifestacaoElemento> inspecaoManifestacaoElementos) {
        this.inspecaoManifestacaoElementos = inspecaoManifestacaoElementos;
    }

    public InspecaoManifestacaoElemento getSelectInspecaoManifestacaoElemento() {
        return selectInspecaoManifestacaoElemento;
    }

    public void setSelectInspecaoManifestacaoElemento(InspecaoManifestacaoElemento selectInspecaoManifestacaoElemento) {
        this.selectInspecaoManifestacaoElemento = selectInspecaoManifestacaoElemento;
    }
    // </editor-fold>
}
