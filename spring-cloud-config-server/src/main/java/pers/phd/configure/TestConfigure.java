package pers.phd.configure;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author panhaidong
 * @date 2018-12-12 21:38
 */
@Configuration
@Data
public class TestConfigure {

    @Value("${foo}")
    private String name;
}
