package com.spring.training.springbootproject.rest;

import com.spring.training.springbootproject.error.ErrorObj;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/person/provision")
@Valid
public class PersonProvisionController {



    @PostMapping("/enable")
    public String enable(@Valid @RequestBody Person personParam) {

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
                       .withDesc("Farklı "  + exp.getMessage())
                       .build();
    }

}
