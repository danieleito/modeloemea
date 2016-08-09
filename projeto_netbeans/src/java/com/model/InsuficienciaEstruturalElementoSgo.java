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
public class InsuficienciaEstruturalElementoSgo implements Serializable {
    /**
     * identificador do InsuficienciaEstruturalElementoSgo no Banco de Dados
     */
    private int id;
    private InspecaoRotineira inspecaoRotineira;
    private String elemento;
    private String nota;
    private String insuficiencia;
    private String causaProvavel;
    private String comentarios;

    public InsuficienciaEstruturalElementoSgo() {
    }

    public InsuficienciaEstruturalElementoSgo(int id, InspecaoRotineira inspecaoRotineira, String elemento, String nota, String insuficiencia, String causaProvavel, String comentarios) {
        this.id = id;
        this.inspecaoRotineira = inspecaoRotineira;
        this.elemento = elemento;
        this.nota = nota;
        this.insuficiencia = insuficiencia;
        this.causaProvavel = causaProvavel;
        this.comentarios = comentarios;
    }

    public InsuficienciaEstruturalElementoSgo(InspecaoRotineira inspecaoRotineira, String elemento, String nota, String insuficiencia, String causaProvavel, String comentarios) {
        this.inspecaoRotineira = inspecaoRotineira;
        this.elemento = elemento;
        this.nota = nota;
        this.insuficiencia = insuficiencia;
        this.causaProvavel = causaProvavel;
        this.comentarios = comentarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InspecaoRotineira getInspecaoRotineira() {
        return inspecaoRotineira;
    }

    public void setInspecaoRotineira(InspecaoRotineira inspecaoRotineira) {
        this.inspecaoRotineira = inspecaoRotineira;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getInsuficiencia() {
        return insuficiencia;
    }

    public void setInsuficiencia(String insuficiencia) {
        this.insuficiencia = insuficiencia;
    }

    public String getCausaProvavel() {
        return causaProvavel;
    }

    public void setCausaProvavel(String causaProvavel) {
        this.causaProvavel = causaProvavel;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
