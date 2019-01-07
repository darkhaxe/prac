package rabbitmq.quickstart;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 原始的监听方法
 * @author haze
 * @date created at 2018/9/27 下午8:35
 */
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.198.210");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("haxe");
        factory.setPassword("123");
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();

        String queueName = "test001";
        //声明队列
        channel.queueDeclare(queueName, true, false, false, null);
        //创建消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //设置channel
        channel.basicConsume(queueName, true, consumer);
        //获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            System.out.println("消费:" + new String(delivery.getBody()));
        }

//        String body = "hello,rabbit";
//
//        channel.basicPublish("", "test001", null, body.getBytes());
//
//        channel.close();
//        conn.close();
    }
}
