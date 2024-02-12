package com.teste.demo.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.demo.Entities.DadosNFe;
import com.teste.demo.Repositories.DadosNFeRepository;

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

   
    public void atualizar(DadosNFe dadosNFe) {
        repository.save(dadosNFe);
    }

  
    public void excluirPorId(Long id) {
        repository.deleteById(id);
    }
}
