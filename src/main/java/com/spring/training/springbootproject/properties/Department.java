package com.spring.training.springbootproject.properties;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class Department {
    private String name;
    private String location;
    private String description;
    @Min(5)
    @Max(10_000)
    private Integer employeeCount;

}
