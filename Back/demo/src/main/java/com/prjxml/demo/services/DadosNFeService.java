package com.prjxml.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prjxml.demo.domain.DadosNFe;
import com.prjxml.demo.repository.DadosNFeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DadosNFeService {

    @Autowired
    private DadosNFeRepository repository;

    
    public DadosNFe salvar(DadosNFe dadosNFe) {
        return repository.save(dadosNFe);
    }

    public Optional<DadosNFe> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<DadosNFe> buscarTodos() {
        return repository.findAll();
    }

    public List<DadosNFe> buscarorder() {
        return repository.findAllByOrderByCreatedAtAsc();
    }

    // public void atualizar(DadosNFe dadosNFe) {
    //     repository.save(dadosNFe);
    // }
  
    // public void excluirPorId(Long id) {
    //     repository.deleteById(id);
    // }

    

}
