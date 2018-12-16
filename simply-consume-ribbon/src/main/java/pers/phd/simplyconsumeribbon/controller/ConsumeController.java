package pers.phd.simplyconsumeribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.phd.simplyconsumeribbon.service.HelloService;

/**
 * @author panhaidong
 * @date 2018-12-15 11:11
 */
@RestController
public class ConsumeController {
    @Autowired
    private HelloService helloService;

    @GetMapping(path = "/ribbon-consumer")
    public String helloConsumer() {
        return helloService.helloService();
    }
}
