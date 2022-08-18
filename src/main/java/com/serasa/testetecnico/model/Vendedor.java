package com.serasa.testetecnico.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VENDEDORES")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String nome;

    @Column
    private String telefone;

    @NotNull
    @Column
    private Integer idade;

    @NotNull
    @Column(nullable = false)
    private String cidade;

    @NotNull
    @Column(nullable = false)
    private String estado;

    @NotNull
    @Column(nullable = false)
    private String regiao;

    @Builder.Default
    @Column(nullable = false)
    private LocalDateTime dataInclusao = LocalDateTime.now();
}
