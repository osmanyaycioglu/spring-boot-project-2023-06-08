package com.spring.training.springbootproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Method;

@SpringBootApplication(scanBasePackages = {"com.spring.training.springbootproject", "com.spring.training.execute"})
public class SpringBootProjectApplication {

    @Autowired
    private Hello hello;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootProjectApplication.class,
                                                                       args);

//		SpringBootProjectApplication bean = context.getBean(SpringBootProjectApplication.class);
//		System.out.println(bean.hello.helloWorld());

//		SpringBootProjectApplication a = new SpringBootProjectApplication();
//		a.hello.helloWorld();


    }

}
