package com.example.thalesfeing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

    private Integer id;

    @Valid
    private String employee_name;

    @Valid
    private Integer employee_salary;

    @Valid
    private Integer employee_age;

    @Valid
    private String profile_image;

    @Valid
    private Integer employee_anual_salary;


}
