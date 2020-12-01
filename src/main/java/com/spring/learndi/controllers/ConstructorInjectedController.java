package com.spring.learndi.controllers;

import com.spring.learndi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

    @Qualifier("constructorGreetingService")
    @Autowired
    private final GreetingService greetingService;

    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService gs) {
        this.greetingService = gs;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
