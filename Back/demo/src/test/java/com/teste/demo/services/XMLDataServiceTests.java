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

import com.prjxml.demo.domain.XMLData;
import com.prjxml.demo.repository.XMLDataRepository;
import com.prjxml.demo.services.XMLDataService;

public class XMLDataServiceTests {

    @Mock
    private XMLDataRepository repository;

    @InjectMocks
    private XMLDataService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSalvar() {
        XMLData xmlData = new XMLData(); // Criando um objeto de exemplo para simular a entrada
        xmlData.setId(1L);
        when(repository.save(any(XMLData.class))).thenReturn(xmlData);

        XMLData savedXmlData = service.salvar(new XMLData());

        assertEquals(xmlData, savedXmlData);
    }

    @Test
    public void testBuscarPorId() {
        // Criando um objeto de exemplo para simular o retorno do repositório
        XMLData xmlData = new XMLData(); 
        xmlData.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(xmlData));

        Optional<XMLData> foundXmlData = service.buscarXMLPorId(1L);

        assertEquals(Optional.of(xmlData), foundXmlData);
    }

    @Test
    public void testBuscarTodos() {
        List<XMLData> xmlDataList = new ArrayList<>();
        XMLData xmlData = new XMLData(); 
        xmlData.setId(1L);
        xmlDataList.add(xmlData);
        when(repository.findAll()).thenReturn(xmlDataList);

        List<XMLData> foundXmlDataList = service.buscarTodosXML();

        assertEquals(xmlDataList, foundXmlDataList);
    }
}