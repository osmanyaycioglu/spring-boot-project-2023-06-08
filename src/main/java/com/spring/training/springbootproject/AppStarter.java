package com.spring.training.springbootproject;

import com.spring.training.execute.Executor;
import com.spring.training.springbootproject.interfaces.IGreetings;
import com.spring.training.springbootproject.properties.MyProps;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("deneme-starter")
public class AppStarter implements ApplicationRunner, BeanNameAware {

    private Hello hello;
    // Field Injection
    // 2
    @Autowired
    private Hello hello1;
    private Hello hello2;

    @Autowired
    private Executor executor;

    private IGreetings greetings;

    @Autowired
    private IGreetings[] greetingsArr;

    private MyProps myProps;

    // 1
    // Constructor Injection
    @Autowired
    public AppStarter(Hello hello,
                      @Qualifier("g-dyn") IGreetings greetings,
                      final MyProps myPropsParam) {
        this.hello = hello;
        this.greetings = greetings;
        myProps = myPropsParam;
    }

    public AppStarter() {
    }

    // Method Injection
    // 3
    @Autowired
    public void xyz(Hello hello) {
        hello2 = hello;
    }

    // 4
    @PostConstruct
    public void xyz() {
        System.out.println("Post Construct");
    }

    @PreDestroy
    public void abc() {
        System.out.println("Pre Destroy");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Props" + myProps);

        for (IGreetings iGreetingsLoc : greetingsArr) {
            System.out.println("Clazz : " + iGreetingsLoc.getClass());
        }
        System.out.println(hello.helloWorld());
        System.out.println(hello1.helloWorld());
        System.out.println(hello2.helloWorld());
        executor.exec();
        System.out.println(greetings.sayHello("osman"));
        System.out.println(greetings.sayGoodbye("osman"));

    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name : " + name);
    }
}
