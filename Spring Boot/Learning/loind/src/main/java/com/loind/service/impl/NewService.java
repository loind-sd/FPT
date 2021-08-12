/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loind.service.impl;

import com.loind.converter.NewConverter;
import com.loind.dto.NewDTO;
import com.loind.entity.CategoryEntity;
import com.loind.entity.NewEntity;
import com.loind.repository.CategoryRepository;
import com.loind.repository.NewRepository;
import com.loind.service.INewService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class NewService implements INewService {

    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    @Override
    public NewDTO save(NewDTO newDTO) {
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        NewEntity newEntity;

        if (newDTO.getId() != null) {
            Optional<NewEntity> oldNewEntity = newRepository.findById(newDTO.getId());
            newEntity = newConverter.toEntity(newDTO, oldNewEntity.get());
        } else {
            newEntity = newConverter.toEntity(newDTO);
        }
        newEntity.setCategory(categoryEntity);
        newEntity = newRepository.save(newEntity);
        return newConverter.toDTO(newEntity);
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            newRepository.deleteById(id);
        }
    }

    @Override
    public int totalItem() {
        return (int) newRepository.count();
    }

    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> results = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll(pageable).getContent();
        entities.stream().map(item -> newConverter.toDTO(item)).forEachOrdered(newDTO -> {
            results.add(newDTO);
        });
        return results;
    }

    @Override
    public NewDTO findById(Long id) {
        return newConverter.toDTO(newRepository.findById(id).get());
    }

}
