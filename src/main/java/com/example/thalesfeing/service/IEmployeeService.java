package com.example.thalesfeing.service;

import com.example.thalesfeing.dto.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface IEmployeeService {


    ResponseEntity<ApiResponse> findAll();

    ResponseEntity<ApiResponse> findById(Integer id);

}
