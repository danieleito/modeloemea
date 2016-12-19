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
    /**
     * elemento
     */
    private String elemento;
    /**
     * nota
     */
    private String nota;
    /**
     * insuficiência
     */
    private String insuficiencia;
    /**
     * causa provável
     */
    private String causaProvavel;
    /**
     * comentários sobre insuficiências estruturais elementos
     */
    private String comentarios;


    /**
     * Constructor padrão.
     */
    public InsuficienciaEstruturalElementoSgo() {
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param elemento {@link #elemento}
     * @param nota {@link #nota}
     * @param insuficiencia {@link #insuficiencia}
     * @param causaProvavel {@link #causaProvavel}
     * @param comentarios {@link #comentarios}
     */
    public InsuficienciaEstruturalElementoSgo(int id, String elemento, String nota, String insuficiencia, String causaProvavel, String comentarios) {
        this.id = id;
        this.elemento = elemento;
        this.nota = nota;
        this.insuficiencia = insuficiencia;
        this.causaProvavel = causaProvavel;
        this.comentarios = comentarios;
    }

    /**
     * Constructor sem id
     * @param elemento {@link #elemento}
     * @param nota {@link #nota}
     * @param insuficiencia {@link #insuficiencia}
     * @param causaProvavel {@link #causaProvavel}
     * @param comentarios {@link #comentarios}
     */
    public InsuficienciaEstruturalElementoSgo(String elemento, String nota, String insuficiencia, String causaProvavel, String comentarios) {
        this.elemento = elemento;
        this.nota = nota;
        this.insuficiencia = insuficiencia;
        this.causaProvavel = causaProvavel;
        this.comentarios = comentarios;
    }


    /**
     * retorna {@link #id}
     * @return {@link #id}
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * retorna {@link #elemento}
     * @return {@link #elemento}
     */
    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    /**
     * retorna {@link #nota}
     * @return {@link #nota}
     */
    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    /**
     * retorna {@link #insuficiencia}
     * @return {@link #insuficiencia}
     */
    public String getInsuficiencia() {
        return insuficiencia;
    }

    public void setInsuficiencia(String insuficiencia) {
        this.insuficiencia = insuficiencia;
    }

    /**
     * retorna {@link #causaProvavel}
     * @return {@link #causaProvavel}
     */
    public String getCausaProvavel() {
        return causaProvavel;
    }

    public void setCausaProvavel(String causaProvavel) {
        this.causaProvavel = causaProvavel;
    }

    /**
     * retorna {@link #comentarios}
     * @return {@link #comentarios}
     */
    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
