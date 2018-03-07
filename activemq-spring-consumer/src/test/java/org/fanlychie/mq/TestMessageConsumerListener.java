package org.fanlychie.mq;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by FanZhongYun on 2018/3/7.
 */
public class TestMessageConsumerListener {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("/spring-context.xml");
    }

}