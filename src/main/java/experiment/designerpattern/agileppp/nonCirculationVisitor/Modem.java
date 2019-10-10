package com.designerpattern.agileppp.nonCirculationVisitor;

/**
 * Created by simjunbo on 2018-04-19.
 */
public interface Modem {
    public void dial(String pno);

    public void hangup();

    public void send(char c);

    public char recv();

    public void accept(ModemVisitor v);
}
