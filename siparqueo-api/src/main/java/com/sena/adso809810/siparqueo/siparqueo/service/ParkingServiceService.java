package com.sena.adso809810.siparqueo.siparqueo.service;

import com.sena.adso809810.siparqueo.siparqueo.entity.ParkingServiceEntity;
import com.sena.adso809810.siparqueo.siparqueo.repository.ParkingServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ParkingServiceService {

    @Autowired
    private ParkingServiceRepository repository;

    boolean validateIfExistActiveServiceByZoneId(Long zoneId) {
        ParkingServiceEntity entity = repository.findOneByZoneId(zoneId);
        if(Objects.isNull(entity)) {
            return false;
        }
        return true;
     }

}
