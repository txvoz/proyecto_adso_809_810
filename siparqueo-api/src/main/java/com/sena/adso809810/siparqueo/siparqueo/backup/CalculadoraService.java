package com.sena.adso809810.siparqueo.siparqueo.backup;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public int sumar(int n1, int n2) {

        if(n1 <= 0) {
            throw new RuntimeException("El primer numero es igual a cero o negativo");
        }

        if(n2 <= 0) {
            throw new RuntimeException("El segundo numero es igual a cero o negativo");
        }

        return n1 + n2;
    }

}
