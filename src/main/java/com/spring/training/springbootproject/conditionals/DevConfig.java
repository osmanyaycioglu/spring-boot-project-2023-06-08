package com.spring.training.springbootproject.conditionals;

import com.spring.training.springbootproject.interfaces.GreetingsTr;
import com.spring.training.springbootproject.interfaces.IGreetings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@MyRandomCondition
// @Profile("develop")
@Configuration
public class DevConfig {

    @Bean
    public IGreetings greetBean(){
        return new GreetingsTr();
    }

}
