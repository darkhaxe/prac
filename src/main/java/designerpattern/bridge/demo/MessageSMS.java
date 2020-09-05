package designerpattern.bridge.demo;

public class MessageSMS implements MessageImplementor {

    @Override
    public void send(String msg, String user) {
        System.out.println("发送站内短消息:" + msg + "-- user:" + user);
    }
}
