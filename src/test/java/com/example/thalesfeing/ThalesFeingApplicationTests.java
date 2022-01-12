package com.example.thalesfeing;

import com.example.thalesfeing.controller.EmployeeController;
import com.example.thalesfeing.dto.ApiResponse;
import com.example.thalesfeing.service.impl.EmployeeServiceImpl;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ThalesFeingApplicationTests {


    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setMockOutput() {
        when(employeeService.findAll()).thenReturn(new ResponseEntity<>(ApiResponse.builder()
                .message("succes")
                .build(), HttpStatus.ACCEPTED));
    }


    @Test
    void shouldReturnDefaultMessage() {
        ResponseEntity<ApiResponse> apiresponse = employeeController.findAll();
        assertThat(apiresponse.getBody().getMessage()).isEqualTo("succes");
    }

}
