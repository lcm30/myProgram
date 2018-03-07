package com.rabbit.base;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by asus on 2017/11/7.
 */
public class BaseConnector {
    protected Channel channel;
    protected Connection connection;
    protected String queueName;
    public BaseConnector(String queueName) throws Exception {
        this.queueName = queueName;
        //打开连接和创建频道
        ConnectionFactory factory = new ConnectionFactory();
        //设置MabbitMQ所在主机ip或者主机名  127.0.0.1即localhost
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("rabbitmq_test01");
        factory.setPassword("123456");
        factory.setVirtualHost("test_vhosts");
        //创建连接
        connection = factory.newConnection();
        //创建频道
        channel = connection.createChannel();
        //声明创建队列
        channel.queueDeclare(queueName, false, false, false, null);
    }
}
