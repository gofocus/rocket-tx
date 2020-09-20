package com.mashibing.producer.compent;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Consumer {

    String consumerGroup = "consumer-group";
    DefaultMQPushConsumer consumer;

    @Autowired
    OrderListener orderListener;
    
    @PostConstruct
    public void init() throws MQClientException {
        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.subscribe("order","*");
        consumer.registerMessageListener(orderListener);

        // 2次失败 就进私信队列
        consumer.setMaxReconsumeTimes(2);
        consumer.start();
    }
}