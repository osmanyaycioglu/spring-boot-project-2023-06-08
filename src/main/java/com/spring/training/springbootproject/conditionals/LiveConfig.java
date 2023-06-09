package com.spring.training.springbootproject.conditionals;

import com.spring.training.springbootproject.interfaces.GreetingsEng;
import com.spring.training.springbootproject.interfaces.GreetingsTr;
import com.spring.training.springbootproject.interfaces.IGreetings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// @MyRandomCondition
//@Profile("live")
// @Configuration
public class LiveConfig {

    @Bean
    public IGreetings greetBean(){
        return new GreetingsEng();
    }

}
