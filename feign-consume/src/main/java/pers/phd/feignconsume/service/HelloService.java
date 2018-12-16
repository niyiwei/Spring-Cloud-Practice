package pers.phd.feignconsume.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pers.phd.feignconsume.configure.FeignFullLogConfiguration;
import pers.phd.feignconsume.entity.User;
import pers.phd.feignconsume.fallback.HelloServiceFallback;

/**
 * @author panhaidong
 * @date 2018-12-15 21:18
 */
//  configuration = DisableHystrixConfiguration.class
@FeignClient(value = "SIMPLY-PROVIDER", fallback = HelloServiceFallback.class, configuration = FeignFullLogConfiguration.class)
public interface HelloService {

    @GetMapping(path = "/hello")
    String hello();

    @GetMapping(path = "/hello1")
    String hello(@RequestParam("name") String name);

    @GetMapping(path = "hello2")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping(path = "/hello3")
    String hello(@RequestBody User user);
}