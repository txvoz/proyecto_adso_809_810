package com.sena.adso809810.siparqueo.siparqueo.repository;

import com.sena.adso809810.siparqueo.siparqueo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
        JpaRepository<UserEntity, Long>,
        JpaSpecificationExecutor<UserEntity> {}
