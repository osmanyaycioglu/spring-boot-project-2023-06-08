package com.spring.training.springbootproject.interfaces;

public abstract class AbstractHello implements IGreetings {

    @Override
    public String sayHello(String name) {
        return "Canım bunu istedi " + name;
    }
}
