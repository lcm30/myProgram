package com.rabbit.base;

import com.rabbit.domain.MessageInfo;
import com.rabbitmq.client.*;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;

/**
 * Created by asus on 2017/11/7.
 */
public class Receiver extends BaseConnector implements Runnable,Consumer {
    private static final String queueName="test";
    public Receiver(String queueName) throws Exception {
        super(queueName);
    }

    //实现Runnable的run方法
    public void run() {
        try {
            channel.basicConsume(queueName, true,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 下面这些方法都是实现Consumer接口的
     **/
    //当消费者注册完成自动调用
    public void handleConsumeOk(String consumerTag) {
        System.out.println("Consumer "+consumerTag +" registered");
    }


    //下面这些方法可以暂时不用理会
    public void handleCancelOk(String consumerTag) {
    }
    public void handleCancel(String consumerTag) throws IOException {
    }
    public void handleShutdownSignal(String consumerTag,
                                     ShutdownSignalException sig) {
    }
    public void handleRecoverOk(String consumerTag) {
    }
    //当消费者接收到消息会自动调用
    @Override
    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        MessageInfo messageInfo = (MessageInfo) SerializationUtils.deserialize(bytes);
        System.out.println("Message ( "
                + "channel : " + messageInfo.getChannel()
                + " , content : " + messageInfo.getContent()
                + " ) received.");

    }
}
