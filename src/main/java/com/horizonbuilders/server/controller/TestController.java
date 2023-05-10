package com.horizonbuilders.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @GetMapping("/test")
    public List<String> getSampleString() {
        return List.of("Bekzhan", "Nazima", "Zhoomart", "Aigul");
    }
}
