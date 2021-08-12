/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prboot.service;

import com.prboot.dto.TimeDTO;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ITimeService {
    List<TimeDTO> findAll();
}
