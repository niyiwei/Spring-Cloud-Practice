package pers.phd.simplyprovider.controller;

import org.springframework.web.bind.annotation.*;
import pers.phd.simplyprovider.entity.User;


/**
 * 测试的Controller
 *
 * @author panhaidong
 * @date 2018-12-14 19:37
 */
@RestController
public class SimplyController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello I am Simply provider!";
    }

    @GetMapping(path = "/hello1")
    public String hello1(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    @GetMapping(path = "/hello2")
    public User hello2(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    @PostMapping(path = "/hello3")
    public String hello3(@RequestBody User user) {
        return "Hello " + user.getName() + "," + user.getAge();
    }
}
