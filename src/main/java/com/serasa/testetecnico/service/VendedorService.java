package com.serasa.testetecnico.service;

import com.serasa.testetecnico.exception.EntityNotFoundException;
import com.serasa.testetecnico.model.Vendedor;
import com.serasa.testetecnico.repository.VendedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VendedorService {

    private final VendedorRepository repository;

    public Page<Vendedor> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Vendedor findById(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Vendedor create(Vendedor vendedor) {
        return repository.save(vendedor);
    }

    public void remove(Vendedor vendedor) {
        repository.delete(vendedor);
    }
}
