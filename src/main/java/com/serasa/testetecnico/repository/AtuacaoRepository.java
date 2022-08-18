package com.serasa.testetecnico.repository;

import com.serasa.testetecnico.model.Atuacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtuacaoRepository extends JpaRepository<Atuacao, Integer> {
    Optional<Atuacao> findByRegiao(String regiao);
}