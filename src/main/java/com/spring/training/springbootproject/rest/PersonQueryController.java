package com.spring.training.springbootproject.rest;

import com.spring.training.springbootproject.rest.mapper.PersonMapper;
import com.spring.training.springbootproject.rest.models.Person;
import com.spring.training.springbootproject.services.PersonQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonQueryController {

    @Autowired
    private PersonQueryService personQueryService;

    @GetMapping("/find/all")
    public List<Person> findAll() {
        return PersonMapper.PERSON_MAPPER.toPersons(personQueryService.findAllPersons());
    }

}
