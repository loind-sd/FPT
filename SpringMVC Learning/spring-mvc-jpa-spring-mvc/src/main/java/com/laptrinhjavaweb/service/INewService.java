package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.NewDTO;
import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author ADMIN
 */
public interface INewService {

    List<NewDTO> findAll(Pageable pageable);

    int getTotalItem();

    NewDTO findById(long id);

    NewDTO save(NewDTO dto);
    
    void delete(long[] ids);
}
