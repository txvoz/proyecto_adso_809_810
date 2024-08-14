package com.sena.adso809810.siparqueo.siparqueo.repository;

import com.sena.adso809810.siparqueo.siparqueo.entity.ParkingServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingServiceRepository extends
        JpaRepository<ParkingServiceEntity, Long>,
        JpaSpecificationExecutor<ParkingServiceEntity> {

    @Query(
            value = "SELECT * " +
                    "FROM parking_service s " +
                    "WHERE s.zone_id = ?1 and exit_date is null " +
                    "LIMIT 0,1 ",
            nativeQuery = true
    )
    ParkingServiceEntity findOneByZoneId(Long zoneId);
}
