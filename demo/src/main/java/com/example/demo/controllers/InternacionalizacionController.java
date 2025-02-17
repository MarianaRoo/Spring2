package com.example.demo.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternacionalizacionController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/saludo")
    public String obtenerSaludo(@RequestParam(name = "leng", defaultValue = "en") String leng) {
        Locale locale;

        
        if ("es".equalsIgnoreCase(leng)) {
            locale = new Locale("es", "ES"); 
        } else {
            locale = Locale.ENGLISH; 
        }

        
        return messageSource.getMessage("welcome.message", null, locale);
    }
}
