package com.sena.adso809810.siparqueo.siparqueo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "El email ya se encuentra registrado")
public class EmailNotValidException extends RuntimeException{
}
