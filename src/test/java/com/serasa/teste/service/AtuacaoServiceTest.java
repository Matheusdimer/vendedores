package com.serasa.teste.service;

import com.serasa.teste.model.Atuacao;
import com.serasa.teste.repository.AtuacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AtuacaoServiceTest {

    @Autowired
    private AtuacaoService service;

    @MockBean
    private AtuacaoRepository repository;

    private Atuacao atuacao;

    @BeforeEach
    public void setup() {
        atuacao = createAtuacao();

        when(repository.save(any(Atuacao.class))).thenReturn(atuacao);
    }

    @Test
    public void deveCriarAtuacao() {
        Atuacao saved = service.create(atuacao);

        assertNotNull(saved);

        verify(repository).save(any(Atuacao.class));
    }

    private Atuacao createAtuacao() {
        return Atuacao.builder()
                .regiao("sul")
                .estados(Sets.newSet("SC", "PR"))
                .build();
    }
}
