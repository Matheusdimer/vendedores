package com.serasa.testetecnico.service;

import com.serasa.testetecnico.model.Atuacao;
import com.serasa.testetecnico.model.Vendedor;
import com.serasa.testetecnico.repository.AtuacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.internal.util.collections.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AtuacaoServiceTest {

    @Autowired
    private AtuacaoService service;

    @MockBean
    private AtuacaoRepository repository;

    @MockBean
    private VendedorService vendedorService;

    @Mock
    private Vendedor vendedor;

    private Atuacao atuacao;

    @BeforeEach
    public void setup() {
        atuacao = createAtuacao();

        when(vendedorService.findById(anyInt())).thenReturn(vendedor);
        when(repository.save(any(Atuacao.class))).thenReturn(atuacao);
    }

    @Test
    public void deveCriarAtuacao() {
        int idVendedor = 1;

        final Atuacao saved = service.create(idVendedor, atuacao);

        assertNotNull(saved);

        verify(vendedorService).findById(eq(idVendedor));
        verify(repository).save(any(Atuacao.class));
        verify(vendedor).setAtuacao(any(Atuacao.class));
        verify(vendedorService).update(vendedor);
    }

    private Atuacao createAtuacao() {
        return Atuacao.builder()
                .regiao("sul")
                .estados(Sets.newSet("SC", "PR"))
                .build();
    }
}
