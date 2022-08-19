package com.serasa.teste.service;

import com.serasa.teste.exception.EntityNotFoundException;
import com.serasa.teste.model.Vendedor;
import com.serasa.teste.model.dto.VendedorDto;
import com.serasa.teste.model.dto.VendedorSimplificadoDto;
import com.serasa.teste.repository.VendedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class VendedorService {

    private final VendedorRepository repository;
    private final AtuacaoService atuacaoService;

    public Page<VendedorDto> findAll(Pageable pageable) {
        Page<VendedorDto> vendedores = repository.findAllBy(pageable, VendedorDto.class);

        vendedores.forEach(this::associarEstados);
        return vendedores;
    }

    public Optional<VendedorSimplificadoDto> findById(Integer id) {
        Optional<Vendedor> vendedorDto = repository.findById(id);
        return vendedorDto.map(vendedor -> new VendedorSimplificadoDto(
                vendedor,
                atuacaoService.getEstadosAtuacao(vendedor.getRegiao())
        ));
    }

    private void associarEstados(VendedorDto vendedor) {
        Set<String> estados = atuacaoService.getEstadosAtuacao(vendedor.getRegiao());
        vendedor.setEstados(estados);
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
