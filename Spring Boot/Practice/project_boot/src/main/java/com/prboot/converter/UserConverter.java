/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prboot.converter;

import com.prboot.dto.TimeDTO;
import com.prboot.dto.UserDTO;
import com.prboot.entity.TimeEntity;
import com.prboot.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ADMIN
 */
@Component
public class UserConverter {
    
    @Autowired
    private ModelMapper mapper;
    
    public UserDTO toDTO(UserEntity entity) {
        return mapper.map(entity, UserDTO.class);
    }
    
    public UserEntity toEntity(UserDTO timeDTO) {
        return mapper.map(timeDTO, UserEntity.class);
    }
}
