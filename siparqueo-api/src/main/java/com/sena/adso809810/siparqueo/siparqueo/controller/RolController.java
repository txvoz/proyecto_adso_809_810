package com.sena.adso809810.siparqueo.siparqueo.controller;

import com.sena.adso809810.siparqueo.siparqueo.dto.RolDto;
import com.sena.adso809810.siparqueo.siparqueo.dto.ServerResponseDataDto;
import com.sena.adso809810.siparqueo.siparqueo.dto.UserDto;
import com.sena.adso809810.siparqueo.siparqueo.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService service;

    @GetMapping
    public ServerResponseDataDto findAll() {

        List<RolDto> dtos = this.service.findAll();

        return ServerResponseDataDto.builder()
                .data(dtos)
                .status(HttpStatus.OK.value())
                .message("Registro encontrados")
                .build();
    }

}
