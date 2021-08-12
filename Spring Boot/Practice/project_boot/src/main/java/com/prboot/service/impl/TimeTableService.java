/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prboot.service.impl;

import com.prboot.converter.TimeConverter;
import com.prboot.converter.TimeTableConverter;
import com.prboot.converter.UserConverter;
import com.prboot.dto.TimeTableDTO;
import com.prboot.entity.TimeTableEntity;
import com.prboot.repository.TimeTableRepository;
import com.prboot.repository.UserRepository;
import com.prboot.service.ITimeTableService;
import com.prboot.utils.MyUserDetails;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class TimeTableService implements ITimeTableService{
    
    @Autowired
    private TimeTableRepository timeTableRepository;
    
    @Autowired
    private TimeTableConverter converter;
    
    @Autowired
    private UserConverter userConverter;
    
    
    
    @Autowired
    private UserRepository userRepository;
    
    private MyUserDetails myUserDetails = new MyUserDetails();

    @Override
    public List<TimeTableDTO> findAll() {
        List<TimeTableDTO> result = new ArrayList<>();
        List<TimeTableEntity> entitys = timeTableRepository.findAllToday();
        entitys.forEach(entity -> {
            result.add(converter.toDTO(entity));
        });
        return result;
    }

    @Override
    public TimeTableDTO findByUserAndDate() {
        String username = myUserDetails.getCurrentUserName().get();
        Long user = userRepository.findByUsername(username).get().getId();
        TimeTableEntity entity = timeTableRepository.serach(user);
        
        return converter.toDTO(entity);
    }
}
