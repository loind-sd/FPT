/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prboot.converter;

import com.prboot.dto.TimeTableDTO;
import com.prboot.entity.TimeTableEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ADMIN
 */
@Component
public class TimeTableConverter{
  
    @Autowired
    private ModelMapper mapper;
    
    public TimeTableDTO toDTO(TimeTableEntity entity) {
        TimeTableDTO timeTableDTO =  mapper.map(entity, TimeTableDTO.class);
//        timeTableDTO.setSlot(entity.getTime().getSlot());
//        timeTableDTO.setUser_id(entity.getUser().getId());
        return timeTableDTO;
    }
    
    public TimeTableEntity toEntity(TimeTableDTO newDTO) {
        return mapper.map(newDTO, TimeTableEntity.class);
    }
    
    public TimeTableEntity toEntity(TimeTableDTO newDTO, TimeTableEntity entity) {
        return mapper.map(newDTO, entity.getClass());
    }

}
