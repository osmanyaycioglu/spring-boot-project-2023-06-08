package com.spring.training.springbootproject.rest.mapper;

import com.spring.training.springbootproject.rest.models.Person;
import com.spring.training.springbootproject.services.models.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper {

    public static final PersonMapper PERSON_MAPPER = Mappers.getMapper(PersonMapper.class);

    Person toPerson(PersonDto person);

    PersonDto toPersonDto(Person person);

    List<Person> toPersons(List<PersonDto> person);

    List<PersonDto> toPersonDtos(List<Person> person);

}
