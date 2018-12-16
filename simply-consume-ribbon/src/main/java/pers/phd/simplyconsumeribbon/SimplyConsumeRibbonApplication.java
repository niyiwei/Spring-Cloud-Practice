package pers.phd.simplyconsumeribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 简单的消费者实例.
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class SimplyConsumeRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplyConsumeRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

