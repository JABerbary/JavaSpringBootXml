package com.prjxml.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prjxml.demo.domain.XMLData;
import com.prjxml.demo.repository.XMLDataRepository;

import java.util.List;
import java.util.Optional;

@Service
public class XMLDataService {

    @Autowired
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

    public void deletarTodos() {
        repository.deleteAll();
        repository.resetAutoIncrement(); 
    }
    // public void atualizar(XMLData xmlData) {
    // repository.save(xmlData);
    // }

    // public void excluirPorId(Long id) {
    // repository.deleteById(id);
    // }
}