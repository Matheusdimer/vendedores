package com.serasa.testetecnico.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @Column
    private String nome;

    @Column
    private String telefone;

    @Column
    private Integer idade;

    @Column
    private String cidade;

    @Column
    private String estado;

    @Column
    private String regiao;

    @Builder.Default
    private LocalDateTime dataInclusao = LocalDateTime.now();

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ATUACAO_ID")
    private Atuacao atuacao;

    public void setAtuacao(final Atuacao atuacao) {
        this.atuacao = atuacao;
    }
}
