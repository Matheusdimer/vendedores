package com.serasa.testetecnico.service;

import com.serasa.testetecnico.model.Atuacao;
import com.serasa.testetecnico.model.Vendedor;
import com.serasa.testetecnico.repository.AtuacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtuacaoService {
    private AtuacaoRepository repository;
    private VendedorService vendedorService;

    public Atuacao create(Integer idVendedor, Atuacao atuacao) {
        Vendedor vendedor = vendedorService.findById(idVendedor);
        atuacao = repository.save(atuacao.toBuilder()
                .vendedor(vendedor)
                .build());

        vendedor.setAtuacao(atuacao);
        vendedorService.update(vendedor);
        return atuacao;
    }
}
