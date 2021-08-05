package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;
import java.util.ArrayList;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewService implements INewService {

    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> models = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll(pageable).getContent();
        entities.stream().map(item -> newConverter.toDTO(item)).forEachOrdered(newDTO -> {
            models.add(newDTO);
        });
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) newRepository.count();
    }

    @Override
    public NewDTO findById(long id) {
        NewEntity entity = newRepository.findOne(id);
        return newConverter.toDTO(entity);
    }

    @Override
    @Transactional
    public NewDTO save(NewDTO dto) {
        CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
        NewEntity newEntity;
        if (dto.getId() != null) {
            NewEntity oldNew = newRepository.findOne(dto.getId());
            oldNew.setCategory(category);
            newEntity = newConverter.toEntity(oldNew, dto);
        } else {
            newEntity = newConverter.toEntity(dto);
            newEntity.setCategory(category);
        }
        return newConverter.toDTO(newRepository.save(newEntity));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id : ids) {
            newRepository.delete(id);
        }
    }
}
