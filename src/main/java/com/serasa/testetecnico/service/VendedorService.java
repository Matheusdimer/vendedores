package com.serasa.testetecnico.service;

import com.serasa.testetecnico.exception.EntityNotFoundException;
import com.serasa.testetecnico.model.Vendedor;
import com.serasa.testetecnico.model.dto.VendedorDto;
import com.serasa.testetecnico.repository.VendedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class VendedorService {

    private final VendedorRepository repository;
    private final AtuacaoService atuacaoService;

    public Page<VendedorDto> findAll(Pageable pageable) {
        final Page<VendedorDto> vendedores = repository.findAllBy(pageable, VendedorDto.class);

        vendedores.forEach(vendedor -> {
            Set<String> estados = atuacaoService.getEstadosAtuacao(vendedor.getRegiao());
            vendedor.setEstados(estados);
        });

        return vendedores;
    }

    public Vendedor findById(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Vendedor create(Vendedor vendedor) {
        return repository.save(vendedor);
    }

    public Vendedor update(Vendedor vendedor) {
        if (!exists(vendedor.getId())) {
            throw new EntityNotFoundException(String.format("Vendedor id %d não encontrado", vendedor.getId()));
        }

        return repository.save(vendedor);
    }

    public boolean exists(Integer id) {
        return repository.existsById(id);
    }

    public void remove(Vendedor vendedor) {
        repository.delete(vendedor);
    }
}
