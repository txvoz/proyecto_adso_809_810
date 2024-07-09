package com.sena.adso809810.siparqueo.siparqueo.service;

import com.sena.adso809810.siparqueo.siparqueo.entity.RolEntity;
import com.sena.adso809810.siparqueo.siparqueo.repository.RolRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRespository repository;

    public boolean existRolById(Long id) {
        Optional<RolEntity> optionalRolEntity = this.repository.findById(id);
        return optionalRolEntity.isPresent();
    }

}
