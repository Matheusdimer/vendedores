package com.serasa.teste.controller;

import com.serasa.teste.model.Vendedor;
import com.serasa.teste.model.dto.VendedorDto;
import com.serasa.teste.service.VendedorService;
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
    public Page<VendedorDto> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDto> findById(@PathVariable int id) {
        return service.findByIdDto(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<Vendedor> create(@RequestBody Vendedor vendedor) {
        Vendedor saved = service.create(vendedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
