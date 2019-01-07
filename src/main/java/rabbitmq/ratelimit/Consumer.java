package rabbitmq.ratelimit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 原始的监听方法
 *
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

        String exchange = "test_qos_exchange";
        String queueName = "test_qos_queue";
        String routingkey = "qos.#";

        //
        channel.exchangeDeclare(exchange, "topic", true, false, null);
        //声明队列
        channel.queueDeclare(queueName, true, false, false, null);

        channel.queueBind(queueName, exchange, routingkey);

        //限流
//        1.
        boolean autoAck = false;
        channel.basicConsume(queueName, autoAck, new MyConsumer(channel));
//        2.
        channel.basicQos(0, 3, false);

        channel.close();
        conn.close();
    }

    private static class MyConsumer extends DefaultConsumer {

        private Channel channel;

        /**
         * Constructs a new instance and records its association to the passed-in channel.
         *
         * @param channel the channel to which this consumer is attached
         */
        public MyConsumer(Channel channel) {
            super(channel);
            this.channel = channel;
        }

        @Override
        public void handleDelivery(String consumerTag, Envelope envelope,
                                   AMQP.BasicProperties properties, byte[] body) throws IOException {
//            super.handleDelivery(consumerTag, envelope, properties, body);
            System.out.println("consumerTag:" + consumerTag);
            System.out.println("envelope:" + envelope);
            System.out.println("properties:" + properties);
            System.out.println("body:" + new String(body));

            channel.basicAck(envelope.getDeliveryTag(), false);
        }

    }
}
