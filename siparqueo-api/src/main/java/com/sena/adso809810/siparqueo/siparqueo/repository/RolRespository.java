package com.sena.adso809810.siparqueo.siparqueo.repository;

import com.sena.adso809810.siparqueo.siparqueo.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRespository extends
        JpaRepository<RolEntity, Long>,
        JpaSpecificationExecutor<RolEntity> {
}
