package com.serasa.testetecnico.service;

import com.serasa.testetecnico.exception.EntityNotFoundException;
import com.serasa.testetecnico.model.Vendedor;
import com.serasa.testetecnico.model.dto.VendedorView;
import com.serasa.testetecnico.repository.VendedorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class VendedorServiceTest {

    @Autowired
    private VendedorService service;

    @MockBean
    private VendedorRepository repository;

    private Vendedor vendedor;

    @BeforeEach
    public void setup() {
        vendedor = criarVendedor();

        when(repository.save(any(Vendedor.class))).thenReturn(vendedor);
        when(repository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(Collections.singletonList(vendedor)));
        when(repository.findById(anyInt())).thenReturn(Optional.of(vendedor));
    }

    @Test
    public void deveBuscarVendedores() {
        Pageable pageable = PageRequest.of(0, 20);
        Page<VendedorView> vendedores = service.findAll(pageable);

        assertFalse(vendedores.isEmpty());
        assertEquals(1, vendedores.getSize());
        assertTrue(vendedores.getContent().stream().findFirst().isPresent());

        verify(repository).findAll(eq(pageable));
    }

    @Test
    public void deveCriarVendedor() {
        Vendedor vendedor = service.create(this.vendedor);

        assertNotNull(vendedor);

        verify(repository).save(eq(this.vendedor));
    }

    @Test
    public void deveBuscarVendedor() {
        Vendedor vendedor = service.findById(1);

        assertNotNull(vendedor);

        verify(repository).findById(eq(1));
    }

    @Test
    public void deveAtualizar() {
        when(repository.existsById(anyInt())).thenReturn(true);

        Vendedor update = service.update(vendedor);

        assertNotNull(update);

        verify(repository).existsById(eq(vendedor.getId()));
        verify(repository).save(eq(vendedor));
    }

    @Test
    public void deveLancarExceptioAtualizar() {
        when(repository.existsById(anyInt())).thenReturn(false);

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> service.update(vendedor));

        assertEquals("Vendedor id 5 não encontrado", exception.getMessage());
    }

    @Test
    public void deveExcluir() {
        service.remove(vendedor);

        verify(repository).delete(eq(vendedor));
    }

    private Vendedor criarVendedor() {
        return Vendedor.builder()
                .id(5)
                .nome("Fulano")
                .idade(18)
                .telefone("48988888888")
                .regiao("sul")
                .estado("SC")
                .build();
    }

}
