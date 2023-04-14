package com.api.buscacep.busca_cep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.buscacep.busca_cep.model.Endereco;

@RestController
public class CorreiosController {

    @GetMapping(value="/")
    public String getStatus() {
        return "SERVER UP";
    }

    @GetMapping(value="/cep/{cep}")
    public Endereco getEnderecoByCep(@PathVariable String cep) {
        Endereco endereco = new Endereco();
        endereco.setCep(cep);
        return endereco;
    }
}
