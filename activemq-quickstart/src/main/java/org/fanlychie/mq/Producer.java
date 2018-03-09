package org.fanlychie.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * 生产者
 * Created by Fanlychie on 2018/3/5.
 */
public class Producer {

    public static void main(String[] args) throws Exception {
        // 连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.139.129:61616");
        // 创建一条连接
        Connection conn = factory.createConnection();
        // 启动连接
        conn.start();
        // 创建会话
        Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
        // 发送目的地
        Destination destination = session.createQueue("TEST.QUEUE");
        // 消息生产者
        MessageProducer producer = session.createProducer(destination);
        // 持久化（MQ重启后消息不会丢失）
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        // 文本内容消息
        TextMessage message = session.createTextMessage("=== Hello ActiveMQ ===");
        // 发送到目的地
        producer.send(message);
        // 提交事务
        session.commit();
        // 关闭连接
        conn.close();
    }

}