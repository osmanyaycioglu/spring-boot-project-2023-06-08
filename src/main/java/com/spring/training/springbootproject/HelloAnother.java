package com.spring.training.springbootproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloAnother {

    @Autowired
    private Hello hello;

    public String helloWorld(){
        return "Hello another";
    }
}
