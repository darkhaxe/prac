package designerpattern.agileppp.nonCirculationVisitor;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class ErnieModem implements Modem {

    @Override
    public void dial(String pno) {

    }

    @Override
    public void hangup() {

    }

    @Override
    public void send(char c) {

    }

    @Override
    public char recv() {
        return 0;
    }

    @Override
    public void accept(ModemVisitor v) {
        try {
            ErnieModemVisitor ev = (ErnieModemVisitor) v;
            ev.visit(this);
        } catch (ClassCastException e) {

        }
    }

    String internalPattern = null;
}
