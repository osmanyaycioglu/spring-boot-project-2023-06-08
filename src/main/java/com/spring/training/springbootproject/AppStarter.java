package com.spring.training.springbootproject;

import com.spring.training.execute.Executor;
import com.spring.training.springbootproject.interfaces.IGreetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStarter implements ApplicationRunner {

    private Hello hello;
    // Field Injection
    @Autowired
    private Hello hello1;
    private Hello hello2;

    @Autowired
    private Executor executor;

    private IGreetings greetings;

    // Constructor Injection
    @Autowired
    public AppStarter(Hello hello,
                      @Qualifier("g-dyn") IGreetings greetings) {
        this.hello = hello;
        this.greetings = greetings;
    }

    public AppStarter() {
    }

    // Method Injection
    @Autowired
    public void xyz(Hello hello){
        hello2 = hello;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(hello.helloWorld());
        System.out.println(hello1.helloWorld());
        System.out.println(hello2.helloWorld());
        executor.exec();
        System.out.println(greetings.sayHello("osman"));
        System.out.println(greetings.sayGoodbye("osman"));

    }

}
