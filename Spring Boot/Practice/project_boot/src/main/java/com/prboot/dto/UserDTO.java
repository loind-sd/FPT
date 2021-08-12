/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prboot.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ADMIN
 */
@Getter
@Setter
public class UserDTO extends AbstractDTO<UserDTO>{
    private String username;
    private String password;
    private String fullname;
    private boolean status;
    
}
