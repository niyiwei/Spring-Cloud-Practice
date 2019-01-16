package pers.phd.busrabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Pundix055
 * @date 2019-01-16 15:29.
 */
@Component
@Slf4j
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "hello " + LocalDateTime.now().toString().replace("'T'", " ");
        log.info("Sender :{}", context);
        amqpTemplate.convertAndSend("hello-exchange", "hello-key", context);
    }
}