package com.sena.adso809810.siparqueo.siparqueo.controller;

import com.sena.adso809810.siparqueo.siparqueo.dto.PersonaDto;
import com.sena.adso809810.siparqueo.siparqueo.dto.ServerResponseDataDto;
import com.sena.adso809810.siparqueo.siparqueo.dto.ServerResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    public ArrayList<PersonaDto> personas = new ArrayList<>();

    @PostMapping()
    public ServerResponseDto agregar(@RequestBody @Valid PersonaDto persona) {
        this.personas.add(persona);
        System.out.println(this.personas.size());

        return ServerResponseDto
                .builder()
                .message("Registro agregado con exito")
                .status(HttpStatus.OK.value())
                .build();
    }

    @GetMapping()
    public ArrayList<PersonaDto> obtenerPersonas(){
        return personas;
    }

    @GetMapping(path = "/{id}")
    public ServerResponseDataDto obtenerPorId(@PathVariable("id") int id) {
        if(id < 0 || id > this.personas.size() - 1) {
            return ServerResponseDataDto
                    .builder()
                    .message("No existe registro con ese indice")
                    .status(HttpStatus.BAD_REQUEST.value())
                    .build();
        }
        return ServerResponseDataDto
                .builder()
                .message("Registro encontrado")
                .status(HttpStatus.OK.value())
                .data(this.personas.get(id))
                .build();
    }

    @PutMapping(path = "/{id}")
    public ServerResponseDto actualizarUsuarioPorId(
            @PathVariable("id") int id,
            @RequestBody @Valid PersonaDto persona
    ) {
        if(id < 0 || id > this.personas.size() - 1) {
            return ServerResponseDto
                    .builder()
                    .message("No existe registro con ese indice")
                    .status(HttpStatus.BAD_REQUEST.value())
                    .build();
        }

        this.personas.set(id, persona);

        return ServerResponseDto
                .builder()
                .message("Registro actualizado con exito")
                .status(HttpStatus.OK.value())
                .build();
    }

    @DeleteMapping(path = "/{id}")
    public ServerResponseDto eliminarPorId(@PathVariable("id") int id) {
        if(id < 0 || id > this.personas.size() - 1) {
            return ServerResponseDto
                    .builder()
                    .message("No existe registro con ese indice")
                    .status(HttpStatus.BAD_REQUEST.value())
                    .build();
        }

        this.personas.remove(id);
        return ServerResponseDto
                .builder()
                .message("Registro eliminado")
                .status(HttpStatus.OK.value())
                .build();
    }

}
