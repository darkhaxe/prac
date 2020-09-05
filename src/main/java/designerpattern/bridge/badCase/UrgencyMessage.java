package designerpattern.bridge.badCase;

/**
 * 加急消息
 * 同样需要sms,email两种发送方式
 */
public interface UrgencyMessage extends Message {
    /**
     * 监控消息处理过程
     *
     * @param msgId
     * @return
     */
    Object watch(String msgId);
}
