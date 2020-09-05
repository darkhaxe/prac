package designerpattern.bridge.demo;

public class UrgencyMessage extends AbstractMessage {

    public UrgencyMessage(MessageImplementor impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String msg, String user) {
        msg = "加急:" + msg;
        super.sendMessage(msg, user);
    }

    /**
     * 拓展:加上监控消息处理的功能
     */
    public Object watch(String msgId) {
        return null;
    }
}
