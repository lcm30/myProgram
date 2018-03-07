package com.rabbit;

import com.rabbit.base.MessageProducer;
import com.rabbit.base.Receiver;
import com.rabbit.base.Sender;
import com.rabbit.domain.MessageInfo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by asus on 2017/11/7.
 */
public class Test {

    public static void main(String[] args) throws Exception{

        MessageProducer messageProducer = new MessageProducer();
        messageProducer.sendMessage("5555");

//        Receiver receiver = new Receiver("Queue");
//        Thread receiverThread = new Thread(receiver);
//        receiverThread.start();
       /* Sender sender = new Sender("Queue");
        for (int i = 0; i < 5; i++) {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.setChannel("ads");
            messageInfo.setContent("asdf" + i);
            sender.sendMessage(messageInfo);
        }*/
    }
}
