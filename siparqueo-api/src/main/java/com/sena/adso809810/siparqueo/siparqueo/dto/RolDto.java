package com.sena.adso809810.siparqueo.siparqueo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@AllArgsConstructor
@Builder
@CrossOrigin(origins = "*", maxAge = 3600)
public class RolDto {
    private Long id;
    private String name;
}
