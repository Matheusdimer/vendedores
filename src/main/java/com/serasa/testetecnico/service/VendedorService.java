package com.serasa.testetecnico.service;

import com.serasa.testetecnico.exception.EntityNotFoundException;
import com.serasa.testetecnico.model.Vendedor;
import com.serasa.testetecnico.model.dto.VendedorView;
import com.serasa.testetecnico.repository.VendedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VendedorService {

    private final VendedorRepository repository;

    public Page<VendedorView> findAll(Pageable pageable) {
        return repository.findAllBy(pageable, VendedorView.class);
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
