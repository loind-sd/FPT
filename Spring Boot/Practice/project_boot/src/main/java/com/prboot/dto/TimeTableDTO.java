/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prboot.dto;

import com.prboot.entity.RoleEntity;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ADMIN
 */
@Getter
@Setter
public class TimeTableDTO extends AbstractDTO<TimeTableDTO>{
    private Long userId;
    private Date date;
    private int timeSlot;
    private String timeTime;
    private String userFullname;
    private List<RoleEntity> userRoles;
    private boolean status;
}
