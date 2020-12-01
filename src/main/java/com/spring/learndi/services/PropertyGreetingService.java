package com.spring.learndi.services;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class PropertyGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello world - property";
    }
}
