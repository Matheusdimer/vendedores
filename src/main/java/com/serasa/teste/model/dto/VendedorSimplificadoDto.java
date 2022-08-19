package com.serasa.teste.model.dto;

import com.serasa.teste.model.Vendedor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
public class VendedorSimplificadoDto {
    private final String nome;
    private final LocalDateTime dataInclusao;
    private final Set<String> estados;

    public VendedorSimplificadoDto(final Vendedor vendedor, final Set<String> estados) {
        this.nome = vendedor.getNome();
        this.dataInclusao = vendedor.getDataInclusao();
        this.estados = estados;
    }
}
