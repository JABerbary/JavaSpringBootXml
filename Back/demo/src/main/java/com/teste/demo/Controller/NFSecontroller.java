package com.teste.demo.Controller;

import java.io.IOException;
import java.util.List;
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

    // @PostMapping(value ="/processarxml",
    // produces = {"application/xml"},
    // consumes = {"application/xml"})
    // public void InserirXML(@RequestBody String xmlContent) {
    // try {
    //     XmlMapper xmlMapper = new XmlMapper();
    //     XMLData xmlData = xmlMapper.readValue(xmlContent, XMLData.class);

    //     xmlData.setXmlContent(xmlContent);
    //     xmlDataService.salvar(xmlData);

    //     DadosNFe dadosNFe = NFSeHelper.extrairDadosNFe(xmlContent);
    //     dadosNFeService.salvar(dadosNFe);
    // } catch (Exception e) {
    //     e.printStackTrace();
    // }
    // }

      @PostMapping(value = "/processarxml",
            produces = {"application/xml"},
            consumes = {"application/xml"})
    public ResponseEntity<Void> InserirXML(@RequestBody String xmlContent) {
        try {
            // Salvar XMLData e obter o ID gerado
            XMLData xmlData = new XMLData();
            xmlData.setXmlContent(xmlContent);
            xmlData = xmlDataService.salvar(xmlData);
            Long xmlDataId = xmlData.getId(); // ID do XMLData

            // Extrair dados da NFSe
            DadosNFe dadosNFe = NFSeHelper.extrairDadosNFe(xmlContent);
            dadosNFe.setId(xmlDataId); 
            dadosNFeService.salvar(dadosNFe);

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

