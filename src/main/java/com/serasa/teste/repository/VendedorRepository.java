package com.serasa.teste.repository;

import com.serasa.teste.model.Vendedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

    <T> Optional<T> findById(Integer id, Class<T> projection);

    <T> Page<T> findAllBy(Pageable pageable, Class<T> projection);
}