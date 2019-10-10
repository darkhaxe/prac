package experiment.designerpattern.bridge.demo;

public class SpUrgencyMessage extends AbstractMessage {

    public SpUrgencyMessage(MessageImplementor impl) {
        super(impl);
    }

    public void sendMessage(String msg, String user) {
        msg = "特别加急:" + msg;
        super.sendMessage(msg, user);
    }

    /**
     * 拓展:催促特急消息
     */
    public void hurry(String msgId) {

    }
}
