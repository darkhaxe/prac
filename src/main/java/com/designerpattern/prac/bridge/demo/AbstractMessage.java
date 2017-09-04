package com.designerpattern.prac.bridge.demo;

/**
 * 基础的抽象类:消息发送
 */
public abstract class AbstractMessage {
    //分离 发送行为 与 发送方式
    protected MessageImplementor impl;//具体的实现方式去转调

    public AbstractMessage(MessageImplementor impl) {
        this.impl = impl;
    }

    /**
     * 转调 实现 的发送方法
     */
    public void sendMessage(String msg, String user) {
        this.impl.send(msg, user);
    }
}
