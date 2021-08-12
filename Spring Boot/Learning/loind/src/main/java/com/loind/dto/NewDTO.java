/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loind.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ADMIN
 */
@Getter
@Setter
public class NewDTO extends AbstractDTO<NewDTO>{

    private String title;
    private String content;
    private String thumbnail;
    private String categoryCode;
    private String shortDescription;
}
