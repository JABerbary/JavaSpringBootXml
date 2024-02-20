package com.teste.demo.Controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.teste.demo.Services.XMLDataService;
import org.springframework.web.bind.annotation.*;
import com.teste.demo.Entities.DadosNFe;
import com.teste.demo.Entities.XMLData;
import com.teste.demo.Helpers.NFSeHelper;
import com.teste.demo.Services.DadosNFeService;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


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

    @PostMapping(value ="/processarxml",
    produces = {"application/xml"},
    consumes = {"application/xml"})
    public void InserirXML(@RequestBody String xmlString) {
    try {
        // byte[] xmlBytes = xmlString.getBytes(StandardCharsets.UTF_8);
        XmlMapper xmlMapper = new XmlMapper();
        XMLData xmlData = xmlMapper.readValue(xmlString, XMLData.class);
        xmlData.setXmlContent(xmlString);
        xmlDataService.salvar(xmlData);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    @GetMapping(value ="/exibirxml/{id}", 
    produces = {"application/xml"},
    consumes = {"application/xml"})
    public ResponseEntity<XMLData>  buscarXMLDataPorId(@PathVariable Long id) {
        XMLData xmlData = xmlDataService.buscarXMLPorId(id).orElse(null);
        if (xmlData != null) {
            String xmlContent = NFSeHelper.decodeXmlEntities(xmlData.getXmlContent());
            xmlData.setXmlContent(xmlContent);
        }
        return ResponseEntity.ok(xmlData);
    }

    @GetMapping("/exibirxml")
    public List<XMLData> buscarTodosXMLData() {
        return xmlDataService.buscarTodosXML();
    }
}

