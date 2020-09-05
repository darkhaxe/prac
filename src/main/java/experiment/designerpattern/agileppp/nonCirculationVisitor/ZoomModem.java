package experiment.designerpattern.agileppp.nonCirculationVisitor;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class ZoomModem implements Modem {

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
            ZoomModemVisitor zv = (ZoomModemVisitor) v;
            zv.visit(this);
        } catch (ClassCastException e) {

        }
    }

    int configurationValue = 0;
}
