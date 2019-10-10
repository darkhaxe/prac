package experiment.designerpattern.bridge.demo;

public class MessageEmail implements MessageImplementor {
    @Override
    public void send(String msg, String user) {
        System.out.println("发送邮件:" + msg + "-- user:" + user);
    }
}
