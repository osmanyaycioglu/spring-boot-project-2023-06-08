package com.spring.training.springbootproject.services;

import com.spring.training.springbootproject.services.data.PersonDataService;
import com.spring.training.springbootproject.services.models.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonQueryService {

    @Autowired
    private PersonDataService personDataService;

    public List<PersonDto> findAllPersons(){
        return personDataService.getAll();
    }

}
