package com.sena.adso809810.siparqueo.siparqueo.controller;

import com.sena.adso809810.siparqueo.siparqueo.dto.ServerResponseDataDto;
import com.sena.adso809810.siparqueo.siparqueo.dto.UserDto;
import com.sena.adso809810.siparqueo.siparqueo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping()
    public ServerResponseDataDto create(@RequestBody @Valid UserDto dto) {

        UserDto response = this.service.create(dto);

        return ServerResponseDataDto.builder()
                .data(response)
                .status(HttpStatus.OK.value())
                .message("Registro creado con exito")
                .data(response)
                .build();

    }

}
