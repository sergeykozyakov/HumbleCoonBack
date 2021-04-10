package com.humblecoon.HumbleCoonBack.controllers;

import com.humblecoon.HumbleCoonBack.entities.User;
import com.humblecoon.HumbleCoonBack.entities.UserRequest;
import com.humblecoon.HumbleCoonBack.services.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private final GreetingService service;
    private final String defaultRequestValue = "Coon";

    public HelloController(GreetingService service) {
        this.service = service;
    }

    @RequestMapping("/hello")
    public User hello(@RequestParam(value = "name", defaultValue = defaultRequestValue) String name) {
        return service.greet(name);
    }

    @PostMapping("/hello_json")
    @ResponseBody
    public User helloJson(@RequestBody UserRequest request) {
        String name = request != null && request.getName() != null && !request.getName().equals("")
                ? request.getName()
                : defaultRequestValue;

        return service.greet(name);
    }
}
