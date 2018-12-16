package pers.phd.simplyprovider;

import com.netflix.ribbon.RequestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@EnableDiscoveryClient
@SpringBootApplication
public class SimplyProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplyProviderApplication.class, args);
    }
}

