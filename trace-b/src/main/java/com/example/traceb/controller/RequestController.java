package com.example.traceb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pundix055
 * @date 2019-01-17 15:07.
 */
@RestController
@Slf4j
public class RequestController {

    @GetMapping(path = "/trace")
    public String trace() {
        log.info("===call trace-b===");
        return "hello-trace-b";
    }
}
