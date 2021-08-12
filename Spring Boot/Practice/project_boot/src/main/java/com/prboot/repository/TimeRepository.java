/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prboot.repository;

import com.prboot.entity.TimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ADMIN
 */
public interface TimeRepository extends JpaRepository<TimeEntity, Long>{
    
}
