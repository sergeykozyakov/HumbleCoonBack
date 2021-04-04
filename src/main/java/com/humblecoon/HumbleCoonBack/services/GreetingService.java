package com.humblecoon.HumbleCoonBack.services;

import com.humblecoon.HumbleCoonBack.entities.User;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private static final String template = "Hello %s!";

    public User greet(String name) {
        return new User(1L, String.format(template, name));
    }
}
