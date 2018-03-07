package com.rabbit.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;

import javax.annotation.Resource;

/**
 * Created by asus on 2017/11/10.
 */
public class MessageProducer {
    private Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    @Resource
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Object message){
        logger.info("to send message:{}",message);
        amqpTemplate.convertAndSend("test",message);
    }
}
