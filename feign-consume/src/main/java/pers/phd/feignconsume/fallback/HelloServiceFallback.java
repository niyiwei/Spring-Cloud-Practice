package pers.phd.feignconsume.fallback;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import pers.phd.feignconsume.entity.User;
import pers.phd.feignconsume.service.HelloService;

/**
 * HelloService 服务降级实现类
 *
 * @author panhaidong
 * @date 2018-12-16 21:06
 */
@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(@RequestParam("name") String name) {
        return "error" + name;
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User("错误", 0);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "error";
    }
}