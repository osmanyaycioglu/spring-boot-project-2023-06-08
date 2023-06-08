package com.spring.training.execute;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorConfig {

    @Bean
    public Executor executor(){
        return new Executor();
    }
}
