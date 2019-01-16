package pers.phd.busrabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Pundix055
 * @date 2019-01-16 15:33.
 */
@Slf4j
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "hello-queue", durable = "true")
                , exchange = @Exchange(value = "hello-exchange", type = ExchangeTypes.FANOUT)
                , key = "hello-key")
)
public class Receiver {

    @RabbitHandler
    public void process(String context) {
        log.info("Receiver :{}", context);
    }
}