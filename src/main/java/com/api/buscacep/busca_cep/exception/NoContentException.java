package com.api.buscacep.busca_cep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT) // erro 204
public class NoContentException extends Exception{
    
}
