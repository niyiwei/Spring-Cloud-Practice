package pers.phd.simplyconsumeribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author panhaidong
 * @date 2018-12-15 19:36
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        return restTemplate.getForEntity("http://SIMPLY-PROVIDER/hello", String.class).getBody();
    }

    /**
     * 断路器调用方法
     *
     * @return String.
     */
    public String helloFallback() {
        return "error";
    }
}
