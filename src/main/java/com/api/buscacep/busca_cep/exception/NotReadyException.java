package com.api.buscacep.busca_cep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE, reason = "Serviço em instalação... Aguarde!") // err 503
public class NotReadyException extends Exception{
    
}
