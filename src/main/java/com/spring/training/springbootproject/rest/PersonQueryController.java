package com.spring.training.springbootproject.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonQueryController {

    @GetMapping("/find/all")
    public List<Person> findAll() {
        return null;
    }

}
