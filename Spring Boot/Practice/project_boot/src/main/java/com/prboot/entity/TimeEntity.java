/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prboot.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "time")
@Getter
@Setter
public class TimeEntity extends BaseEntity{
    @Column
    private Integer slot;
    
    @Column
    private String time;
    
    @OneToMany(mappedBy = "time")
    private List<TimeTableEntity> timetables = new ArrayList<>();
    
}
