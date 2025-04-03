package com.polarbookshop.catalog_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/catalog")
public class HomeController {

    @GetMapping("/getGreeting")
    public String getGreeting() {
        return "Welcome to book catalog!";
    }
}
