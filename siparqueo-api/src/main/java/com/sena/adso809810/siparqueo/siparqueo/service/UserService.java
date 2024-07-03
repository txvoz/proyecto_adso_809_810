package com.sena.adso809810.siparqueo.siparqueo.service;

import com.sena.adso809810.siparqueo.siparqueo.dto.UserDto;
import com.sena.adso809810.siparqueo.siparqueo.entity.UserEntity;
import com.sena.adso809810.siparqueo.siparqueo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<UserDto> findAll() {

        List<UserEntity> entities =  this.repository.findAll();
        List<UserDto> dtos = new ArrayList<>();

        for(int i = 0; i < entities.size(); i++) {
            UserEntity entity =  entities.get(i);
            UserDto dto = UserDto.builder()
                    .id(entity.getId())
                    .fullName(entity.getFullName())
                    .bornDate(entity.getBornDate())
                    .color(entity.getColor())
                    .email(entity.getEmail())
                    .phone(entity.getPhone())
                    .avatar(entity.getAvatar())
                    .rolId(entity.getRolId())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }

    public UserDto getById(Long id) {

        UserEntity entity = this.repository.findById(id).get();
        UserDto dto = UserDto.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .bornDate(entity.getBornDate())
                .color(entity.getColor())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .avatar(entity.getAvatar())
                .rolId(entity.getRolId())
                .build();

        return dto;
    }

    public boolean deleteById(Long id) {
        if(id <= 0) {
            return false;
        }

        if(!this.repository.findById(id).isPresent()) {
            return false;
        }

        this.repository.deleteById(id);
        return true;
    }

    public UserDto updateById(Long id, UserDto newData) {
        if(id <= 0) {
            return null;
        }

        Optional<UserEntity> optEntity = this.repository.findById(id);

        if(!optEntity.isPresent()) {
            return null;
        }

        //Ya tienen internamente el id
        UserEntity entity = optEntity.get();

        entity.setFullName(newData.getFullName());
        entity.setBornDate(newData.getBornDate());
        entity.setColor(newData.getColor());
        entity.setEmail(newData.getEmail());
        entity.setPhone(newData.getPhone());
        entity.setAvatar(newData.getAvatar());
        entity.setRolId(newData.getRolId());

        this.repository.save(entity);

        newData.setId(entity.getId());

        return newData;
    }

}
