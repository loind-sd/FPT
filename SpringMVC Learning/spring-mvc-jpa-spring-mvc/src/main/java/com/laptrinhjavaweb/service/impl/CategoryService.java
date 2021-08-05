/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Map<String, String> findAll() {
        
        Map<String, String> result = new HashMap<>();

        List<CategoryEntity> list = categoryRepository.findAll();
        list.forEach(categoryEntity -> {
            result.put(categoryEntity.getCode(), categoryEntity.getName());
        });
        return result;
    }

}
