package com.sena.adso809810.siparqueo.siparqueo.backup;

import com.sena.adso809810.siparqueo.siparqueo.dto.ServerResponseDataDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @Autowired
    private CalculadoraService service;

    @PostMapping("/sumar")
    public ServerResponseDataDto sumar(@RequestBody @Valid SumaDto sumaDto) {

        int resultado = this.service.sumar(sumaDto.getN1(), sumaDto.getN2());

        return ServerResponseDataDto.builder()
                .status(HttpStatus.OK.value())
                .message("Proceso exitoso")
                .data(resultado)
                .build();
    }
}
