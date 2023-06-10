package com.spring.training.springbootproject.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person/management")
public class PersonDataManagementController {

    @GetMapping("/update")
    public String update(@RequestBody Person personParam){
        return "OK";
    }


}
