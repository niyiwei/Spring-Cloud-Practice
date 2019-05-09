package com.example.tracea.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Pundix055
 * @date 2019-01-17 14:56.
 */
@RestController
@Slf4j
public class RequestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/trace")
    public String trace() {
        log.info("===call trace-a===");
        return restTemplate.getForEntity("http://trace-b/trace", String.class).getBody();
    }
}
