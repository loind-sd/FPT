/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loind.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity extends BaseEntity{
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "fullname")
    private String fullname;
    
    @Column
    private Boolean status;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", 
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roles = new ArrayList<>();

    @Override
    public String toString() {
        String s = "";
        s = roles.stream().map(role -> role.getName() + ",").reduce(s, String::concat);
        return s;
    }
    
    
}
