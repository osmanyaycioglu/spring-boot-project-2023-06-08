package com.spring.training.springbootproject.services.data;

import com.spring.training.springbootproject.services.dao.IPersonDao;
import com.spring.training.springbootproject.services.models.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDataService {

    @Autowired
    private IPersonDao personDao;

    public void insert(PersonDto person) {
        personDao.save(person);
    }

    public List<PersonDto> getAll()
    {
        return personDao.findAll();
    }
}
