package pers.phd.simply.service;

import org.springframework.web.bind.annotation.*;
import pers.phd.simply.dto.User;

/**
 * @author panhaidong
 * @date 2018-12-15 21:18
 */
@RequestMapping(path = "/refactory")
public interface HelloService {


    @GetMapping(path = "/hello4")
    String hello(@RequestParam("name") String name);

    @GetMapping(path = "/hello5")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping(path = "/hello6")
    String hello(@RequestBody User user);
}