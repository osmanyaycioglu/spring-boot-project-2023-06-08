package com.spring.training.springbootproject.error;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(IllegalArgumentException exp) {
        return ErrorObj.builder()
                       .withErrorCode(4000)
                       .withDesc(exp.getMessage())
                       .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(MethodArgumentNotValidException exp) {
        return ErrorObj.builder()
                       .withErrorCode(4001)
                       .withDesc("validation error")
                       .withSubErrors(exp.getAllErrors()
                                         .stream()
                                         .map(e -> (FieldError) e)
                                         .map(fe -> ErrorObj.builder()
                                                            .withErrorCode(4002)
                                                            .withDesc(fe.getField()
                                                                      + " patladı. Gönderilen değer : "
                                                                      + fe.getRejectedValue())
                                                            .build())
                                         .collect(Collectors.toList()))
                       .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(ConstraintViolationException exp) {
        return ErrorObj.builder()
                       .withErrorCode(4001)
                       .withDesc("validation error")
                       .withSubErrors(exp.getConstraintViolations()
                                         .stream()
                                         .map(fe -> ErrorObj.builder()
                                                            .withErrorCode(4002)
                                                            .withDesc(fe.getMessage())
                                                            .build())
                                         .collect(Collectors.toList()))
                       .build();
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObj handleException(Exception exp) {
        exp.printStackTrace();
        return ErrorObj.builder()
                       .withErrorCode(5000)
                       .withDesc(exp.getMessage())
                       .build();
    }


}
