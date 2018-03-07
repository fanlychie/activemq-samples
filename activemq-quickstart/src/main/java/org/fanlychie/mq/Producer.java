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
        // 非持久化, MQ 重启后消息会丢失, 视场景而定
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        // 发送 20 条消息
        for (int i = 0; i < 20; i++) {
            // 文本内容消息
            TextMessage message = session.createTextMessage(String.format("第 %d 条消息", i + 1));
            // 发送到目的地
            producer.send(message);
        }
        // 提交事务
        session.commit();
        // 关闭连接
        conn.close();
    }

}