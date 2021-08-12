/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prboot.api;

import com.prboot.dto.TimeDTO;
import com.prboot.dto.TimeTableDTO;
import com.prboot.dto.UserDTO;
import com.prboot.service.ITimeService;
import com.prboot.service.ITimeTableService;
import com.prboot.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class HomeAPI {
    
    @Autowired
    private ITimeTableService timeTableService;
    
    @Autowired
    private IUserService userService;
    
    @Autowired
    private ITimeService timeService;
    
    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping(value = "/user")
    public String user(Model model) {
        TimeTableDTO result = timeTableService.findByUserAndDate();
        model.addAttribute("timetables", result);
        return "home";
    }

    @GetMapping(value = "/admin")
    public String admin(Model model) {
        List<TimeTableDTO> result = timeTableService.findAll();
        model.addAttribute("timetables", result);
        return "adminHome";
    }
    
    @PostMapping(value = "/preAdd")
    public String preAdd(Model model) {
        List<UserDTO> users = userService.findAll();
        List<TimeDTO> times = timeService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("times", times);
        return "add";
    }
    
    
}
