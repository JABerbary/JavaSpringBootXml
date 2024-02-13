package com.teste.demo.Controller;

import java.io.IOException;
import java.util.List;
// import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import com.teste.demo.Entities.DadosNFe;
// import com.teste.demo.Entities.XMLData;
import com.teste.demo.Helpers.NFSeHelper;
import com.teste.demo.Services.DadosNFeService;
// import com.teste.demo.Services.XMLDataService;


@RestController
public class NFSecontroller {

    @Autowired
    private DadosNFeService dadosNFeService;

    // @Autowired
    // private XMLDataService xmlDataService;

    @PostMapping("/processarxml")
    
    public void processarXML(@RequestBody String xmlContent) throws IOException {
        try {
            DadosNFe dadosNFe = NFSeHelper.extrairDadosNFe(xmlContent);
            dadosNFeService.salvar(dadosNFe);
            // XMLData xmlData = new XMLData();
            // xmlData.setXmlContent(xmlContent.getBytes());
            // xmlDataService.salvar(xmlData); 
        } catch (Exception e) {
            // Trate exceções de parsing aqui
            e.printStackTrace();
        }
    }
    @GetMapping("/buscarxml/{id}")
    public DadosNFe buscarDadosNFePorId(@PathVariable Long id) {
        return dadosNFeService.buscarPorId(id).orElse(null);
    }

    @GetMapping("/buscartodosxml")
    public List<DadosNFe> buscarTodos() {
        return dadosNFeService.buscarTodos();
    }

    @PutMapping("/alterarxml/{id}")
    public void atualizarDadosNFe(@PathVariable Long id, @RequestBody DadosNFe dadosNFe) {
        Optional<DadosNFe> dadosNFeOptional = dadosNFeService.buscarPorId(id); 
        if (dadosNFeOptional.isPresent()) {
            dadosNFeService.atualizar(dadosNFe);
        } else {
            // Lidar com o caso em que o DadosNFe com o ID fornecido não existe
            // Retornar um erro, lançar uma exceção, ou fazer outra ação apropriada
        }
    }

    @DeleteMapping("/dados_nfe/{id}")
    public void excluirDadosNFe(@PathVariable Long id) {
        dadosNFeService.excluirPorId(id);
    }

    //#region
    // @GetMapping("/xml-data/{id}")
    // public XMLData buscarXMLDataPorId(@PathVariable Long id) {
    //     return xmlDataService.buscarPorId(id).orElse(null);
    // }

    // @GetMapping("/xml-data")
    // public List<XMLData> buscarTodosXMLData() {
    //     return xmlDataService.buscarTodos();
    // }


    // @PutMapping("/xml-data/{id}")
    // public void atualizarXMLData(@PathVariable Long id, @RequestBody XMLData xmlData) {
    //     Optional<XMLData> xmlDataOptional = xmlDataService.buscarPorId(id); 
    //     if (xmlDataOptional.isPresent()) {
    //         xmlData.setId(id);
    //         xmlDataService.atualizar(xmlData);
    //     } else {
    //         // Lidar com o caso em que o XMLData com o ID fornecido não existe
    //         // Retornar um erro, lançar uma exceção, ou fazer outra ação apropriada
    //     }
    // }

    // @DeleteMapping("/xml-data/{id}")
    // public void excluirXMLData(@PathVariable Long id) {
    //     xmlDataService.excluirPorId(id);
    // }
}

