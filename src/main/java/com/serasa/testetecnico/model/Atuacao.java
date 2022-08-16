package com.serasa.testetecnico.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ATUACOES")
public class Atuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String regiao;

    @ElementCollection
    @CollectionTable(name = "ATUACOES_ESTADOS")
    private Set<String> estados = new HashSet<>();
}