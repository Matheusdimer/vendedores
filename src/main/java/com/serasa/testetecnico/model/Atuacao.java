package com.serasa.testetecnico.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ATUACOES")
public class Atuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference
    @OneToOne(mappedBy = "atuacao", cascade = CascadeType.ALL)
    private Vendedor vendedor;

    @Column
    private String regiao;

    @ElementCollection
    @CollectionTable(name = "ATUACOES_ESTADOS")
    private Set<String> estados = new HashSet<>();
}
