package com.spring.training.springbootproject.services;

import com.spring.training.springbootproject.services.data.PersonDataService;
import com.spring.training.springbootproject.services.models.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonProvisionService {

    @Autowired
    private PersonDataService personDataService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void add(PersonDto personDtoParam) {
        personDataService.insert(personDtoParam);
    }

}
