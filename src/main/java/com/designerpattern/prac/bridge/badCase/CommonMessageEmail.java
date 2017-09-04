package com.designerpattern.prac.bridge.badCase;

/**
 * 邮件发送
 */
public class CommonMessageEmail implements Message {
    @Override
    public void send(String msg, String toUser) {
        System.out.println("发送邮件:" + msg + "-- user:" + toUser);
    }
}
