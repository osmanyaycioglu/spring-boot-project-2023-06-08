package com.spring.training.springbootproject;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
// @Lazy
public class Hello {

    private int counter ;

    public Hello() {
        System.out.println("Hello yaratıldı");
    }

    public String helloWorld(){
        return "hello world " + counter++;
    }

}
