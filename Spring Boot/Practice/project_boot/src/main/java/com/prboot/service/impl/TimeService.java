/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prboot.service.impl;

import com.prboot.converter.TimeConverter;
import com.prboot.dto.TimeDTO;
import com.prboot.entity.TimeEntity;
import com.prboot.repository.TimeRepository;
import com.prboot.service.ITimeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class TimeService implements ITimeService{

    @Autowired
    private TimeConverter timeConverter;
    
    @Autowired
    private TimeRepository timeRepository;
    
    @Override
    public List<TimeDTO> findAll() {
        List<TimeDTO> list = new ArrayList<>();
        List<TimeEntity> entitys = timeRepository.findAll();
        entitys.forEach(entity -> {
            list.add(timeConverter.toDTO(entity));
        });
        return list;
    }
    
}
