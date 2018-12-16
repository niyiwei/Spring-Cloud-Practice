package pers.phd.feignconsume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.phd.feignconsume.entity.User;
import pers.phd.feignconsume.service.HelloService;
import pers.phd.feignconsume.service.RefactorHelloService;

/**
 * @author panhaidong
 * @date 2018-12-15 21:23
 */
@RestController
public class ConsumerController {
    @Autowired
    private HelloService helloService;
    @Autowired
    private RefactorHelloService refactorHelloService;

    @GetMapping(path = "/feign-consumer")
    public String helloConsumer() {
        return helloService.hello();
    }

    @GetMapping(path = "/feign-consumer2")
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("PHD")).append("\n");
        sb.append(helloService.hello("PHD", 24)).append("\n");
        sb.append(helloService.hello(new User("PHD", 24))).append("\n");
        System.out.println(sb.toString());
        return sb.toString();
    }

    @GetMapping(path = "/feign-consumer3")
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("BXM")).append("\n");
        sb.append(refactorHelloService.hello("BXM", 23)).append("\n");
        sb.append(refactorHelloService.hello(new pers.phd.simply.dto.User("BXM", 23))).append("\n");
        System.out.println(sb.toString());
        return sb.toString();
    }
}
