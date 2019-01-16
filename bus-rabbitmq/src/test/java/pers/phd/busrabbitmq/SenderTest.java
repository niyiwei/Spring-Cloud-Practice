package pers.phd.busrabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Pundix055
 * @date 2019-01-16 15:43.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusRabbitmqApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SenderTest {
    @Autowired
    private Sender sender;

    @Test
    public void sendTest() {
        sender.send();
    }
}
