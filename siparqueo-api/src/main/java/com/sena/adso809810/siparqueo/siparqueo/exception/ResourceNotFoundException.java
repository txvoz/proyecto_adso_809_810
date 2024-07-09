package com.sena.adso809810.siparqueo.siparqueo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Recurso no encontrado")
public class ResourceNotFoundException extends RuntimeException{
}
