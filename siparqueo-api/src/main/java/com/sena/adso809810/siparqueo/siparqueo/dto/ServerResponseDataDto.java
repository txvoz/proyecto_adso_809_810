package com.sena.adso809810.siparqueo.siparqueo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ServerResponseDataDto {
    private String message;
    private int status;
    public Object data;
}
