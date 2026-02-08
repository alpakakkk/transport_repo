package com.example.transport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusController {

    @GetMapping("/index")
    public String printMessage(){
        return "hello";
    }
}
