/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loind.api;

import com.loind.dto.NewDTO;
import com.loind.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
public class NewAPI {

    @Autowired
    private INewService newService;
    
    @GetMapping(value = "/new")
    public String showNew(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        NewDTO result = new NewDTO();
        result.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, limit);
        result.setListResult(newService.findAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
        
        model.addAttribute("news", result);
        return "show";
    }
    
    @GetMapping(value = "/preNew")
    public String preUpdate(Model model, @RequestParam("id") Long id) {
        NewDTO newDTO = newService.findById(id);
        model.addAttribute("newnew", newDTO);
        return "preNew";
    }

    @PostMapping(value = "/new")
    public String createNew(NewDTO model) {
        newService.save(model);
        return "redirect:/new?page=1&limit=2";
    }

    @RequestMapping(value = "/new/{id}")
    public String updateNew(NewDTO model, @PathVariable("id") long id) {
        model.setId(id);
        newService.save(model);
        return "redirect:/new?page=1&limit=2";
    }

    @DeleteMapping(value = "/new")
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }

}
