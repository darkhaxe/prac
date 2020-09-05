package experiment.designerpattern.agileppp.visitorsample;

/**
 * 汇总成本
 * Created by simjunbo on 2018-04-19.
 */
public class CalcTotalCostVisitor implements PartVisitor {
    private double cost = 0;

    public double getTotalCost() {
        return cost;
    }

    @Override
    public void visit(PiecePart p) {
        cost += p.getCost();
    }

    @Override
    public void visit(Assembly a) {

    }
}
