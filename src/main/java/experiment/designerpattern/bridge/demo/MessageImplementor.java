package experiment.designerpattern.bridge.demo;

/**
 * 消息发送方式
 * sms,email
 */
public interface MessageImplementor {

    void send(String msg, String user);

}
