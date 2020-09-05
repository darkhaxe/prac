package designerpattern.bridge.badCase;

public interface Message {
    /**
     * @param msg    要发送的消息内容
     * @param toUser 消息目的用户
     */
    void send(String msg, String toUser);
}
