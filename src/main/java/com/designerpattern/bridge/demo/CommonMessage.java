package com.designerpattern.bridge.demo;

public class CommonMessage extends AbstractMessage {
    public CommonMessage(MessageImplementor impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String user) {
        super.sendMessage(message, user);
    }
}
