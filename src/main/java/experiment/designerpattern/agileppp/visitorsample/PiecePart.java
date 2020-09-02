package experiment.designerpattern.agileppp.visitorsample;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class PiecePart implements Part {
    private String itsPartNumber;
    private String itsDescription;
    private double itsCost;

    /**
     *
     * @param partNumber 部件编码
     * @param description 描述
     * @param cost 成本
     */
    public PiecePart(String partNumber, String description, double cost) {
        itsPartNumber = partNumber;
        itsDescription = description;
        itsCost = cost;
    }

    @Override
    public void accept(PartVisitor v) {
        v.visit(this);
    }

    @Override
    public String getPartNumber() {
        return itsPartNumber;
    }

    @Override
    public String getDescription() {
        return itsDescription;
    }

    public double getCost() {
        return itsCost;
    }
}
