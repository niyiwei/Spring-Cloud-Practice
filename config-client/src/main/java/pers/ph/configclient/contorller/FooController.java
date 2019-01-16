package pers.ph.configclient.contorller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pundix055
 * @date 2019-01-15 15:38.
 */
@Configuration
@EnableAutoConfiguration
@RestController
@RefreshScope
@Slf4j
public class FooController {
    @Value("${foo:default-foo}")
    private String foo;

    @Value("${overview:default-overview}")
    private String overview;

    @GetMapping(path = "/test")
    public String getFoo() {
        log.info("foo:{}, overview:{}", foo, overview);
        return foo + "-" + overview;
    }
}
