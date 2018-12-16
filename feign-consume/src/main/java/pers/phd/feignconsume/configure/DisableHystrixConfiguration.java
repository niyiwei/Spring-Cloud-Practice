package pers.phd.feignconsume.configure;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 禁用Hystrix 可以全局禁用 feign.hystrix.enabled=false
 * 也可以通过定义 @Scope("prototype")注解为指定的客户端配置Feign.Builder实例
 *
 * @author panhaidong
 * @date 2018-12-16 20:57
 */
//@Configuration
public class DisableHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
