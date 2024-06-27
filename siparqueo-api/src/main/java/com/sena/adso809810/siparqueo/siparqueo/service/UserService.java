package com.sena.adso809810.siparqueo.siparqueo.service;

import com.sena.adso809810.siparqueo.siparqueo.dto.UserDto;
import com.sena.adso809810.siparqueo.siparqueo.entity.UserEntity;
import com.sena.adso809810.siparqueo.siparqueo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDto create(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setFullName(dto.getFullName());
        entity.setBornDate(dto.getBornDate());
        entity.setColor(dto.getColor());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setAvatar(dto.getAvatar());
        entity.setPassword("1234");
        entity.setRolId(dto.getRolId());

        entity = repository.save(entity);

        dto.setId(entity.getId());
        return dto;
    }

}
