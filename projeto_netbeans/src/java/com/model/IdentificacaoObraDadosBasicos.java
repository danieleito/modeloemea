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
public class IdentificacaoObraDadosBasicos implements Serializable {
    /**
     * identificador do IdentificacaoObraDadosBasicos no Banco de Dados
     */
    private int id;
    /**
     * código da identidicação da obra dados básicos
     */
    private String codigo;
    /**
     * código da identidicação da obra dados básicos
     */
    private String codigoIntegracao;
    /**
     * status
     */
    private String status;
    /**
     * nome da ponte
     */
    private String identificacao;
    /**
     * identificador da natureza tranposição
     */
    private NaturezaTransposicao naturezaTransposicao;
    /**
     * identificador do tipo estrutura
     */
    private TipoEstrutura tipoEstrutura;
    /**
     * identificador do sistema construtivo
     */
    private SistemaConstrutivo sistemaConstrutivo;
    /**
     * comprimento da ponte
     */
    private String comprimento;
    /**
     * largura da ponte
     */
    private String largura;
    /**
     * identificadot do trem-tipo
     */
    private TremTipo tremTipo;
    /**
     * ano da construção da ponte
     */
    private String anoConstrucao;


    /**
     * Constructor padrão.
     */
    public IdentificacaoObraDadosBasicos() {
        naturezaTransposicao = new NaturezaTransposicao();
    }

    /**
     * Constructor completo
     * @param id {@link #id}
     * @param codigo {@link #codigo}
     * @param codigoIntegracao {@link #codigoIntegracao}
     * @param status {@link #status}
     * @param identificacao {@link #identificacao}
     * @param naturezaTransposicao {@link #naturezaTransposicao}
     * @param tipoEstrutura {@link #tipoEstrutura}
     * @param sistemaConstrutivo {@link #sistemaConstrutivo}
     * @param comprimento {@link #comprimento}
     * @param largura {@link #largura}
     * @param tremTipo {@link #tremTipo}
     * @param anoConstrucao {@link #anoConstrucao}
     */
    public IdentificacaoObraDadosBasicos(int id, String codigo, String codigoIntegracao, String status, String identificacao, NaturezaTransposicao naturezaTransposicao, TipoEstrutura tipoEstrutura, SistemaConstrutivo sistemaConstrutivo, String comprimento, String largura, TremTipo tremTipo, String anoConstrucao) {
        this.id = id;
        this.codigo = codigo;
        this.codigoIntegracao = codigoIntegracao;
        this.status = status;
        this.identificacao = identificacao;
        this.naturezaTransposicao = naturezaTransposicao;
        this.tipoEstrutura = tipoEstrutura;
        this.sistemaConstrutivo = sistemaConstrutivo;
        this.comprimento = comprimento;
        this.largura = largura;
        this.tremTipo = tremTipo;
        this.anoConstrucao = anoConstrucao;
    }

    /**
     * Constructor sem id
     * @param codigo {@link #codigo}
     * @param codigoIntegracao {@link #codigoIntegracao}
     * @param status {@link #status}
     * @param identificacao {@link #identificacao}
     * @param naturezaTransposicao {@link #naturezaTransposicao}
     * @param tipoEstrutura {@link #tipoEstrutura}
     * @param sistemaConstrutivo {@link #sistemaConstrutivo}
     * @param comprimento {@link #comprimento}
     * @param largura {@link #largura}
     * @param tremTipo {@link #tremTipo}
     * @param anoConstrucao {@link #anoConstrucao}
     */
    public IdentificacaoObraDadosBasicos(String codigo, String codigoIntegracao, String status, String identificacao, NaturezaTransposicao naturezaTransposicao, TipoEstrutura tipoEstrutura, SistemaConstrutivo sistemaConstrutivo, String comprimento, String largura, TremTipo tremTipo, String anoConstrucao) {
        this.codigo = codigo;
        this.codigoIntegracao = codigoIntegracao;
        this.status = status;
        this.identificacao = identificacao;
        this.naturezaTransposicao = naturezaTransposicao;
        this.tipoEstrutura = tipoEstrutura;
        this.sistemaConstrutivo = sistemaConstrutivo;
        this.comprimento = comprimento;
        this.largura = largura;
        this.tremTipo = tremTipo;
        this.anoConstrucao = anoConstrucao;
    }

    /**
     * Constructor para inspecao rotineira
     * @param id {@link #id}
     * @param codigo {@link #codigo}
     * @param identificacao {@link #identificacao}
     */
    public IdentificacaoObraDadosBasicos(int id, String codigo, String identificacao) {
        this.id = id;
        this.codigo = codigo;
        this.identificacao = identificacao;
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
     * retorna {@link #descricao}
     * @return {@link #descricao}
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * retorna {@link #codigoIntegracao}
     * @return {@link #codigoIntegracao}
     */
    public String getCodigoIntegracao() {
        return codigoIntegracao;
    }

    public void setCodigoIntegracao(String codigoIntegracao) {
        this.codigoIntegracao = codigoIntegracao;
    }

    /**
     * retorna {@link #status}
     * @return {@link #status}
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * retorna {@link #identificacao}
     * @return {@link #identificacao}
     */
    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    /**
     * retorna {@link #naturezaTransposicao}
     * @return {@link #naturezaTransposicao}
     */
    public NaturezaTransposicao getNaturezaTransposicao() {
        return naturezaTransposicao;
    }

    public void setNaturezaTransposicao(NaturezaTransposicao naturezaTransposicao) {
        this.naturezaTransposicao = naturezaTransposicao;
    }

    /**
     * retorna {@link #tipoEstrutura}
     * @return {@link #tipoEstrutura}
     */
    public TipoEstrutura getTipoEstrutura() {
        return tipoEstrutura;
    }

    public void setTipoEstrutura(TipoEstrutura tipoEstrutura) {
        this.tipoEstrutura = tipoEstrutura;
    }

    /**
     * retorna {@link #sistemaConstrutivo}
     * @return {@link #sistemaConstrutivo}
     */
    public SistemaConstrutivo getSistemaConstrutivo() {
        return sistemaConstrutivo;
    }

    public void setSistemaConstrutivo(SistemaConstrutivo sistemaConstrutivo) {
        this.sistemaConstrutivo = sistemaConstrutivo;
    }

    /**
     * retorna {@link #comprimento}
     * @return {@link #comprimento}
     */
    public String getComprimento() {
        return comprimento;
    }

    public void setComprimento(String comprimento) {
        this.comprimento = comprimento;
    }

    /**
     * retorna {@link #largura}
     * @return {@link #largura}
     */
    public String getLargura() {
        return largura;
    }

    /**
     * 
     * @param largura 
     */
    public void setLargura(String largura) {
        this.largura = largura;
    }

    /**
     * retorna {@link #tremTipo}
     * @return {@link #tremTipo}
     */
    public TremTipo getTremTipo() {
        return tremTipo;
    }

    public void setTremTipo(TremTipo tremTipo) {
        this.tremTipo = tremTipo;
    }

    /**
     * retorna {@link #anoConstrucao}
     * @return {@link #anoConstrucao}
     */
    public String getAnoConstrucao() {
        return anoConstrucao;
    }

    public void setAnoConstrucao(String anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }
}
