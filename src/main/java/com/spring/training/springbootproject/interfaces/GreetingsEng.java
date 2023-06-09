package com.spring.training.springbootproject.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component
@Qualifier("g-en")
public class GreetingsEng implements IGreetings {

    private CountDownLatch countDownLatch = new CountDownLatch(2);

    // 1
    public GreetingsEng() {
    }

    @Override
    public String sayHello(String name) {
        countDownLatch.countDown();
        return "Hello " + name;
    }

    @Override
    public String sayGoodbye(String name) {
        return "Goodbye " + name;
    }

    @PostConstruct
    public void xyz(){
        System.out.println("Post Construct");
    }

    @PreDestroy
    public void tp() throws InterruptedException {

//        countDownLatch.await(5,
//                             TimeUnit.SECONDS);
        // throw new IllegalArgumentException("test");
        // System.out.println("destroy");
    }
}
