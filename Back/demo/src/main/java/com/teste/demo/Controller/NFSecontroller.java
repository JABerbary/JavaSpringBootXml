package com.teste.demo.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.teste.demo.Services.XMLDataService;
import org.springframework.web.bind.annotation.*;
import com.teste.demo.Entities.DadosNFe;
import com.teste.demo.Entities.XMLData;
import com.teste.demo.Helpers.NFSeHelper;
import com.teste.demo.Services.DadosNFeService;


@RestController
public class NFSecontroller {

    @Autowired
    private DadosNFeService dadosNFeService;

    @Autowired
    private XMLDataService xmlDataService;

    @PostMapping("/processarnfse")
    public void processarXML(@RequestBody String xmlContent) throws IOException {
        try {
            DadosNFe dadosNFe = NFSeHelper.extrairDadosNFe(xmlContent);
            dadosNFeService.salvar(dadosNFe);
            
        } catch (Exception e) {
            // Trate exceções de parsing aqui
            e.printStackTrace();
        }
    }
   
    @GetMapping("/buscarnfse/{id}")
    public DadosNFe buscarDadosNFePorId(@PathVariable Long id) {
        return dadosNFeService.buscarPorId(id).orElse(null);
    }

    @GetMapping("/buscartodosnfse")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<DadosNFe> buscarTodos() {
        return dadosNFeService.buscarTodos();
    }

    @PostMapping("/processarxml")
    public void InserirXML(@RequestBody byte[] entity) {
       try {
        XMLData xmlData = new XMLData();
        xmlData.setXmlContent(entity);
        xmlDataService.salvar(xmlData);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    @GetMapping("/exibirxml/{id}")
    public XMLData buscarXMLDataPorId(@PathVariable Long id) {
        return xmlDataService.buscarXMLPorId(id).orElse(null);
    }

    @GetMapping("/exibirxml")
    public List<XMLData> buscarTodosXMLData() {
        return xmlDataService.buscarTodosXML();
    }
}

