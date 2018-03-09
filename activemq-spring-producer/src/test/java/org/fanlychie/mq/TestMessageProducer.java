package org.fanlychie.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Fanlychie on 2018/3/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-context.xml")
public class TestMessageProducer {

    @Autowired
    private MessageProducer messageProducer;

    @Test
    public void testSendQueue1Message() {
        messageProducer.sendQueue1Message("=== QUEUE 1 ===");
    }

    @Test
    public void testSendQueue2Message() {
        messageProducer.sendQueue2Message("=== QUEUE 2 ===");
    }

}