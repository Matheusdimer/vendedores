package com.serasa.testetecnico.repository;

import com.serasa.testetecnico.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
}