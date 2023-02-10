package com.febatis.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/hello-internet")
public class HelloWorldController {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World from Spring Boot";
    }
}