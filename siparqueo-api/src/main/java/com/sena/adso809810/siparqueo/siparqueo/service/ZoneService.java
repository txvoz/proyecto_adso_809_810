package com.sena.adso809810.siparqueo.siparqueo.service;

import com.sena.adso809810.siparqueo.siparqueo.conf.Constants;
import com.sena.adso809810.siparqueo.siparqueo.dto.TypeZoneDto;
import com.sena.adso809810.siparqueo.siparqueo.entity.ReferenceTypeEntity;
import com.sena.adso809810.siparqueo.siparqueo.entity.ZoneEntity;
import com.sena.adso809810.siparqueo.siparqueo.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ZoneService {

    @Autowired
    private ZoneRepository repository;

    @Autowired
    private ParkingServiceService parkingServiceService;

    public List<TypeZoneDto> getZonesGroupByType(){
        List<TypeZoneDto> listReturn = new ArrayList<>();
        List<ZoneEntity> entities =  this.repository.findAll();
        for (ZoneEntity entity: entities) {
            TypeZoneDto typeZoneDto;
            ReferenceTypeEntity reference = entity.getType();

            Optional<TypeZoneDto> optTypeZone = listReturn
                    .stream()
                    .filter(i -> i.getTitle().equals(reference.getTitle()))
                    .findFirst();

            if (optTypeZone.isPresent()) {
                typeZoneDto = optTypeZone.get();
            } else {
                typeZoneDto = TypeZoneDto.builder()
                        .title(reference.getTitle())
                        .zones(new ArrayList<>())
                        .build();
                listReturn.add(typeZoneDto);
            }

            boolean existActiveService = this.parkingServiceService.validateIfExistActiveServiceByZoneId(entity.getId());

            typeZoneDto.getZones().add(TypeZoneDto.ZoneDto.builder()
                            .id(entity.getId())
                            .title(entity.getTitle())
                            .status(existActiveService ? Constants.RESERVED_STATUS : entity.getStatus())
                    .build());
        }

        return listReturn;
    }
}
