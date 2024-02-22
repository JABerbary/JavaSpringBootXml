package com.teste.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.prjxml.demo.domain.DadosNFe;
import com.prjxml.demo.repository.DadosNFeRepository;
import com.prjxml.demo.services.DadosNFeService;

public class DadosNFeServiceTests {

    @Mock
    private DadosNFeRepository repository;

    @InjectMocks
    private DadosNFeService service;

    private DadosNFe dadosNFe;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        dadosNFe = new DadosNFe();
        dadosNFe.setId(1L);
     
    }

    @Test
    public void testSalvar() {
        when(repository.save(any(DadosNFe.class))).thenReturn(dadosNFe);

        DadosNFe savedDadosNFe = service.salvar(new DadosNFe());

        assertEquals(dadosNFe, savedDadosNFe);
    }

    @Test
    public void testBuscarPorId() {
        when(repository.findById(1L)).thenReturn(Optional.of(dadosNFe));

        Optional<DadosNFe> foundDadosNFe = service.buscarPorId(1L);

        assertEquals(Optional.of(dadosNFe), foundDadosNFe);
    }

    @Test
    public void testBuscarTodos() {
        List<DadosNFe> dadosNFeList = new ArrayList<>();
        dadosNFeList.add(dadosNFe);
        when(repository.findAll()).thenReturn(dadosNFeList);

        List<DadosNFe> foundDadosNFeList = service.buscarTodos();

        assertEquals(dadosNFeList, foundDadosNFeList);
    }

    @Test
    public void testBuscarOrder() {
        List<DadosNFe> dadosNFeList = new ArrayList<>();
        dadosNFeList.add(dadosNFe);
        // Add more DadosNFe if necessary
        when(repository.findAllByOrderByCreatedAtAsc()).thenReturn(dadosNFeList);

        List<DadosNFe> foundDadosNFeList = service.buscarorder();

        assertEquals(dadosNFeList, foundDadosNFeList);
    }
}
