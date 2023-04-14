package com.api.buscacep.busca_cep.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Endereco {

    @Id
    private String cep;

    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    
    public Endereco(String estado, String cidade, String bairro, String cep, String rua) {
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    public Endereco() {
    }

    public String getCep() {
        return cep;
    }
    public String getRua() {
        return rua;
    }
    public String getBairro() {
        return bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
