package com.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sergii Manko
 */
@RestController
public class SampleController {

    @GetMapping("/test")
    public String home() {
        return "Hello world";
    }
}