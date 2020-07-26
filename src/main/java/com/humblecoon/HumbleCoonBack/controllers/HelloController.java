package com.humblecoon.HumbleCoonBack.controllers;

import com.humblecoon.HumbleCoonBack.entities.User;
import com.humblecoon.HumbleCoonBack.services.GreetingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final GreetingService service;

    public HelloController(GreetingService service) {
        this.service = service;
    }

    @RequestMapping("/hello")
    public User hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return service.greet(name);
    }
}
