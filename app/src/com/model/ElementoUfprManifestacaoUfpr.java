/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;

/**
 *
 * @author Daniele Harumi Ito
 */
public class ElementoUfprManifestacaoUfpr implements Serializable {
    private int id;
    private ElementoUfpr elementoUfpr;
    private ManifestacaoUfpr manifestacaoUfpr;

    public ElementoUfprManifestacaoUfpr() {
    }

    public ElementoUfprManifestacaoUfpr(int id, ElementoUfpr elementoUfpr, ManifestacaoUfpr manifestacaoUfpr) {
        this.id = id;
        this.elementoUfpr = elementoUfpr;
        this.manifestacaoUfpr = manifestacaoUfpr;
    }

    public ElementoUfprManifestacaoUfpr(ElementoUfpr elementoUfpr, ManifestacaoUfpr manifestacaoUfpr) {
        this.elementoUfpr = elementoUfpr;
        this.manifestacaoUfpr = manifestacaoUfpr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElementoUfpr getElementoUfpr() {
        return elementoUfpr;
    }

    public void setElementoUfpr(ElementoUfpr elementoUfpr) {
        this.elementoUfpr = elementoUfpr;
    }

    public ManifestacaoUfpr getManifestacaoUfpr() {
        return manifestacaoUfpr;
    }

    public void setManifestacaoUfpr(ManifestacaoUfpr manifestacaoUfpr) {
        this.manifestacaoUfpr = manifestacaoUfpr;
    }
}
