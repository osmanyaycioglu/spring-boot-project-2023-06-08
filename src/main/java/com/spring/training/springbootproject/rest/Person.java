package com.spring.training.springbootproject.rest;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
@Data
public class Person {
    private String name;
    private String email;
    private String password;
    private String phone;
    private Integer weight;
    private Integer height;
}
