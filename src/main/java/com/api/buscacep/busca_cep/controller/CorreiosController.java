package com.api.buscacep.busca_cep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.buscacep.busca_cep.model.Endereco;
import com.api.buscacep.busca_cep.service.CorreiosService;

@RestController
public class CorreiosController {
    @Autowired
    private CorreiosService service;

    @GetMapping(value="/")
    public String getStatus() {
        return "SERVER STATUS: " + this.service.getStatus();
    }

    @GetMapping(value="/cep/{cep}")
    public Endereco getEnderecoByCep(@PathVariable String cep) {
        return this.service.getEnderecoByCep(cep);
    }
}
