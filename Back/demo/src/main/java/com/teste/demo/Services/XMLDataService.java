package com.teste.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teste.demo.Entities.XMLData;
import com.teste.demo.Repositories.XMLDataRepository;

import java.util.List;
import java.util.Optional;

@Service
public class XMLDataService {


    private XMLDataRepository repository;

    public XMLData salvar(XMLData xmlData) {
        return repository.save(xmlData);
     }

    public Optional<XMLData> buscarXMLPorId(Long id) {
        return repository.findById(id);
    }

    public List<XMLData> buscarTodosXML() {
        return repository.findAll();
    }

    // public void atualizar(XMLData xmlData) {
    //     repository.save(xmlData);
    // }

    // public void excluirPorId(Long id) {
    //     repository.deleteById(id);
    // }
}