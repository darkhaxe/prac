package experiment.designerpattern.agileppp.nonCirculationVisitor;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class HayesModem implements Modem {
    public void dial(String pno) {

    }

    public void hangup() {

    }

    public void send(char c) {

    }

    public char recv() {
        return 0;
    }

    public void accept(ModemVisitor v) {
        try {
            HayesModemVisitor hv = (HayesModemVisitor)v;
            hv.visit(this);
        } catch (ClassCastException e) {

        }
    }

    String configurationString = null;
}
