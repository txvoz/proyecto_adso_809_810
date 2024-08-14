package com.sena.adso809810.siparqueo.siparqueo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class TypeZoneDto {

    private String title;
    private List<ZoneDto> zones;

    @Data
    @AllArgsConstructor
    @Builder
    public static class ZoneDto {
        private Long id;
        private String title;
        private String status;
    }

}
