/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prboot.repository;

import com.prboot.entity.TimeTableEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ADMIN
 */
@Repository
public interface TimeTableRepository extends JpaRepository<TimeTableEntity, Long>{
    
    @Query(value = "SELECT * FROM pr_boot.time_table as t where t.user_id = ?1 and t.date = cast(now() as date)", nativeQuery = true)
    TimeTableEntity serach(Long userID);
    
    @Query(value = "SELECT * FROM pr_boot.time_table as t where t.date = cast(now() as date)", nativeQuery = true)
    List<TimeTableEntity> findAllToday();
}
