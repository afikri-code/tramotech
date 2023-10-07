package de.tramotech.springbootkeycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SecureController {

    @GetMapping("/api")
    public String api(Principal principal) {
        if(principal != null)
            System.out.println(principal.getName());
        else
            System.out.println("hhhh");
        return "Hello, secured world!";
    }

    @GetMapping("/authenticated")
    public String secured(Principal principal) {
        if(principal != null)
            System.out.println(principal.getName());
        else
            System.out.println("hhhh");
        return "Hello, secured world!";
    }
}

