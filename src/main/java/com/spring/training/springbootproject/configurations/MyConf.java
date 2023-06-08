package com.spring.training.springbootproject.configurations;

import com.spring.training.springbootproject.interfaces.GreetingsDyn;
import com.spring.training.springbootproject.interfaces.GreetingsTr;
import com.spring.training.springbootproject.interfaces.IGreetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

//@Component
//@Service
//@Repository
//@Controller
@Configuration
public class MyConf {


    @Bean
    public IGreetings normalGreeting() {
        return new GreetingsTr();
    }

    @Bean("dynamicGreet")
    @Qualifier("g-dyn2")
    // @Scope("prototype")
    public IGreetings dynGreeting() {
        return new GreetingsDyn("Ola",
                                "Adios");
    }

    @Bean("flexGreet")
    @Qualifier("g-dyn")
    public IGreetings flexGreeting(Environment environment) {
        String hPrefix = environment.getProperty("app.greeting.hello.prefix");
        String gPrefix = environment.getProperty("app.greeting.goodbye.prefix");
        return new GreetingsDyn(hPrefix,
                                gPrefix);
    }

}
