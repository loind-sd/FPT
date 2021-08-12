/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prboot.service.impl;

import com.prboot.converter.UserConverter;
import com.prboot.dto.UserDTO;
import com.prboot.entity.UserEntity;
import com.prboot.repository.UserRepository;
import com.prboot.service.IUserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> list = new ArrayList<>();
        List<UserEntity> entitys = userRepository.findAll();
        entitys.forEach(entity -> {
            list.add(userConverter.toDTO(entity));
        });
        return list;
    }

}
