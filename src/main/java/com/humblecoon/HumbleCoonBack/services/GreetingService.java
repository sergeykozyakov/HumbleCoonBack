package com.humblecoon.HumbleCoonBack.services;

import com.humblecoon.HumbleCoonBack.entities.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public User greet(String name) {
        return new User(counter.incrementAndGet(), String.format(template, name));
    }
}
