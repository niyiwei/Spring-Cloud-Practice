package pers.phd.simply.service;

import org.springframework.web.bind.annotation.*;
import pers.phd.simply.dto.User;

/**
 * 定义公共的请求接口方法
 *
 * @author panhaidong
 * @date 2018-12-15 21:18
 */
@RequestMapping(path = "/refactory")
public interface HelloService {

    /**
     * 打招呼方法 - 无参
     *
     * @param name
     * @return
     */
    @GetMapping(path = "/hello4")
    String hello(@RequestParam("name") String name);

    /**
     * 打招呼方法-头部参数
     *
     * @param name 名词
     * @param age  年龄
     * @return User.
     */
    @GetMapping(path = "/hello5")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    /**
     * 打招呼请求-Post请求
     *
     * @param user 传递用户信息
     * @return String.
     */
    @PostMapping(path = "/hello6")
    String hello(@RequestBody User user);
}