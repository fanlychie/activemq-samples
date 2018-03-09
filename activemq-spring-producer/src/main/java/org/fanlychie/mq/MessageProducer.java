package org.fanlychie.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by Fanlychie on 2018/3/6.
 */
@Component
public class MessageProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("mqQueue1")
    private Destination mqQueue1;

    @Autowired
    @Qualifier("mqQueue2")
    private Destination mqQueue2;

    public void sendQueue1Message(final String message) {
        jmsTemplate.send(mqQueue1, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                System.out.println("<=== [TEST.QUEUE1] 发送消息：" + message);
                return session.createTextMessage(message);
            }
        });
    }

    public void sendQueue2Message(final String message) {
        jmsTemplate.send(mqQueue2, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                System.out.println("<=== [TEST.QUEUE2] 发送消息：" + message);
                return session.createTextMessage(message);
            }
        });
    }

}