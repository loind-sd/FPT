/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loind.service;

import com.loind.dto.NewDTO;
import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author ADMIN
 */
public interface INewService {

    NewDTO save(NewDTO newDTO);
    
    void delete(long[] ids);
    
    int totalItem();
    
    List<NewDTO> findAll(Pageable pageable);
    
    NewDTO findById(Long id);
}
