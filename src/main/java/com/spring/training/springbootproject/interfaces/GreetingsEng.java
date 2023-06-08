package com.spring.training.springbootproject.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("g-en")
public class GreetingsEng implements IGreetings {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public String sayGoodbye(String name) {
        return "Goodbye " + name;
    }
}
