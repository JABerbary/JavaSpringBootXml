package com.teste.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.prjxml.demo.controller.NFSecontroller;
import com.prjxml.demo.domain.DadosNFe;
import com.prjxml.demo.domain.XMLData;
import com.prjxml.demo.helpers.NFSeHelper;
import com.prjxml.demo.helpers.XmlFilesRequest;
import com.prjxml.demo.services.DadosNFeService;
import com.prjxml.demo.services.XMLDataService;

public class NFSeControllerTest {

    @Mock
    private DadosNFeService dadosNFeService;

    @Mock
    private XMLDataService xmlDataService;

    @InjectMocks
    private NFSecontroller nfseController;

    private HttpHeaders headers;
    private XmlFilesRequest xmlFilesRequest;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInserirXML() {
        // Mocking input data
        List<String> xmlFiles = new ArrayList<>();
        xmlFiles.add("<xml>...</xml>");
        XmlFilesRequest xmlFilesRequest = new XmlFilesRequest();
        xmlFilesRequest.setXmlFiles(xmlFiles);

        // Mocking behavior of xmlDataService.salvar()
        XMLData xmlData = new XMLData();
        when(xmlDataService.salvar(any(XMLData.class))).thenReturn(xmlData);

        try {
            // Mocking behavior of NFSeHelper.extrairDadosNFe()
            DadosNFe dadosNFe = new DadosNFe();
            when(NFSeHelper.extrairDadosNFe(anyString())).thenReturn(dadosNFe);

            // Call the method being tested
            ResponseEntity<Void> responseEntity = nfseController.inserirXML(xmlFilesRequest, headers, null);

            // Verify that the method returns HTTP 200 OK
            assertEquals(200, responseEntity.getStatusCodeValue());

            // Verify that xmlDataService.salvar() is called for each XML file
            verify(xmlDataService, times(xmlFiles.size())).salvar(any(XMLData.class));

            // Verify that dadosNFeService.salvar() is called for each XML file
            verify(dadosNFeService, times(xmlFiles.size())).salvar(any(DadosNFe.class));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testProcessarXML() {
        // Preparação dos dados de teste
        String xmlContent = "<xml>";

        // Mock do comportamento do serviço
        doReturn(new DadosNFe()).when(dadosNFeService).salvar(any(DadosNFe.class));

        // Teste da controladora
        try {
            nfseController.processarXML(xmlContent);
        } catch (IOException e) {
            // Lidar com a exceção IOException aqui
            e.printStackTrace(); // ou faça qualquer outra coisa, como registrar a exceção
        }


    }

    @Test
public void testDeletarTodosXMLData() {
    doNothing().when(dadosNFeService).excluirTodos();
    doNothing().when(xmlDataService).deletarTodos();

    ResponseEntity<Void> responseEntity = nfseController.deletarTodosXMLData();

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    verify(dadosNFeService, times(1)).excluirTodos();

    verify(xmlDataService, times(1)).deletarTodos();
}
}
