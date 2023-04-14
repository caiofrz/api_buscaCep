package com.api.buscacep.busca_cep.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class EnderecoStatus {
    public static final int DEFAULT_ID = 1;

    @Id
    private int id;

    private Status status;

    public EnderecoStatus(int id, Status status) {
        this.id = id;
        this.status = status;
    }
    public EnderecoStatus() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
