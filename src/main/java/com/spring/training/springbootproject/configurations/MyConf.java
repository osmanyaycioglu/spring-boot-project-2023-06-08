package com.spring.training.springbootproject.configurations;

import com.spring.training.execute.ExecutorConfig;
import com.spring.training.springbootproject.interfaces.GreetingsDyn;
import com.spring.training.springbootproject.interfaces.GreetingsEng;
import com.spring.training.springbootproject.interfaces.GreetingsTr;
import com.spring.training.springbootproject.interfaces.IGreetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

//@Component
//@Service
//@Repository
//@Controller
@Configuration
@Import(ExecutorConfig.class)
@PropertySource("classpath:a.properties")
public class MyConf {

    @Bean
    public IGreetings normalGreeting() {
        return new GreetingsTr();
    }

    @Bean
    public GreetingsEng englishGreeting() {
        return new GreetingsEng();
    }


    @Bean("dynamicGreet")
    @Qualifier("g-dyn2")
    // @Scope("prototype")
    public IGreetings dynGreeting() {
        return new GreetingsDyn("Ola",
                                "Adios");
    }

    @Bean("flexGreet")
    @Qualifier("g-dyn3")
    public IGreetings flexGreeting(Environment environment) {
        String hPrefix = environment.getProperty("app.greeting.hello.prefix");
        String gPrefix = environment.getProperty("app.greeting.goodbye.prefix");
        return new GreetingsDyn(hPrefix,
                                gPrefix);
    }

    @Bean("flexGreet2")
    @Qualifier("g-dyn4")
    public IGreetings flexGreeting2(@Value("${app.greeting.hello.prefix}") String hPrefix,
                                    @Value("${app.greeting.goodbye.prefix}") String gPrefix) {
        return new GreetingsDyn(hPrefix,
                                gPrefix);
    }

    @Bean("flexGreet3")
    @Qualifier("g-dyn")
    public IGreetings flexGreeting3(@Value("${app.language}") String language,
                                    @Value("${app.greeting.hello.prefix}") String hPrefix,
                                    @Value("${app.greeting.goodbye.prefix}") String gPrefix) {
        switch (language){
            case "en":
                return new GreetingsEng();
            case "tr":
                return new GreetingsTr();
            case "dyn":
                return new GreetingsDyn(hPrefix,
                                        gPrefix);
            default:
                return new GreetingsEng();
        }
    }


}
