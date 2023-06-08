package com.spring.training.springbootproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CMDRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Çalıştım");
    }
}
