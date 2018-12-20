package pers.phd.simplyapigateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SimplyApiGatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SimplyApiGatewayApplication.class).web(true).run(args);
    }
}

