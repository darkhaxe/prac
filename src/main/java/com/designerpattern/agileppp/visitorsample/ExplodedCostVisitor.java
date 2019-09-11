package com.designerpattern.agileppp.visitorsample;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class ExplodedCostVisitor implements PartVisitor {
    private double cost = 0;

    public double coast() {
        return cost;
    }

    public void visit(PiecePart p) {
        cost += p.getCost();
    }

    public void visit(Assembly a) {

    }
}
