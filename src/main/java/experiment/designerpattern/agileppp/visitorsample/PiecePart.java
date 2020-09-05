package experiment.designerpattern.agileppp.visitorsample;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class PiecePart implements Part {
    private String partNumber;
    private String desc;
    private double cost;

    /**
     *
     * @param partNumber 部件编码
     * @param description 描述
     * @param cost 成本
     */
    public PiecePart(String partNumber, String description, double cost) {
        this.partNumber = partNumber;
        desc = description;
        this.cost = cost;
    }

    @Override
    public void accept(PartVisitor v) {
        v.visit(this);
    }

    @Override
    public String getPartNumber() {
        return partNumber;
    }

    @Override
    public String getDescription() {
        return desc;
    }

    public double getCost() {
        return cost;
    }
}
