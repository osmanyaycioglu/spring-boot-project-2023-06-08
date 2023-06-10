package com.spring.training.springbootproject.rest;

import com.spring.training.springbootproject.error.ErrorObj;
import com.spring.training.springbootproject.rest.mapper.PersonMapper;
import com.spring.training.springbootproject.rest.models.Person;
import com.spring.training.springbootproject.services.PersonProvisionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/person/provision")
@Valid
public class PersonProvisionController {

    private PersonProvisionService personProvisionService;

    public PersonProvisionController(final PersonProvisionService personProvisionServiceParam) {
        personProvisionService = personProvisionServiceParam;
    }

    @PostMapping("/enable")
    public String enable(@Valid @RequestBody Person personParam) {
        personProvisionService.add(PersonMapper.PERSON_MAPPER.toPersonDto(personParam));
        return "OK";
    }

    @GetMapping("/suspend")
    public String suspend(@NotNull @RequestParam("personId") Long personId) {
        return "OK";
    }

    @GetMapping("/disable")
    public String disable(@RequestParam("personId") Long personId) {
        return "OK";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(IllegalArgumentException exp) {
        return ErrorObj.builder()
                       .withErrorCode(4000)
                       .withDesc("Farklı " + exp.getMessage())
                       .build();
    }

}
