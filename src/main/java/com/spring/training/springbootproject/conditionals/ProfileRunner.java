package com.spring.training.springbootproject.conditionals;

import com.spring.training.springbootproject.interfaces.IGreetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProfileRunner implements CommandLineRunner {

    @Autowired(required = false)
    @Qualifier("greetBean")
    private IGreetings greetings;

    @Override
    public void run(final String... args) throws Exception {
        if (greetings != null) {
            System.out.println("-----*************----------------------");
            System.out.println(greetings.sayHello("osman xyz"));
            System.out.println("-----*************----------------------");
        } else {
            System.out.println("%%%%%%%%%%%%%NULL");
        }
    }

}
