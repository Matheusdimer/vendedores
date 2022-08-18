package com.serasa.testetecnico.service;

import com.serasa.testetecnico.model.Atuacao;
import com.serasa.testetecnico.repository.AtuacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
@AllArgsConstructor
public class AtuacaoService {
    private AtuacaoRepository repository;

    public Atuacao create(Atuacao atuacao) {
        return repository.save(atuacao);
    }

    public Set<String> getEstadosAtuacao(String regiao) {
        return repository.findByRegiao(regiao).map(Atuacao::getEstados).orElse(Collections.emptySet());
    }
}
