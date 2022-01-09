package com.example.thalesfeing.controller;

import com.example.thalesfeing.dto.ApiResponse;
import com.example.thalesfeing.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable("id") Integer id) {
        return employeeService.findById(id);
    }
}
