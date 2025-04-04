package com.polarbookshop.catalog_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.polarbookshop.catalog_service.config.PolarProperties;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/catalog")
@AllArgsConstructor
public class HomeController {

    private final PolarProperties polarProperties;

    @GetMapping("/getGreeting")
    public String getGreeting() {
        return polarProperties.getGreeting();
    }
}
