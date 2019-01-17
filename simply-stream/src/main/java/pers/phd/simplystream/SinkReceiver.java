package pers.phd.simplystream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Pundix055
 * @date 2019-01-16 17:41.
 */
@Slf4j
@EnableBinding(value = {Sink.class})
public class SinkReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(Object playload) {
        log.info("Received: {}", playload);
    }

    // 消息转换
    @Transformer(inputChannel = SinkSender.SinkOutput.OUTPUT, outputChannel = SinkSender.SinkOutput.OUTPUT)
    public Object transform(Date message) {
        log.info("执行消息转换:{}", message);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
    }

    // 使用ServiceActivator 替换 StreamListener
    @ServiceActivator(inputChannel = SinkSender.SinkOutput.OUTPUT)
    public void receiveByOutputTest(Object object) {
        log.info("ServiceActivator classType:{}, Received: {}", object.getClass().getSimpleName(), object);
    }
}
