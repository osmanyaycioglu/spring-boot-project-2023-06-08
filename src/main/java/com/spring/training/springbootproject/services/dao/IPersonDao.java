package com.spring.training.springbootproject.services.dao;

import com.spring.training.springbootproject.services.models.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonDao extends JpaRepository<PersonDto,Long> {
}
