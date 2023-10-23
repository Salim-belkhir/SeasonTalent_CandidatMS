package fr.polytech.Candidat.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Try {

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/candidat")
    public String goodbye() {
        return "Goodbye World!";
    }
}
