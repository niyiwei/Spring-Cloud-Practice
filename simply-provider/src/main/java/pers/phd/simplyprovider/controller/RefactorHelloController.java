package pers.phd.simplyprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.phd.simply.dto.User;
import pers.phd.simply.service.HelloService;

import java.util.Random;

/**
 * 实现引入公共API包
 *
 * @author panhaidong
 * @date 2018-12-16 18:07
 */
@RestController
public class RefactorHelloController implements HelloService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${spring.application.name}")
    private String serviceName;

    /**
     * 需要把参数的注解也定义过来，要不然映射不上
     *
     * @param name
     * @return
     */
    @Override
    public String hello(@RequestParam("name") String name) {
        ServiceInstance localInstance = discoveryClient.getInstances(serviceName).get(0);

        int sleepTime = new Random().nextInt(4000);
        System.out.println("sleepTime:" + sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("/hello, host:" + localInstance.getHost() + ", service_id:" + localInstance.getServiceId());
        return "Hello " + name + ": " + localInstance.getServiceId() + ":" + localInstance.getHost() + ":" + localInstance.getPort();
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}
