package com.serasa.testetecnico.controller;

import com.serasa.testetecnico.model.Vendedor;
import com.serasa.testetecnico.service.VendedorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/vendedores")
public class VendedorController {

    private final VendedorService service;

    @GetMapping
    public Page<Vendedor> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<Vendedor> create(@RequestBody Vendedor vendedor) {
        Vendedor saved = service.create(vendedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
