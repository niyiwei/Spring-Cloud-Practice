package pers.phd.simplyprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SimplyProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplyProviderApplication.class, args);
    }

}

