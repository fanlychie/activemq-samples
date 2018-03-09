package org.fanlychie.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by Fanlychie on 2018/3/7.
 */
@Component
public class MessageConsumerListener {

    @JmsListener(destination = "TEST.QUEUE1")
    public void mqQueue1MessageConsumer(String message) {
        System.out.println("===> [TEST.QUEUE1] 接收消息：" + message);
    }

    @JmsListener(destination = "TEST.QUEUE2")
    public void mqQueue2MessageConsumer(String message) {
        System.out.println("===> [TEST.QUEUE2] 接收消息：" + message);
    }

}