package experiment.designerpattern.bridge.badCase;

/**
 * 短信发送
 */
public class CommonMessageSMS implements Message {

    @Override
    public void send(String msg, String toUser) {
        System.out.println("发送站内短消息:" + msg + "-- user:" + toUser);
    }
}
