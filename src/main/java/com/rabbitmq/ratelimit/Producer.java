package com.rabbitmq.ratelimit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author haze
 * @date created at 2018/9/27 下午8:34
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.198.210");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("haxe");
        factory.setPassword("123");
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();
        String body = "hello,rabbit";

        String routingKey = "qos.save";
        String exchange = "test_qos_exchange";

        for (int i = 0; i < 5; i++) {
            System.out.println("---");
            channel.basicPublish(exchange, routingKey, null, body.getBytes());
        }

        channel.close();
        conn.close();
    }
}
