package com.loind.boot.practice.controller;

import com.loind.boot.practice.model.Employee;
import com.loind.boot.practice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees/add")
    public Employee createEmployee(@RequestBody Employee e) {
        return employeeRepository.save(e);
    }
}
