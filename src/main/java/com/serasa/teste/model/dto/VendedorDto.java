package com.serasa.teste.model.dto;

import lombok.Getter;

import java.util.Set;

@Getter
public class VendedorDto {
    private String nome;
    private String telefone;
    private Integer idade;
    private String cidade;
    private String estado;
    private String regiao;
    private Set<String> estados;

    public VendedorDto(final String nome,
                       final String telefone,
                       final Integer idade,
                       final String cidade,
                       final String estado,
                       final String regiao) {
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
        this.regiao = regiao;
    }

    public void setEstados(final Set<String> estados) {
        this.estados = estados;
    }
}
