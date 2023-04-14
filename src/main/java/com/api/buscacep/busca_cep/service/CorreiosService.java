package com.api.buscacep.busca_cep.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.api.buscacep.busca_cep.BuscaCepApplication;
import com.api.buscacep.busca_cep.exception.NoContentException;
import com.api.buscacep.busca_cep.exception.NotReadyException;
import com.api.buscacep.busca_cep.model.Endereco;
import com.api.buscacep.busca_cep.model.EnderecoStatus;
import com.api.buscacep.busca_cep.model.Status;
import com.api.buscacep.busca_cep.repository.EnderecoRepository;
import com.api.buscacep.busca_cep.repository.EnderecoStatusRepository;
import com.api.buscacep.busca_cep.repository.SetupRepository;

@Service
public class CorreiosService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoStatusRepository enderecoStatusRepository;

    @Autowired
    private SetupRepository setupRepository;
    
    public Status getStatus() {
        var enderecoStatus = new EnderecoStatus();
        enderecoStatus.setStatus(Status.NEED_SETUP);
        return this.enderecoStatusRepository.findById(EnderecoStatus.DEFAULT_ID)
                    .orElse(enderecoStatus)
                    .getStatus();
    }

    public Endereco getEnderecoByCep(String cep) throws NotReadyException, NoContentException {

        if (!this.getStatus().equals(Status.READY)) {
            throw new NotReadyException(); //err 503
        }

        return enderecoRepository.findById(cep)
                .orElseThrow(NoContentException::new); // err 204
    }


    @EventListener(ApplicationStartedEvent.class)
    protected void setupOnStartUp() {
        try {
            this.setup();
        } catch (Exception e) {
            BuscaCepApplication.close(9999);
        }
    }

    public void setup() throws IOException {
        if (this.getStatus().equals(Status.NEED_SETUP)){
            this.saveStatus(Status.SETUP_RUNNING);

            try {
                this.enderecoRepository.saveAll(this.setupRepository.getListaEnderecos());
                
            } catch (Exception e) {
                this.saveStatus(Status.NEED_SETUP);
                throw e;
            }
            this.saveStatus(Status.READY);
        }
    }

    private void saveStatus(Status status) {

        var EnderecoStatusAux = new EnderecoStatus();
        EnderecoStatusAux.setId(EnderecoStatus.DEFAULT_ID);
        EnderecoStatusAux.setStatus(status);

        this.enderecoStatusRepository.save(EnderecoStatusAux);
    }
    
}
