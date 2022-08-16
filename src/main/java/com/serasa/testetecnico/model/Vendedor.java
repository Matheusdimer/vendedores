package com.serasa.testetecnico.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VENDEDORES")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String telefone;

    @Column
    private LocalDate dataNascimento;

    @Column
    private String cidade;

    @Column
    private String estado;

    @Column
    private String regiao;

    @Builder.Default
    private LocalDateTime criadoEm = LocalDateTime.now();
}
