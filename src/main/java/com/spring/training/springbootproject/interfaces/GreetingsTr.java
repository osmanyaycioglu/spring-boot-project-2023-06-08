package com.spring.training.springbootproject.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("g-tr")
public class GreetingsTr implements IGreetings {

    @Override
    public String sayHello(String name) {
        return "Merhaba " + name;
    }

    @Override
    public String sayGoodbye(String name) {
        return "Güle güle " + name;
    }
}
