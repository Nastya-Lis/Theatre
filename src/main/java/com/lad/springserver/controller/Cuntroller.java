package com.lad.springserver.controller;

import com.lad.springserver.SpringserverApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Cuntroller {
    @GetMapping
    String hello(){
        return "hello motherfucker";
    }
}
