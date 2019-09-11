package com.designerpattern.agileppp.visitorsample;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class PiecePart implements Part {
    private String itsPartNumber;
    private String itsDescription;
    private double itsCost;

    public PiecePart(String partNumber, String description, double cost) {
        itsPartNumber = partNumber;
        itsDescription = description;
        itsCost = cost;
    }

    public void accept(PartVisitor v) {
        v.visit(this);
    }

    public String getPartNumber() {
        return itsPartNumber;
    }

    public String getDescription() {
        return itsDescription;
    }

    public double getCost() {
        return itsCost;
    }
}
