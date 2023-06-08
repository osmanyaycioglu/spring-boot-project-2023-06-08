package com.spring.training.springbootproject.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class GreetingsDyn implements IGreetings {

    private String helloPrefix;
    private String goodbyePrefix;

    public GreetingsDyn(String helloPrefix,
                        String goodbyePrefix) {
        this.helloPrefix = helloPrefix;
        this.goodbyePrefix = goodbyePrefix;
    }

    @Override
    public String sayHello(String name) {
        return helloPrefix + " " + name;
    }

    @Override
    public String sayGoodbye(String name) {
        return goodbyePrefix + " " + name;
    }
}
