package com.sena.adso809810.siparqueo.siparqueo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;

    @NotBlank
    private String fullName;

    @NotNull
    private Date bornDate;

    @NotBlank
    private String color;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String avatar;

    @NotNull
    private Long rolId;

    private String rolName;

    private String password;

    private String fullpathAvatar;
}
