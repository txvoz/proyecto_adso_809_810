package com.sena.adso809810.siparqueo.siparqueo.backup;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Builder
public class PersonaDto {

    @NotBlank
    private String nombre;

    @NotNull
    private Integer edad;

    @NotNull
    private Boolean isCasado;

}
