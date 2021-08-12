/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prboot.converter;

import com.prboot.dto.TimeDTO;
import com.prboot.entity.TimeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ADMIN
 */
@Component
public class TimeConverter {
    
    @Autowired
    private ModelMapper mapper;
    
    public TimeDTO toDTO(TimeEntity entity) {
        return mapper.map(entity, TimeDTO.class);
    }
    
    public TimeEntity toEntity(TimeDTO timeDTO) {
        return mapper.map(timeDTO, TimeEntity.class);
    }
}
