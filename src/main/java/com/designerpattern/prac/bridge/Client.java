package com.designerpattern.prac.bridge;

import com.designerpattern.prac.bridge.demo.*;

public class Client {
    public static void main(String[] args) {
        String msg = "喝茶";
        String user = "jet";
        AbstractMessage commonMessage;
        AbstractMessage urgencyMessage;

        //sms发送 普通消息
        MessageImplementor smsImpl = new MessageSMS();
        commonMessage = new CommonMessage(smsImpl);
        commonMessage.sendMessage(msg, user);
        urgencyMessage = new UrgencyMessage(smsImpl);
        urgencyMessage.sendMessage(msg, user);

        //email发送 加急消息
        MessageImplementor emailImpl = new MessageEmail();
        commonMessage = new CommonMessage(emailImpl);
        commonMessage.sendMessage(msg, user);
        urgencyMessage = new UrgencyMessage(emailImpl);
        urgencyMessage.sendMessage(msg, user);


    }
}
