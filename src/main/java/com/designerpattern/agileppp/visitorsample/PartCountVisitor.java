package com.designerpattern.agileppp.visitorsample;

import java.util.HashMap;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class PartCountVisitor implements PartVisitor {
    private int itsPieceCount = 0;
    private HashMap itsPieceMap = new HashMap();

    public void init(PiecePart p) {

    }

    public void visit(PiecePart pp) {
        itsPieceCount++;
        String partNumber = pp.getPartNumber();
        int partNumberCount = 0;
        if (itsPieceMap.containsKey(partNumber)) {
            Integer carrier = (Integer) itsPieceMap.get(partNumber);
            partNumberCount = carrier.intValue();
        }

        partNumberCount++;
        itsPieceMap.put(partNumber, new Integer(partNumberCount));
    }

    public void visit(Assembly a) {

    }

    public int getPieceCount() {
        return itsPieceCount;
    }

    public int getPartNumberCount() {
        return itsPieceMap.size();
    }

    public int getCountForPart(String partNumber) {
        int partNumberCount = 0;
        if (itsPieceMap.containsKey(partNumber)) {
            Integer carrier = (Integer) itsPieceMap.get(partNumber);
            partNumberCount = carrier.intValue();
        }
        return partNumberCount;
    }
}
