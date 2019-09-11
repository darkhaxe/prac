package com.designerpattern.agileppp.visitorsample;

/**
 * Created by simjunbo on 2018-04-19.
 */
public interface Part {
    public String getPartNumber();
    public String getDescription();
    public void accept(PartVisitor v);
}
