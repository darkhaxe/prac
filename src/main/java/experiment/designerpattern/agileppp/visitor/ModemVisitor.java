package experiment.designerpattern.agileppp.visitor;

/**
 * Created by simjunbo on 2018-04-19.
 */
public interface ModemVisitor {
    public void visit(HayesModem modem);
    public void visit(ZoomModem modem);
    public void visit(ErnieModem modem);
}
