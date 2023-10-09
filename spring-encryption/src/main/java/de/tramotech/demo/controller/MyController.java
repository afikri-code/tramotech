package de.tramotech.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/")
public class MyController {
    @Value("${spring.datasource.password}")
    String myValue;

    @GetMapping
    String getMessage() {
        return "hello " + myValue ;
    }
}
