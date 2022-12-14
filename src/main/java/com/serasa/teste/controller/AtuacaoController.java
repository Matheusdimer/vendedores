package com.serasa.teste.controller;

import com.serasa.teste.model.Atuacao;
import com.serasa.teste.service.AtuacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/atuacoes")
public class AtuacaoController {
    private AtuacaoService service;

    @PostMapping
    public ResponseEntity<Atuacao> create(@RequestBody Atuacao atuacao) {
        Atuacao saved = service.create(atuacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
