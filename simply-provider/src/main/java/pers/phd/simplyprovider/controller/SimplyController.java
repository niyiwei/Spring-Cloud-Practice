package pers.phd.simplyprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;


/**
 * 测试的Controller
 *
 * @author panhaidong
 * @date 2018-12-14 19:37
 */
@RestController
public class SimplyController {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(path = "/hello")
    public String hello() {
        System.out.println("client description:" + discoveryClient.description());
        List<String> serviceList = discoveryClient.getServices();
        for (String service : serviceList) {
            System.out.println(service);
        }
        System.out.println();
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("simply-provider");
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            System.out.println(serviceInstance.getHost() + "," + serviceInstance.getPort() + "," + serviceInstance.getUri() + "," + serviceInstance.getScheme() + "," + serviceInstance.getServiceId() + "," + serviceInstance.getMetadata());
        }
        return "Hello I am Simply provider!";
    }
}
