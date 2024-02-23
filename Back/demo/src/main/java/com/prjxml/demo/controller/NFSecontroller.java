package com.prjxml.demo.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import com.prjxml.demo.domain.DadosNFe;
import com.prjxml.demo.domain.XMLData;
import com.prjxml.demo.helpers.NFSeHelper;
import com.prjxml.demo.helpers.XmlFilesRequest;
import com.prjxml.demo.services.DadosNFeService;
import com.prjxml.demo.services.XMLDataService;


@RestController
public class NFSecontroller {

    @Autowired
    private DadosNFeService dadosNFeService;

    @Autowired
    private XMLDataService xmlDataService;


    @PostMapping(value = "/processarxml",  consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Void> inserirXML(@RequestBody XmlFilesRequest xmlFilesRequest,
    @RequestHeader HttpHeaders headers, 
    HttpServletRequest httpRequest) {
        try {
            List<String> xmlFiles = xmlFilesRequest.getXmlFiles();

            for (String xmlContent : xmlFiles) {

                // Salvar XMLData e obter o ID gerado
                XMLData xmlData = new XMLData();
                xmlData.setXmlContent(xmlContent);
                xmlData = xmlDataService.salvar(xmlData);

                // Extrair dados da NFSe
                DadosNFe dadosNFe = NFSeHelper.extrairDadosNFe(xmlContent);
                dadosNFe.setXmlData(xmlData);
                dadosNFeService.salvar(dadosNFe);
            }

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/processarnfse")
    public void processarXML(@RequestBody String xmlContent) throws IOException {
        try {
            DadosNFe dadosNFe = NFSeHelper.extrairDadosNFe(xmlContent);
            dadosNFeService.salvar(dadosNFe);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @GetMapping("/buscarnfse/{id}")
    public DadosNFe buscarDadosNFePorId(@PathVariable Long id) {
        return dadosNFeService.buscarPorId(id).orElse(null);
    }

    @GetMapping("/buscartodosnfse")
    public List<DadosNFe> buscarTodos() {
        return dadosNFeService.buscarTodos();
    }

    @GetMapping(value ="/exibirxml/{id}", 
    produces = {"application/xml"},
    consumes = {"application/xml"})
    public ResponseEntity<XMLData>  buscarXMLDataPorId(@PathVariable Long id) {
        XMLData xmlData = xmlDataService.buscarXMLPorId(id).orElse(null);
        return ResponseEntity.ok(xmlData);
    }

    @GetMapping("/exibirxml")
    public List<XMLData> buscarTodosXMLData() {
        return xmlDataService.buscarTodosXML();
    }

    @DeleteMapping("/deletartodosxml")
    public ResponseEntity<Void> deletarTodosXMLData() {
        try {
            dadosNFeService.excluirTodos(); 
            xmlDataService.deletarTodos(); 
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}




