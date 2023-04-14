package com.api.buscacep.busca_cep.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.buscacep.busca_cep.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, String>{
    
}
