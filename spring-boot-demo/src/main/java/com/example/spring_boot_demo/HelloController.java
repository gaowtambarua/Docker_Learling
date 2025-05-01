package com.example.spring_boot_demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHellow() {
        return "Hellow Spring Boot! Welcome! ";
    }
}
