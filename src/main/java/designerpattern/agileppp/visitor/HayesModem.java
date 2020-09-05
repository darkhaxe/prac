package designerpattern.agileppp.visitor;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class HayesModem implements Modem {
    @Override
    public void dial(String pno) {

    }

    @Override
    public void hangup() {

    }

    @Override
    public void send(char c) {

    }

    public char recv() {
        return 0;
    }

    @Override
    public void accept(ModemVisitor v) {
        v.visit(this);
    }

    String configurationString = null;
}