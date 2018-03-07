package com.rabbit.base;

import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by asus on 2017/11/7.
 */
public class Sender extends BaseConnector {
    private static final String queueName="test";

    public Sender(String queueName) throws Exception {
        super(queueName);
    }

    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",queueName, null, SerializationUtils.serialize(object));
    }
}
