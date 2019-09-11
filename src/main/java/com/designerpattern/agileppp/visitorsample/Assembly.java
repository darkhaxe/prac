package com.designerpattern.agileppp.visitorsample;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class Assembly implements Part {

    private List itsParts = new LinkedList();
    private String itsPartNumber;
    private String itsDescription;

    public Assembly(String partNumber, String description) {
        itsPartNumber = partNumber;
        itsDescription = description;
    }

    public void accept(PartVisitor v) {
        v.visit(this);
        Iterator i = getParts();
        while (i.hasNext()) {
            Part p = (Part) i.next();
            p.accept(v);
        }
    }

    public void add(Part part) {
        itsParts.add(part);
    }

    public Iterator getParts() {
        return itsParts.iterator();
    }


    public String getPartNumber() {
        return null;
    }

    public String getDescription() {
        return null;
    }
}
