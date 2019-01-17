package pers.phd.simplystream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Pundix055
 * @date 2019-01-17 10:16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SimplyStreamApplication.class)
public class SenderTest {

    @Autowired
    private MessageChannel input;

    @Test
    public void sendTest() {
        System.out.println(input.send(MessageBuilder.withPayload("From MessageChannel").build()));
    }
}