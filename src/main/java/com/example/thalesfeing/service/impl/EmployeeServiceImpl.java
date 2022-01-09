package com.example.thalesfeing.service.impl;

import com.example.thalesfeing.client.IEmployeeClient;
import com.example.thalesfeing.dto.ApiResponse;
import com.example.thalesfeing.dto.EmployeeDto;
import com.example.thalesfeing.service.IEmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeeClient iEmployeeClient;

    @Autowired
    ObjectMapper mapper;

    @Override
    public ResponseEntity<ApiResponse> findAll() {

        ResponseEntity<ApiResponse> responseEntity = iEmployeeClient.findAll();
        List<EmployeeDto> employeeDtos = (List<EmployeeDto>) responseEntity.getBody().getData();
        employeeDtos = mapper.convertValue(employeeDtos, new TypeReference<List<EmployeeDto>>() {
        });
        for (EmployeeDto employeeDto : employeeDtos) {
            employeeDto.setEmployee_anual_salary(employeeDto.getEmployee_salary() * 12);
        }
        responseEntity.getBody().setData(employeeDtos);

        return responseEntity;
    }

    @Override
    public ResponseEntity<ApiResponse> findById(Integer id) {

        ResponseEntity<ApiResponse> responseEntity = iEmployeeClient.findById(id);
        if (responseEntity.getBody().getData() != null) {
            EmployeeDto employeeDto = mapper.convertValue(responseEntity.getBody().getData(), EmployeeDto.class);
            employeeDto.setEmployee_anual_salary(employeeDto.getEmployee_salary() * 12);
            responseEntity.getBody().setData(employeeDto);
        }
        return responseEntity;
    }
       

}
