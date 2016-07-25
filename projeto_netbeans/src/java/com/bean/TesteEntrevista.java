/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

/**
 *
 * @author Daniele Harumi Ito
 */
public class TesteEntrevista {
    public int vetor[];
    
    public int metodo() {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 != 0) {
                soma += vetor[i];
            }
        }
        return soma;
    }
}
