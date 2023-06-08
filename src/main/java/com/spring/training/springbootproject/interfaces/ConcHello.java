package com.spring.training.springbootproject.interfaces;

public class ConcHello extends AbstractHello{

    @Override
    public String sayGoodbye(String name) {
        return "Bunu yapmak zorundayım " + name;
    }

}
