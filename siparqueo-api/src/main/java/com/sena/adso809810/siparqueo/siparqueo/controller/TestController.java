package com.sena.adso809810.siparqueo.siparqueo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(path = "")
    public String saludar(){
        return "Hola chicos de adso desde Java otro cambios";
    }

    @GetMapping(path = "/saludar")
    public String saludar2(){
        return "Hola este es otro saludo";
    }

    @GetMapping(path = "/despedir")
    public String saludar3(){
        return "Bye gracias por estar en la sesion";
    }

}
