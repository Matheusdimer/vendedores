package com.serasa.testetecnico.repository;

import com.serasa.testetecnico.model.Atuacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtuacaoRepository extends JpaRepository<Atuacao, Integer> {
    <T> Page<T> findAllBy(Pageable pageable, Class<T> projection);
}