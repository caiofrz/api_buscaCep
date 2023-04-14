package com.api.buscacep.busca_cep.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.buscacep.busca_cep.model.EnderecoStatus;

public interface EnderecoStatusRepository extends CrudRepository<EnderecoStatus, Integer>{
    
}
