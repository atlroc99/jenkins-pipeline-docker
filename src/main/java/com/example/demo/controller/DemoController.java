package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/test")
    public String test() {
        logger.info("Inside test endpoint...");

        return "<h1 style=background-color: red>test-success</h1>";
    }
}
