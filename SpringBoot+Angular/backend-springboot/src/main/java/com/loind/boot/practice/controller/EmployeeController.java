package com.loind.boot.practice.controller;

import com.loind.boot.practice.exception.ResourceNotFoundException;
import com.loind.boot.practice.model.Employee;
import com.loind.boot.practice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist!"));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee e = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist!"));

        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        e.setEmailId(employee.getEmailId());

        Employee employeeUpdate = employeeRepository.save(e);
        return ResponseEntity.ok(employeeUpdate);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deteleEmployee(@PathVariable Long id) {
        Employee e = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist!"));

        Map<String, Boolean> map = new HashMap<>();
        employeeRepository.delete(e);
        map.put("deleted", true);

        return ResponseEntity.ok(map);
    }
}
