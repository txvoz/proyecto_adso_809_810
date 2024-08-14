package com.sena.adso809810.siparqueo.siparqueo.repository;

import com.sena.adso809810.siparqueo.siparqueo.entity.ZoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends
        JpaRepository<ZoneEntity, Long>,
        JpaSpecificationExecutor<ZoneEntity> {
}
