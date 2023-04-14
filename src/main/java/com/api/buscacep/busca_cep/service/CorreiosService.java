package com.api.buscacep.busca_cep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.api.buscacep.busca_cep.model.Endereco;
import com.api.buscacep.busca_cep.model.Status;
import com.api.buscacep.busca_cep.repository.EnderecoRepository;
import com.api.buscacep.busca_cep.repository.EnderecoStatusRepository;

@Service
public class CorreiosService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoStatusRepository enderecoStatusRepository;
    
    public Status getStatus() {
        return Status.READY;
    }

    public Endereco getEnderecoByCep(String cep) {
        return enderecoRepository.findById(cep)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void setup() {
        
    }
    
}
