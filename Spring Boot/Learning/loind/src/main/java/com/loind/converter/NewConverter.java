/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loind.converter;

import com.loind.dto.NewDTO;
import com.loind.entity.NewEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ADMIN
 */
@Component
public class NewConverter{
  
    @Autowired
    private ModelMapper mapper;
    
    public NewDTO toDTO(NewEntity entity) {
        return mapper.map(entity, NewDTO.class);
    }
    
    public NewEntity toEntity(NewDTO newDTO) {
        return mapper.map(newDTO, NewEntity.class);
    }
    
    public NewEntity toEntity(NewDTO newDTO, NewEntity entity) {
        return mapper.map(newDTO, entity.getClass());
    }

}
