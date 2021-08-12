/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prboot.service;

import com.prboot.dto.UserDTO;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IUserService {
    List<UserDTO> findAll();
}
