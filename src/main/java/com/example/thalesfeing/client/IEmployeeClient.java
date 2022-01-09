package com.example.thalesfeing.client;

import com.example.thalesfeing.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "employee-client", url = "${employee-url-host}")
public interface IEmployeeClient {

    @GetMapping("/api/v1/employees")
    ResponseEntity<ApiResponse> findAll();


    @GetMapping("/api/v1/employee/{id}")
    ResponseEntity<ApiResponse> findById(@PathVariable("id") Integer id);

}
