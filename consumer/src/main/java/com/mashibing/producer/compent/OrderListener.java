package com.mashibing.producer.compent;

import com.alibaba.fastjson.JSONObject;
import com.mashibing.producer.entity.OrderBase;
import com.mashibing.producer.service.PointsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class OrderListener implements MessageListenerConcurrently {

    @Autowired
    PointsService pointsService;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext context) {
        log.info("消费者线程监听到消息。");
        try{

            System.out.println(1/0);
            for (MessageExt message:list) {
                log.info("开始处理订单数据，准备增加积分....");
                OrderBase order  = JSONObject.parseObject(message.getBody(), OrderBase.class);
                pointsService.increasePoints(order);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }catch (Exception e){
            log.error("处理消费者数据发生异常。{}",e);
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
    }
}