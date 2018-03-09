package org.fanlychie.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * 消费者
 * Created by Fanlychie on 2018/3/5.
 */
public class Consumer {

    public static void main(String[] args) throws Throwable {
        // 连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.139.129:61616");
        // 创建一条连接
        Connection conn = factory.createConnection();
        // 启动连接
        conn.start();
        // 创建会话
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 发送目的地
        Destination destination = session.createQueue("TEST.QUEUE");
        // 消息消费者
        MessageConsumer consumer = session.createConsumer(destination);
        while (true) {
            // 接收消息
            TextMessage message = (TextMessage) consumer.receive();
            // 打印接收到的消息
            System.out.println(String.format("[接收消息]: %s", message.getText()));
        }
    }

}